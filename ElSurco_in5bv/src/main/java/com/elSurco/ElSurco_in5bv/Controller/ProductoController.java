package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Producto;
import com.elSurco.ElSurco_in5bv.Service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/get")
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Integer id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoService.agregar(producto);
    }

    @PutMapping("/put/{Id}")
    public Producto actualizar(@PathVariable("Id") Integer id, @RequestBody Producto producto) {
        return productoService.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public Producto eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return null;
    }
}