package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.PatronObserver;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminObserver implements Observer {

    @Override
    public void update(List<OrderConsumer> pedidos) {
        // Lógica para manejar la fabricación y notificaciones del administrador
        System.out.println("Nuevos pedidos para el administrador: " + pedidos);
        startManufacturing(pedidos);
    }

    private void startManufacturing(List<OrderConsumer> pedidos) {
        for (OrderConsumer pedido : pedidos) {
            new Thread(() -> {
                try {
                    // Simula el tiempo de fabricación
                    Thread.sleep(pedido.getFabricationTimeInSeconds() * 1000);
                    // Notificar al cliente cuando el pedido esté listo
                    notifyClient(pedido);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private void notifyClient(OrderConsumer pedido) {
        // Implementar lógica para notificar al cliente, por ejemplo, actualizando el estado del pedido
        System.out.println("Pedido fabricado: " + pedido);
        // Aquí podrías tener una llamada al método notifyClient del ClientObserver si se gestiona en una base de datos compartida o similar
    }
}
