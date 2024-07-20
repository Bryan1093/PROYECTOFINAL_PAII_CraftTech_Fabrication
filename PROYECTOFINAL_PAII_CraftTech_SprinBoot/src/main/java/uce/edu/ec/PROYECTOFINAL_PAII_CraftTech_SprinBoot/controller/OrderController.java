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

    @GetMapping  // Método GET para obtener todos los pedidos
    public ResponseEntity<List<OrderConsumer>> obtenerPedidos() {
        List<OrderConsumer> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/crear")  // Método POST para crear un nuevo pedido
    public ResponseEntity<?> crearPedido(@RequestBody OrderConsumer pedido) {
        pedidoService.save(pedido);
        return ResponseEntity.ok("Pedido creado correctamente");
    }

}
