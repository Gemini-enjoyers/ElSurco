package com.elSurco.ElSurco_in5bv.Entity;
import jakarta.persistence.*;
@Entity
@Table (name =  "Comprador")
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComprador")
    private Integer idComprador;
    @Column(name = "nombreComprador")
    private String nombreComprador;
    @Column(name = "apellidoComprador")
    private String apellidoComprador;
    @Column(name = "telefonoComprador")
    private Long telefonoComprador;
    @Column(name = "direccionComprador")
    private String direccionComprador;
    @Column(name = "idLogin", nullable = false)
    private Integer idLogin;

    public Integer getIdLogin() {
        return idLogin;
    }
    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getApellidoComprador() {
        return apellidoComprador;
    }

    public void setApellidoComprador(String apellidoComprador) {
        this.apellidoComprador = apellidoComprador;
    }

    public Long getTelefonoComprador() {
        return telefonoComprador;
    }

    public void setTelefonoComprador(Long telefonoComprador) {
        this.telefonoComprador = telefonoComprador;
    }

    public String getDireccionComprador() {
        return direccionComprador;
    }

    public void setDireccionComprador(String direccionComprador) {
        this.direccionComprador = direccionComprador;
    }
}