package com.freezefootball.frzftball;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserList {
    public List<String> loggedUsers;
    public Map<String, String> registeredUsers;
    public UserList(){
        loggedUsers = new ArrayList<>();
        registeredUsers = loadRegisteredUsers();
    }

    //Método propio para añadir usuarios cuando se registren
    public void registerUser(String username, String encodedPassword) {
        if (!registeredUsers.containsKey(username)) {
            registeredUsers.put(username, encodedPassword);
            saveRegisteredUsers(); // Guardamos la lista de usuarios registrados cada vez que un nuevo usuario se registre
        }
    }

    //Si un usuario se logea, metemos su username en la lista de usuarios logeados
    public void LogInUser(String username) {
        if (!loggedUsers.contains(username)) {
            loggedUsers.add(username);
        }
    }

    //Cuando se desconecte, llamaremos a este método para que aparezca desconectado
    public void LogOutUser(String username) {
        loggedUsers.remove(username);
    }

    // Método para comprobar si un usuario ya está registrado
    public boolean isUserRegistered(String username) {
        return registeredUsers.containsKey(username);
    }

    // Método para comprobar si un usuario ya está logueado
    public boolean isUserLoggedIn(String username) {
        return loggedUsers.contains(username);
    }

    // Obtener la lista de usuarios registrados
    public Map<String, String> getRegisteredUsers() {
        return registeredUsers;
    }

    // Obtener la lista de usuarios logueados
    public List<String> getLoggedUsers() {
        return loggedUsers;
    }

    // Cargar los usuarios registrados desde el archivo
    private Map<String, String> loadRegisteredUsers() {
        Path path = Path.of("savedData/registeredUsers.ser");

        if (!Files.exists(Path.of("savedData"))) {
            try {
                Files.createDirectories(Path.of("savedData")); // Crear la carpeta 'savedData' si no existe ya
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Ahora cargamos el archivo (si existe)
        if (Files.exists(path)) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("savedData/registeredUsers.ser"))) {
                return (Map<String, String>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //Y lo devolvemos si existe, si no pues dará error antes
        return new HashMap<>();
    }

    // Guardamos los usuarios registrados en el archivo
    private void saveRegisteredUsers() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("savedData/registeredUsers.ser"))) {
            outputStream.writeObject(registeredUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
