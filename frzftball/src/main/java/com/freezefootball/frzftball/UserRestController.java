package com.freezefootball.frzftball;

import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
//

@Controller
public class UserRestController {
    
    //Inicializacion del controlador con el manager de la documentación de Spring Security
    private final UserList userList;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private LeaderboardService leaderboardService;
    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
    public UserRestController(UserList userList,
                                        PasswordEncoder passwordEncoder) {
        this.userList = userList;
        this.passwordEncoder = passwordEncoder;
	}

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "loggedOut", defaultValue = "false") String loggedOut, Model model) {
        //logger.info(userList.getLoggedUsers().get(0));
        
        return "redirect:/login.html";  // Devuelve la pagina login.html de src\main\resources\templates
    }

    @GetMapping("/register")
    public String registerPage() {
        return "redirect:/register.html";  // Devuelve la pagina register.html de src\main\resources\templates
    }

    @PostMapping("/login")
    public String login(@RequestParam(required = false) String username, @RequestParam(required = false) String password, 
                        @RequestParam(required = false) String logout, Model model, HttpSession session){
        if ("true".equals(logout)) {
            // Perform logout logic if the logout parameter is present
            String loggedOutUser = (String) session.getAttribute("username");
    
            if (loggedOutUser != null) {
                logger.info("Logging out user: " + loggedOutUser);
                userList.LogOutUser(loggedOutUser);
            }
            
            session.invalidate();  // Invalidate the session
            return "redirect:/login.html";  // Redirect to login after logout
        }
        
        if (userList.isUserLoggedIn(username)) {
            logger.error("El usuario ya está actualmente logueado");
            return "redirect:/login.html"; // El usuario ya está logueado
        }
        
        if (!userList.isUserRegistered(username)) {
            logger.error("Usuario no encontrado");
            return "redirect:/login.html"; // El usuario no está registrado, no puede loguearse
        }
        
        //Recuperamos la contraseña guardada del usuario y la comparamos con la que recibimos
        String encodedPassword = userList.getRegisteredUsers().get(username);
        if (!passwordEncoder.matches(password, encodedPassword)) {
            logger.error("Contraseña incorrecta");
            return "redirect:/login.html"; // Contraseña incorrecta, error de no autorizacion
        }

        //Logueamos
        userList.LogInUser(username);

        // Store username in the session
        session.setAttribute("username", username);

        return "redirect:/index.html";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        // Check if user already exists
        if (userList.isUserRegistered(username)) {
           logger.error("El usuario ya está registrado");
            return "redirect:/register.html"; // El usuario ya está registrado
        }

        String encodedPassword = passwordEncoder.encode(password);

        // Hash the password and create a new user
        userList.registerUser(username, encodedPassword); // Guardamos el nuevo usuario con su contraseña cifrada

        LeaderboardEntry newEntry = new LeaderboardEntry();
        newEntry.setUsername(username);
        newEntry.setScore(0); // Initialize score to 0
        newEntry.setWins(0);

        //Esto de aqui es un restTemplate
        //Es un mago oscuro que ya viene definido en spring
        //Y esto es magia negra para ejecutar un metodo http desde un metodo http
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<LeaderboardEntry> requestEntity = new HttpEntity<>(newEntry, headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/leaderboards", 
            HttpMethod.POST, requestEntity, String.class); //Esto es lo que llama al PUT de las leaderboards

        return "redirect:/login.html";
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        String username = (String) session.getAttribute("username");
        
        userList.LogOutUser(username);  // Call the LogOutUser method to remove the user
        System.out.println("User logged out: " + username);
    }

    public static class RegisterRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public record LoginRequest(String username, String password) {
	}

}
