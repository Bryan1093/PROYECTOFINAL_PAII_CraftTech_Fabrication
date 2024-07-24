package service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Async
    public void processOrderAsync(Long id) {
        // Simulate processing time
        try {
            Thread.sleep(5000); // Example delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order order = getOrderById(id);
        if (order != null) {
            order.setProcessed(true);
            orderRepository.save(order);
        }
    }
}
