package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

    Producto findById(Integer id);

    Producto save(Producto producto);

    void delete(Integer id);
}