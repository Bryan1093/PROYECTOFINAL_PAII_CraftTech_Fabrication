package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IProductDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IProductService;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.Product;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDao IProductDao;

    @Override
    public Product findById(Long id) {
        return IProductDao.findById(id);
    }

    @Override
    public Product save(Product product) {
        return IProductDao.save(product);
    }

    @Override
    public void deleteById(Long id) {
        IProductDao.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return IProductDao.findAll();
    }
}
