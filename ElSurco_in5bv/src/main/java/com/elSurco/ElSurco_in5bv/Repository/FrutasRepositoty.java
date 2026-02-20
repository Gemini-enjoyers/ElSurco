package com.elSurco.ElSurco_in5bv.Repository;
import com.elSurco.ElSurco_in5bv.Repository.FrutasRepositoty;
import com.elSurco.ElSurco_in5bv.Entity.Frutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutasRepositoty extends JpaRepository<Frutas, Integer>{
}
