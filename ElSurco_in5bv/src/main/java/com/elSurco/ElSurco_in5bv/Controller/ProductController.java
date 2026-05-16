package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Product;
import com.elSurco.ElSurco_in5bv.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping("/getAll")
    public List<Product> getAll() { return productService.getAll(); }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) { return productService.getById(id); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) { return productService.create(product); }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) { productService.delete(id); }
}