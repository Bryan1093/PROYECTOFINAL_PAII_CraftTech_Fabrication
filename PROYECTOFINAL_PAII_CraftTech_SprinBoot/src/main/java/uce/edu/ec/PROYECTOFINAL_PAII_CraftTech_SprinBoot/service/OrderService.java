package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.repository.OrderRepository;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository pedidoRepository;

    public void crearPedido(OrderConsumer pedido) {
        // Lógica para crear un pedido en la base de datos
        pedidoRepository.save(pedido);
    }

    public List<OrderConsumer> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }
}
