package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Facturas;
import java.util.List;

public interface FacturasService {
    List<Facturas> listar();
    Facturas obtenerporid(Integer id);
    Facturas crear(Facturas facturas);
    Facturas actualizar (Integer id, Facturas facturas);
    void eliminar (Integer id);
}