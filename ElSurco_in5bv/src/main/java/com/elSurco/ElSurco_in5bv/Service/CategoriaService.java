package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();
    Categoria obtenerPorId(Integer id);
    Categoria agregar(Categoria categoria);
    Categoria actualizar(Integer id, Categoria categoria);
    void eliminar(Integer id);
}