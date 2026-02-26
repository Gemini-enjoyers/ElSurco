package com.elSurco.ElSurco_in5bv.Repository;

import com.elSurco.ElSurco_in5bv.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}