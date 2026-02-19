package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Agricultor")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgricultor")
    private int idAgricultor;

    @Column(name = "nombres")
    private String  nombres;

    @Column(name = "apellidos")
    private String apellidos ;

    @Column(name = "dpi")
    private String dpi;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "comunidadAldea")
    private String comunidadAldea;

    @Column(name = "coordenadasGps")
    private String coordenadasGps;

    @Column(name = "historiaPerfil")
    private String historiaPerfil;

    @Column(name = "idLogin")
    private int idLogin;

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(Integer idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getComunidadAldea() {
        return comunidadAldea;
    }

    public void setComunidadAldea(String comunidadAldea) {
        this.comunidadAldea = comunidadAldea;
    }

    public String getCoordenadasGps() {
        return coordenadasGps;
    }

    public void setCoordenadasGps(String coordenadasGps) {
        this.coordenadasGps = coordenadasGps;
    }

    public String getHistoriaPerfil() {
        return historiaPerfil;
    }

    public void setHistoriaPerfil(String historiaPerfil) {
        this.historiaPerfil = historiaPerfil;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}
