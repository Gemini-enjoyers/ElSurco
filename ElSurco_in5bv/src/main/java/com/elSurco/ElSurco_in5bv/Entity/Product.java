package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.productCategory;
import com.elSurco.ElSurco_in5bv.Util.productStatus;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "productCategory")
    private productCategory productCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "productStatus")
    private productStatus productStatus;

    @ManyToOne
    @JoinColumn(name = "idFarmer", nullable = false)
    private Farmer farmer;

    public Product(Integer idProduct, String productName, String productDescription, BigDecimal productPrice, Integer productStock, LocalDate harvestDate, productCategory productCategory, productStatus productStatus, Farmer farmer) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.harvestDate = harvestDate;
        this.productCategory = productCategory;
        this.productStatus = productStatus;
        this.farmer = farmer;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public productCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(productCategory productCategory) {
        this.productCategory = productCategory;
    }

    public productStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(productStatus productStatus) {
        this.productStatus = productStatus;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
}