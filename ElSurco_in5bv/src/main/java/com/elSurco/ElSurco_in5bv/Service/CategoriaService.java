package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll();
    Categoria findById(Integer id);
    Categoria save(Categoria categoria);
    void delete(Integer id);
}