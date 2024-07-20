package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

