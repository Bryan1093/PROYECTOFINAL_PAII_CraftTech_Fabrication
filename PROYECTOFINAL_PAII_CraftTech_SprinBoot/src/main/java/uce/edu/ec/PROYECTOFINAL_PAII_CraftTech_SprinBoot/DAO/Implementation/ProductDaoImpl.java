package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IProductDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.repository.ProductRepository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.Product;

import java.util.List;

@Repository
public class ProductDaoImpl implements IProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
