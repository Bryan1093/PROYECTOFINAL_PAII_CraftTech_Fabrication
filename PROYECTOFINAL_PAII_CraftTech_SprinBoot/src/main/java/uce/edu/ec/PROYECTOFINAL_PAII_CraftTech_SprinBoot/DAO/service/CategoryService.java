package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.ICategoryDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.ICategoryService;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.Category;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDao ICategoryDao;

    @Override
    public Category findById(Long id) {
        return ICategoryDao.findById(id);
    }

    @Override
    public Category save(Category category) {
        return ICategoryDao.save(category);
    }

    @Override
    public void deleteById(Long id) {
        ICategoryDao.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return ICategoryDao.findAll();
    }
}
