package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    //Ya no pediremos por username sino por ID (1,2,3,etc,etc)
    @GetMapping("/{id}")
    public User getUserByUsername(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Validar y guardar el usuario
        return userService.save(user);
    }

    // otros métodos según sea necesario
}
