package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.PatronObserver;

import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.ManufacturingProcess;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Observable {

    private List<Observer> observers = new ArrayList<>();
    private List<OrderConsumer> orders = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(new ArrayList<>(orders));
        }
    }

    public void processOrder(OrderConsumer order) {
        ManufacturingProcess process = new ManufacturingProcess();
        process.setOrderConsumer(order);
        process.setStartDate(new Date());
        process.setStatus("In Progress");
        new Thread(() -> {
            try {
                Thread.sleep(order.getFabricationTimeInSeconds() * 1000L);
                process.setEndDate(new Date());
                process.setStatus("Completed");
                notifyObservers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        orders.add(order);
        notifyObservers();
    }

    public List<OrderConsumer> getOrders() {
        return new ArrayList<>(orders);
    }
}
