package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Integer idProduct;

    @NotBlank(message = "Product name is required")
    @Size (min = 3, max = 60, message = "Product name exceeds 60 characters")
    @Column(name = "productName", nullable = false, length = 100)
    private String productName;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 10, max = 200, message = "Description must be between 10 and 200 characters")
    @Column(name = "productDescription", length = 200)
    private String productDescription;

    @Column(name = "productPrice", nullable = false, precision = 10, scale = 2)
    @DecimalMin(value = "0.00", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal productPrice;

    @Column(name = "productStock", nullable = false)
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer productStock;

    @NotNull(message = "Harvest date cannot be null")
    @PastOrPresent(message = "Harvest date cannot be in the future")
    @Column(name = "harvestDate", nullable = false)
    private LocalDate harvestDate;

    @ManyToOne
    @JoinColumn(name = "idFarmer", nullable = false)
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "idCategory", nullable = false)
    private Category category;

    public Integer getIdProduct() { return idProduct; }
    public void setIdProduct(Integer idProduct) { this.idProduct = idProduct; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }
    public BigDecimal getProductPrice() { return productPrice; }
    public void setProductPrice(BigDecimal productPrice) { this.productPrice = productPrice; }
    public Integer getProductStock() { return productStock; }
    public void setProductStock(Integer productStock) { this.productStock = productStock; }
    public LocalDate getHarvestDate() { return harvestDate; }
    public void setHarvestDate(LocalDate harvestDate) { this.harvestDate = harvestDate; }
    public Farmer getFarmer() { return farmer; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}