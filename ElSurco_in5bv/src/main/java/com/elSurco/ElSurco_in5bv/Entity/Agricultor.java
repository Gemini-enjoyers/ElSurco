package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Agricultor")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgricultor")
    private Integer idAgricultor;

    @NotBlank(message = "El nombre es obligatorio.")
    @Column(name = "nombreAgricultor")
    private String nombreAgricultor;

    @NotBlank(message = "El apellido es obligatorio.")
    @Column(name = "apellidoAgricultor")
    private String apellidoAgricultor;

    @NotBlank(message = "El DPI es obligatorio.")
    @Pattern(regexp = "\\d{13}", message = "El DPI tiene que tener 13 números.")
    @Column(name = "dpiAgricultor")
    private String dpiAgricultor;

    @NotNull(message = "El número de teléfono no puede estar vacío.")
    @Column(name = "telefonoAgricultor")
    private Long telefonoAgricultor;

    @NotBlank(message = "La dirección es obligatoria.")
    @Column(name = "direccionAgricultor")
    private String direccionAgricultor;

    @Column(name = "gpsAgricultor")
    private String gpsAgricultor;

    @Column(name = "historiaAgricultor")
    private String historiaAgricultor;

    @NotNull(message = "El idLogin es obligatorio.")
    @Column(name = "idLogin")
    private Integer idLogin;

    // --- GETTERS Y SETTERS

    public Integer getIdAgricultor() { return idAgricultor; }
    public void setIdAgricultor(Integer idAgricultor) { this.idAgricultor = idAgricultor; }

    public String getNombreAgricultor() { return nombreAgricultor; }
    public void setNombreAgricultor(String nombreAgricultor) { this.nombreAgricultor = nombreAgricultor; }

    public String getApellidoAgricultor() { return apellidoAgricultor; }
    public void setApellidoAgricultor(String apellidoAgricultor) { this.apellidoAgricultor = apellidoAgricultor; }

    public String getDpiAgricultor() { return dpiAgricultor; }
    public void setDpiAgricultor(String dpiAgricultor) { this.dpiAgricultor = dpiAgricultor; }

    public Long getTelefonoAgricultor() { return telefonoAgricultor; }
    public void setTelefonoAgricultor(Long telefonoAgricultor) { this.telefonoAgricultor = telefonoAgricultor; }

    public String getDireccionAgricultor() { return direccionAgricultor; }
    public void setDireccionAgricultor(String direccionAgricultor) { this.direccionAgricultor = direccionAgricultor; }

    public String getGpsAgricultor() { return gpsAgricultor; }
    public void setGpsAgricultor(String gpsAgricultor) { this.gpsAgricultor = gpsAgricultor; }

    public String getHistoriaAgricultor() { return historiaAgricultor; }
    public void setHistoriaAgricultor(String historiaAgricultor) { this.historiaAgricultor = historiaAgricultor; }

    public Integer getIdLogin() { return idLogin; }
    public void setIdLogin(Integer idLogin) { this.idLogin = idLogin; }
}