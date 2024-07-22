package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IUserDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.repository.UserRepository;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
