package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IUserDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IUserService;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        System.out.println("Encontrado usuario: " + user);
        return user;
    }
}
