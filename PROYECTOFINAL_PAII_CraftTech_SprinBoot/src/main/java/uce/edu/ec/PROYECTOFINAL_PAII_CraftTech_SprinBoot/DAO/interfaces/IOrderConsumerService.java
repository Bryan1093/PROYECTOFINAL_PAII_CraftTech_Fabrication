package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.interfaces;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;

import java.util.List;

public interface IOrderConsumerService {
    OrderConsumer findById(Long id);
    OrderConsumer save(OrderConsumer orderConsumer);
    void deleteById(Long id);
    List<OrderConsumer> findAll();
}
