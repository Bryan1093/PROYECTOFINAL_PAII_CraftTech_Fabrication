package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.PatronObserver;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientObserver implements Observer {

    @Override
    public void update(List<OrderConsumer> orders) {
        // Lógica para manejar las notificaciones del cliente
        System.out.println("Pedidos actualizados para el cliente: " + orders);
    }

    public void notifyClient(String message) {
        // Lógica para notificar al cliente, como almacenar en la base de datos o enviar un mensaje
        System.out.println("Notificación al cliente: " + message);
    }
}
