package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
    List<Category> findAll();
}
