package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Frutas;
import com.elSurco.ElSurco_in5bv.Entity.Verduras;

import java.util.List;

public interface FrutasService {
    List<Frutas> listar();
    Frutas obtenerporid(Integer id);
    Frutas crear(Verduras verduras);
    Frutas actualizar (Integer id, Verduras verduras);

    Frutas crear(Frutas frutas);

    Frutas actualizar(Integer id, Frutas frutas);

    void eliminar (Integer id);
}
