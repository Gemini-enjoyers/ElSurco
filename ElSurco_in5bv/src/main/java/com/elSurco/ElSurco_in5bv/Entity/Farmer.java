package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Farmer")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFarmer")
    private Integer idFarmer;

    @NotBlank(message = "Name is required.")
    @Column(name = "farmerName")
    private String farmerName;

    @NotBlank(message = "Last name is required.")
    @Column(name = "farmerLastName")
    private String farmerLastName;

    @NotBlank(message = "ID card (DPI) is required.")
    @Pattern(regexp = "\\d{13}", message = "ID card must have 13 digits.")
    @Column(name = "farmerIdCard")
    private String farmerIdCard;

    @NotNull(message = "Phone number cannot be empty.")
    @Column(name = "farmerPhone")
    private Long farmerPhone;

    @NotBlank(message = "Address is required.")
    @Column(name = "farmerAddress")
    private String farmerAddress;

    @Column(name = "farmerGps")
    private String farmerGps;

    @Column(name = "farmerStory")
    private String farmerStory;

    @NotNull(message = "loginId is required.")
    @Column(name = "loginId")
    private Integer loginId;

    public Integer getIdFarmer() { return idFarmer; }
    public void setIdFarmer(Integer idFarmer) { this.idFarmer = idFarmer; }
    public String getFarmerName() { return farmerName; }
    public void setFarmerName(String farmerName) { this.farmerName = farmerName; }
    public String getFarmerLastName() { return farmerLastName; }
    public void setFarmerLastName(String farmerLastName) { this.farmerLastName = farmerLastName; }
    public String getFarmerIdCard() { return farmerIdCard; }
    public void setFarmerIdCard(String farmerIdCard) { this.farmerIdCard = farmerIdCard; }
    public Long getFarmerPhone() { return farmerPhone; }
    public void setFarmerPhone(Long farmerPhone) { this.farmerPhone = farmerPhone; }
    public String getFarmerAddress() { return farmerAddress; }
    public void setFarmerAddress(String farmerAddress) { this.farmerAddress = farmerAddress; }
    public String getFarmerGps() { return farmerGps; }
    public void setFarmerGps(String farmerGps) { this.farmerGps = farmerGps; }
    public String getFarmerStory() { return farmerStory; }
    public void setFarmerStory(String farmerStory) { this.farmerStory = farmerStory; }
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }
}