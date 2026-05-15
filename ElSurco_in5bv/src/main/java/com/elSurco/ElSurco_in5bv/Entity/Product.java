package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.productCategory;
import com.elSurco.ElSurco_in5bv.Util.productStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Integer idProduct;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal productPrice;

    @Column(name = "productStock", nullable = false)
    private Integer productStock;

    @Column(name = "harvestDate", nullable = false)
    private LocalDate harvestDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "productCategory", nullable = false)
    private productCategory productCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "productStatus")
    private productStatus productStatus = com.elSurco.ElSurco_in5bv.Util.productStatus.AVAILABLE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFarmer", nullable = false)
    private Farmer farmer;

    public Product() {}

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
    public productCategory getProductCategory() { return productCategory; }
    public void setProductCategory(productCategory productCategory) { this.productCategory = productCategory; }
    public productStatus getProductStatus() { return productStatus; }
    public void setProductStatus(productStatus productStatus) { this.productStatus = productStatus; }
    public Farmer getFarmer() { return farmer; }
    public void setFarmer(Farmer farmer) { this.farmer = farmer; }
}