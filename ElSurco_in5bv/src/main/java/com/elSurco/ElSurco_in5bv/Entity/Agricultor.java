package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Agricultor")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgricultor")
    private int idAgricultor;

    @Column(name = "nombreAgricultor")
    private String  nombreAgricultor;

    @Column(name = "apellidoAgricultor")
    private String apellidoAgricultor;

    @Column(name = "dpiAgricultor")
    private String dpiAgricultor;

    @Column(name = "telefonoAgricultor")
    private Long telefonoAgricultor;

    @Column(name = "direccionAgricultor")
    private String direccionAgricultor;

    @Column(name = "gpsAgricultor")
    private String gpsAgricultor;

    @Column(name = "historiaAgricultor")
    private String historiaAgricultor;

    @Column(name = "idLogin")
    private int idLogin;

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(Integer idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public String getNombres() {
        return nombreAgricultor;
    }

    public void setNombres(String nombres) {
        this.nombreAgricultor = nombres;
    }

    public String getApellidos() {return apellidoAgricultor;
    }

    public void setApellidos(String apellidos) {
        this.apellidoAgricultor = apellidos;
    }

    public String getDpi() {
        return dpiAgricultor;
    }

    public void setDpi(String dpi) {
        this.dpiAgricultor = dpi;
    }

    public Long getTelefono() {
        return telefonoAgricultor;
    }

    public void setTelefono(Long telefono) {
        this.telefonoAgricultor = telefono;
    }

    public String getComunidadAldea() {
        return direccionAgricultor;
    }

    public void setComunidadAldea(String comunidadAldea) {
        this.direccionAgricultor = comunidadAldea;
    }

    public String getCoordenadasGps() {
        return gpsAgricultor;
    }

    public void setCoordenadasGps(String coordenadasGps) {
        this.gpsAgricultor = coordenadasGps;
    }

    public String getHistoriaPerfil() {
        return historiaAgricultor;
    }

    public void setHistoriaPerfil(String historiaPerfil) {
        this.historiaAgricultor = historiaPerfil;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}
