package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Category;
import com.elSurco.ElSurco_in5bv.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }

    @GetMapping("/getAll")
    public List<Category> getAll() { return categoryService.getAll(); }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) { return categoryService.getById(id); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@Valid @RequestBody Category category) { return categoryService.create(category); }

    @PutMapping("/update/{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) { categoryService.delete(id); }
}