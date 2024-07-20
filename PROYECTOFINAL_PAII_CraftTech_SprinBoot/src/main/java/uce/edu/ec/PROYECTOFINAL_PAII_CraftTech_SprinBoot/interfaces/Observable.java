package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.interfaces;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(List<OrderConsumer> pedidos) {
        for (Observer observer : observers) {
            observer.update(pedidos);
        }
    }

    // Método para obtener los pedidos desde el servidor
    public List<OrderConsumer> obtenerPedidosDelServidor() {
        // Lógica para realizar la solicitud HTTP y obtener los pedidos del servidor
        // HttpClient y HttpRequest aquí

        // Ejemplo básico de obtención de pedidos
        List<OrderConsumer> pedidos = new ArrayList<>();
        // Lógica para obtener los pedidos del servidor

        return pedidos;
    }
}

