package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    // otros métodos según sea necesario
}
