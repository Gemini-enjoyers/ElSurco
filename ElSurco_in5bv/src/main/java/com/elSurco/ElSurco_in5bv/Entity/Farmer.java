package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFarmer")
    private Integer idFarmer;

    @Column(name = "farmerFirstName", nullable = false)
    private String farmerFirstName;

    @Column(name = "farmerLastName", nullable = false)
    private String farmerLastName;

    @Column(name = "farmerDpi", unique = true, nullable = false)
    private String farmerDpi;

    @Column(name = "farmerPhone", nullable = false)
    private Long farmerPhone;

    @Column(name = "farmerAddress", nullable = false)
    private String farmerAddress;

    @Column(name = "farmerGps")
    private String farmerGps;

    @Column(name = "farmerHistory", columnDefinition = "TEXT")
    private String farmerHistory;

    @Column(name = "registrationDate", insertable = false, updatable = false)
    private LocalDate registrationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    public Farmer() {}

    public Integer getIdFarmer() { return idFarmer; }
    public void setIdFarmer(Integer idFarmer) { this.idFarmer = idFarmer; }
    public String getFarmerFirstName() { return farmerFirstName; }
    public void setFarmerFirstName(String farmerFirstName) { this.farmerFirstName = farmerFirstName; }
    public String getFarmerLastName() { return farmerLastName; }
    public void setFarmerLastName(String farmerLastName) { this.farmerLastName = farmerLastName; }
    public String getFarmerDpi() { return farmerDpi; }
    public void setFarmerDpi(String farmerDpi) { this.farmerDpi = farmerDpi; }
    public Long getFarmerPhone() { return farmerPhone; }
    public void setFarmerPhone(Long farmerPhone) { this.farmerPhone = farmerPhone; }
    public String getFarmerAddress() { return farmerAddress; }
    public void setFarmerAddress(String farmerAddress) { this.farmerAddress = farmerAddress; }
    public String getFarmerGps() { return farmerGps; }
    public void setFarmerGps(String farmerGps) { this.farmerGps = farmerGps; }
    public String getFarmerHistory() { return farmerHistory; }
    public void setFarmerHistory(String farmerHistory) { this.farmerHistory = farmerHistory; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}