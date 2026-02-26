package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Pedido;
import com.elSurco.ElSurco_in5bv.Service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/get")
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Integer id) {
        return pedidoService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crear(@RequestBody Pedido pedido) {
        return pedidoService.agregar(pedido);
    }

    @PutMapping("/put/{Id}")
    public Pedido actualizar(@PathVariable("Id") Integer id, @RequestBody Pedido pedido) {
        return pedidoService.actualizar(id, pedido);
    }

    @DeleteMapping("/{id}")
    public Pedido eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
        return null;
    }
}