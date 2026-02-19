package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Agricultor;

import java.util.List;

public interface AgricultorService {
    List<Agricultor> listar();
    Agricultor obtenerPorId(Integer Id);
    Agricultor agregar(Agricultor agricultor);
    Agricultor actualizar(Integer id, Agricultor agricultor);
    void eliminar(Integer id);
}
