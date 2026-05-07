package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name =  "Buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBuyer")
    private Integer idBuyer;

    @NotBlank(message = "Name is required.")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
    @Column(name = "buyerName")
    private String buyerName;

    @NotBlank(message = "Last name is required.")
    @Size(min = 2, max = 100, message = "Last name is required.")
    @Column(name = "buyerLastName")
    private String buyerLastName;

    @NotNull(message = "Phone number cannot be empty.")
    @Min(value = 10000000, message = "Invalid phone number.")
    @Max(value = 99999999, message = "Phone number cannot exceed 8 digits.")
    @Column(name = "buyerPhone")
    private Long buyerPhone;

    @NotBlank(message = "Address is required.")
    @Size(max = 255, message = "Address is too long.")
    @Column(name = "buyerAddress")
    private String buyerAddress;

    @Column(name = "loginId", nullable = false)
    private Integer loginId;

    public Integer getIdBuyer() { return idBuyer; }
    public void setIdBuyer(Integer idBuyer) { this.idBuyer = idBuyer; }
    public String getBuyerName() { return buyerName; }
    public void setBuyerName(String buyerName) { this.buyerName = buyerName; }
    public String getBuyerLastName() { return buyerLastName; }
    public void setBuyerLastName(String buyerLastName) { this.buyerLastName = buyerLastName; }
    public Long getBuyerPhone() { return buyerPhone; }
    public void setBuyerPhone(Long buyerPhone) { this.buyerPhone = buyerPhone; }
    public String getBuyerAddress() { return buyerAddress; }
    public void setBuyerAddress(String buyerAddress) { this.buyerAddress = buyerAddress; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
}