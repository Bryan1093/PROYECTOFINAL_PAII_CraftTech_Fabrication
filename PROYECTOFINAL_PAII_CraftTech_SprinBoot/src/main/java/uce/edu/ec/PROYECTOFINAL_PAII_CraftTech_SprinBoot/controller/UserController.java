package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        // Verificar si es el usuario administrador predefinido
        if (user.getUsername().equals("@root") && user.getPassword().equals("@root")) {
            return ResponseEntity.ok("admin");
        }

        User foundUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser.getRole());
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
