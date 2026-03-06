package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Agricultor")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgricultor")
    private Integer idAgricultor;

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
    private Integer idLogin;

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(Integer idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public String getNombres() {
        return nombreAgricultor;
    }

    public void setNombres(String nombreAgricultor) {
        this.nombreAgricultor = nombreAgricultor;
    }

    public String getApellidos() {return apellidoAgricultor;
    }

    public void setApellidos(String apellidoAgricultor) {
        this.apellidoAgricultor = apellidoAgricultor;
    }

    public String getDpi() {
        return dpiAgricultor;
    }

    public void setDpi(String dpiAgricultor) {
        this.dpiAgricultor = dpiAgricultor;
    }

    public Long getTelefono() {
        return telefonoAgricultor;
    }

    public void setTelefono(Long telefonoAgricultor) {
           this.telefonoAgricultor = telefonoAgricultor;
    }

    public String getComunidadAldea() {
        return direccionAgricultor;
    }

    public void setComunidadAldea(String direccionAgricultor) {
        this.direccionAgricultor = direccionAgricultor;
    }

    public String getCoordenadasGps() {
        return gpsAgricultor;
    }

    public void setCoordenadasGps(String gpsAgricultor) {
        this.gpsAgricultor = gpsAgricultor;
    }

    public String getHistoriaPerfil() {
        return historiaAgricultor;
    }

    public void setHistoriaPerfil(String historiaAgricultor) {
        this.historiaAgricultor = historiaAgricultor;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}
