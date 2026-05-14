package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Farmer")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFarmer")
    private Integer idFarmer;

    @NotBlank(message = "Name is required.")
    @Column(name = "farmerFirstName")
    private String farmerFName;

    @NotBlank(message = "Last name is required.")
    @Column(name = "farmerLastName")
    private String farmerLastName;

    @NotBlank(message = "ID card (DPI) is required.")
    @Pattern(regexp = "\\d{13}", message = "ID card must have 13 digits.")
    @Column(name = "farmerDpi")
    private String farmerIdCard;

    @NotNull(message = "Phone number cannot be empty.")
    @Column(name = "farmerPhone")
    private Long farmerPhone;

    @NotBlank(message = "Address is required.")
    @Column(name = "farmerAddress")
    private String farmerAddress;

    @Column(name = "farmerGps")
    private String farmerGps;

    @Column(name = "farmerHistory")
    private String farmerHistory;

    @Column(name = "farmerAddress", nullable = false, updatable = false)
    private LocalDate registrationDate;

    @PrePersist
    protected void onCreate() {
        this.registrationDate = LocalDate.now();
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User idUser;

    public Farmer(Integer idFarmer, String farmerFName, String farmerLastName, String farmerIdCard, Long farmerPhone, String farmerAddress, String farmerGps, String farmerHistory, LocalDate registrationDate, User idUser) {
        this.idFarmer = idFarmer;
        this.farmerFName = farmerFName;
        this.farmerLastName = farmerLastName;
        this.farmerIdCard = farmerIdCard;
        this.farmerPhone = farmerPhone;
        this.farmerAddress = farmerAddress;
        this.farmerGps = farmerGps;
        this.farmerHistory = farmerHistory;
        this.registrationDate = registrationDate;
        this.idUser = idUser;
    }

    public Integer getIdFarmer() {
        return idFarmer;
    }

    public void setIdFarmer(Integer idFarmer) {
        this.idFarmer = idFarmer;
    }

    public String getFarmerFName() {
        return farmerFName;
    }

    public void setFarmerFName(String farmerFName) {
        this.farmerFName = farmerFName;
    }

    public String getFarmerLastName() {
        return farmerLastName;
    }

    public void setFarmerLastName(String farmerLastName) {
        this.farmerLastName = farmerLastName;
    }

    public String getFarmerIdCard() {
        return farmerIdCard;
    }

    public void setFarmerIdCard(String farmerIdCard) {
        this.farmerIdCard = farmerIdCard;
    }

    public Long getFarmerPhone() {
        return farmerPhone;
    }

    public void setFarmerPhone(Long farmerPhone) {
        this.farmerPhone = farmerPhone;
    }

    public String getFarmerAddress() {
        return farmerAddress;
    }

    public void setFarmerAddress(String farmerAddress) {
        this.farmerAddress = farmerAddress;
    }

    public String getFarmerGps() {
        return farmerGps;
    }

    public void setFarmerGps(String farmerGps) {
        this.farmerGps = farmerGps;
    }

    public String getFarmerHistory() {
        return farmerHistory;
    }

    public void setFarmerHistory(String farmerHistory) {
        this.farmerHistory = farmerHistory;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}