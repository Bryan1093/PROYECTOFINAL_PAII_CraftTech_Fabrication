package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;

import java.util.List;

public interface IUserService {
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
    List<User> findAll();
    User findByUsernameAndPassword(String username, String password);
}
