package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.Product;

import java.util.List;

public interface IProductDao {
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findAll();
}
