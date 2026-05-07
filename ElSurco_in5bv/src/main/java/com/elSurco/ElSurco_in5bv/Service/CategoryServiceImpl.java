package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Category;
import com.elSurco.ElSurco_in5bv.Repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() { return categoryRepository.findAll(); }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with wrong ID"));
    }

    @Override
    public Category create(Category category) {
        category.setIdCategory(null);
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Integer id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setCategoryDescription(category.getCategoryDescription());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @Override
    public void delete(Integer id) { categoryRepository.deleteById(id); }
}