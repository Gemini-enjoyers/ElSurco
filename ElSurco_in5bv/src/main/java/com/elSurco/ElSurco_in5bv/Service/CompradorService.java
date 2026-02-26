package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Comprador;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CompradorService {
    List<Comprador> listar();
    Comprador obtenerPorId (Integer Id);
    Comprador crear (Comprador comprador);
    Comprador actualizar (Integer id, Comprador comprador);
    void eliminar (Integer id);
}
