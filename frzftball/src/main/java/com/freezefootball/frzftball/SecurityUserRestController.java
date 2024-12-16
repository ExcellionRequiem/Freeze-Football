package com.freezefootball.frzftball;

import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityUserRestController {
    
    //Inicializacion del controlador con el manager de la documentación de Spring Security
    private final UserList userList;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(SecurityUserRestController.class);
    public SecurityUserRestController(UserList userList,
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
        return "redirect:/login.html";
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
