package com.elSurco.ElSurco_in5bv.ControllersView;

import com.elSurco.ElSurco_in5bv.Entity.Product;
import com.elSurco.ElSurco_in5bv.Repository.ProductRepository;
import com.elSurco.ElSurco_in5bv.Util.productCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopViewController {

    // Idealmente llamarías a un ProductService aquí, 
    // pero inyectamos el Repository directamente para el ejemplo.
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String renderShopPage(@RequestParam(name = "categoria", required = false) String categoriaParam, Model model) {
        List<Product> listaProductos;

        // Lógica de filtrado
        if (categoriaParam != null && !categoriaParam.isEmpty()) {
            try {
                productCategory enumCategoria = productCategory.valueOf(categoriaParam.toUpperCase());
                listaProductos = productRepository.findByProductCategory(enumCategoria);
                model.addAttribute("categoriaActiva", categoriaParam);
            } catch (IllegalArgumentException e) {
                // Por si alguien escribe una categoría inválida en la URL (ej: /shop?categoria=FALSA)
                listaProductos = productRepository.findAll();
                model.addAttribute("categoriaActiva", "TODOS");
            }
        } else {
            listaProductos = productRepository.findAll();
            model.addAttribute("categoriaActiva", "TODOS");
        }

        // Enviamos la lista de productos y la categoría activa a shop.html
        model.addAttribute("productos", listaProductos);

        // Retorna el nombre exacto de tu plantilla Thymeleaf (shop.html)
        return "shop";
    }

    @GetMapping("/cart")
    public String cartView(){
        return "shoppingCart";
    }
}