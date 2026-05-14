package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Product;
import com.elSurco.ElSurco_in5bv.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product with ID " + id + " not found."));
    }

    @Override
    public Product create(Product product) {
        // Aseguramos que sea una inserción nueva
        product.setIdProduct(null);
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        Product existingProduct = getById(id);

        // ¡AQUÍ ESTÁ LA CORRECCIÓN! Usamos los nombres exactos de tu nueva entidad
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductPrice(product.getProductPrice());
        existingProduct.setProductStock(product.getProductStock());
        existingProduct.setHarvestDate(product.getHarvestDate());

        // El Enum de la Categoría
        existingProduct.setProductCategory(product.getProductCategory());

        // El Enum del Estado (Disponible, Agotado, Oculto)
        existingProduct.setProductStatus(product.getProductStatus());

        // La relación con el Agricultor
        existingProduct.setFarmer(product.getFarmer());

        return productRepository.save(existingProduct);
    }

    @Override
    public void delete(Integer id) {
        Product existingProduct = getById(id);
        productRepository.delete(existingProduct);
    }
}