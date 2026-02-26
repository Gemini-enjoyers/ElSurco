package com.elSurco.ElSurco_in5bv.Repository;
import com.elSurco.ElSurco_in5bv.Repository.VerdurasRepositoty;
import com.elSurco.ElSurco_in5bv.Entity.Verduras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerdurasRepositoty extends JpaRepository<Verduras, Integer> {
}
