package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategory")
    private Integer idCategory;

    @NotBlank(message = "Category name is required.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    @Column(name = "categoryName", nullable = false, length = 50)
    private String categoryName;

    @NotBlank(message = "Category description is required.")
    @Size(min = 20, max = 200, message = "Description must be between 20 and 200 characters.")
    @Column(name = "categoryDescription", length = 150)
    private String categoryDescription;

    public Integer getIdCategory() { return idCategory; }
    public void setIdCategory(Integer idCategory) { this.idCategory = idCategory; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getCategoryDescription() { return categoryDescription; }
    public void setCategoryDescription(String categoryDescription) { this.categoryDescription = categoryDescription; }
}