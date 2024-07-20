package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Validar y guardar el usuario
        return userService.save(user);
    }

    // otros métodos según sea necesario
}
