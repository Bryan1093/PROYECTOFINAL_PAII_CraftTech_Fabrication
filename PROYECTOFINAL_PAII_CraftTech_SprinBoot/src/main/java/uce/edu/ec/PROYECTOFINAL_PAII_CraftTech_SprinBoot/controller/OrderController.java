package uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.model.OrderConsumer;
import uce.edu.ec.PROYECTOFINAL_PAII_CraftTech_SprinBoot.DAO.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class OrderController {

    @Autowired
    private OrderService pedidoService;

    @GetMapping
    public ResponseEntity<List<OrderConsumer>> obtenerPedidos() {
        List<OrderConsumer> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPedido(@RequestBody OrderConsumer pedido) {
        try {
            pedidoService.save(pedido);
            return ResponseEntity.ok("Pedido creado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al crear el pedido");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderConsumer> obtenerPedidoPorId(@PathVariable Long id) {
        OrderConsumer pedido = pedidoService.findById(id);
        return pedido != null ? ResponseEntity.ok(pedido) : ResponseEntity.notFound().build();
    }
}
