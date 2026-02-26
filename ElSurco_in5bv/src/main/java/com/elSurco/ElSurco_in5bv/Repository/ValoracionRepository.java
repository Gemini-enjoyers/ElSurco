package com.elSurco.ElSurco_in5bv.Repository;

import com.elSurco.ElSurco_in5bv.Entity.Categoria;
import com.elSurco.ElSurco_in5bv.Entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValoracionRepository extends JpaRepository <Valoracion, Integer> {
}
