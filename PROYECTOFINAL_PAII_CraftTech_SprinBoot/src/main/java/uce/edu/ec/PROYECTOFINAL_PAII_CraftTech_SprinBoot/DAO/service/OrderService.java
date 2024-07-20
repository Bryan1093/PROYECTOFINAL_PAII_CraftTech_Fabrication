package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IOrderConsumerDao;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces.IOrderConsumerService;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.repository.OrderConsumerRepository;
import java.util.List;

@Service
public class OrderService implements IOrderConsumerService {

    @Autowired
    private IOrderConsumerDao orderConsumerDao;

    @Override
    public OrderConsumer findById(Long id) {
        return orderConsumerDao.findById(id);
    }

    @Override
    public OrderConsumer save(OrderConsumer orderConsumer) {
        return orderConsumerDao.save(orderConsumer);
    }

    @Override
    public void deleteById(Long id) {
        orderConsumerDao.deleteById(id);
    }

    @Override
    public List<OrderConsumer> findAll() {
        return orderConsumerDao.findAll();
    }
}
