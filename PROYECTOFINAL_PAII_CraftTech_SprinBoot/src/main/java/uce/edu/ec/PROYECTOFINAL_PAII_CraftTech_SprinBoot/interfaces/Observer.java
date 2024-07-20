package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.interfaces;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;

import java.util.List;

public interface Observer {
    void update(List<OrderConsumer> pedidos);
}
