package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IOrderConsumerDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.repository.OrderConsumerRepository;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;

import java.util.List;
@Repository
public class OrderConsumerDaoImpl implements IOrderConsumerDao {

    @Autowired
    private OrderConsumerRepository orderConsumerRepository;

    @Override
    public OrderConsumer findById(Long id) {
        return orderConsumerRepository.findById(id).orElse(null);
    }

    @Override
    public OrderConsumer save(OrderConsumer orderConsumer) {
        return orderConsumerRepository.save(orderConsumer);
    }

    @Override
    public void deleteById(Long id) {
        orderConsumerRepository.deleteById(id);
    }

    @Override
    public List<OrderConsumer> findAll() {
        return orderConsumerRepository.findAll();
    }
}
