package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Producto;
import com.elSurco.ElSurco_in5bv.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto con ID Erróneo"));
    }

    @Override
    public Producto agregar(Producto producto) {
        producto.setIdProducto(null);
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {
        Producto productoExistente = productoRepository.findById(id).orElse(null);

        if (productoExistente != null) {
            productoExistente.setNombreProducto(producto.getNombreProducto());
            productoExistente.setDescripcionProducto(producto.getDescripcionProducto());
            productoExistente.setPrecioProducto(producto.getPrecioProducto());
            productoExistente.setStockProducto(producto.getStockProducto());
            productoExistente.setFechaCosechaProducto(producto.getFechaCosechaProducto());

            // Actualizamos también las relaciones (si cambian de agricultor o categoría)
            productoExistente.setAgricultor(producto.getAgricultor());
            productoExistente.setCategoria(producto.getCategoria());

            return productoRepository.save(productoExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}