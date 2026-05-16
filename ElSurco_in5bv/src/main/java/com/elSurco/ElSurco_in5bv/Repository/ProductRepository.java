package com.elSurco.ElSurco_in5bv.Repository;
import com.elSurco.ElSurco_in5bv.Entity.Product;
import com.elSurco.ElSurco_in5bv.Util.productCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // ¡Spring genera automáticamente la consulta SQL con solo leer este nombre!
    List<Product> findByProductCategory(productCategory category);
}