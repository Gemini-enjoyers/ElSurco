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
    public List<Product> getAll() { return productRepository.findAll(); }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with wrong ID"));
    }

    @Override
    public Product create(Product product) {
        product.setIdProduct(null);
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductDescription(product.getProductDescription());
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setProductStock(product.getProductStock());
            existingProduct.setHarvestDate(product.getHarvestDate());
            existingProduct.setFarmer(product.getFarmer());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public void delete(Integer id) { productRepository.deleteById(id); }
}