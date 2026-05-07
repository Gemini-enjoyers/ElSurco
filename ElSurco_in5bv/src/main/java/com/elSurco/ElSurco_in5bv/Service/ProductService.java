package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Integer id);
    Product create(Product product);
    Product update(Integer id, Product product);
    void delete(Integer id);
}