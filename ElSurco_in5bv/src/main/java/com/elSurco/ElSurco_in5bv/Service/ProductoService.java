package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listar();
    Producto obtenerPorId(Integer id);
    Producto agregar(Producto producto);
    Producto actualizar(Integer id, Producto producto);
    void eliminar(Integer id);
}