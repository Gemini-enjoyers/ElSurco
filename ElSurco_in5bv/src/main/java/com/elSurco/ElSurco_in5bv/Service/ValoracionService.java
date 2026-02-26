package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Agricultor;
import com.elSurco.ElSurco_in5bv.Entity.Valoracion;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ValoracionService {
    List<Valoracion> listar();
    Valoracion obtenerPorId(Integer Id);
    Valoracion agregar (Valoracion valoracion);
    Valoracion actualizar (Integer Id, Valoracion valoracion);
    void eliminar (Integer id);
}
