package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Verduras;
import java.util.List;

public interface VerdurasService {
    List<Verduras> listar();
    Verduras obtenerporid(Integer id);
    Verduras crear(Verduras verduras);
    Verduras actualizar (Integer id, Verduras verduras);
    void eliminar (Integer id);
}
