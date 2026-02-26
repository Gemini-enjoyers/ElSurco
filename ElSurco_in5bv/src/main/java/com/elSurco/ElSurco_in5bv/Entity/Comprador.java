package com.elSurco.ElSurco_in5bv.Entity;
import jakarta.persistence.*;
@Entity
@Table (name =  "Comprador")
public class Comprador {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idComprador")
    private Integer idComprador;
    @Column (name = "nombreComprador")
    private String nombreComprador;
    @Column (name = "apellidoComprador")
    private String apellidoComprador;
    @Column ( name = "telefonoComprador")
    private Long telefonoComprador;
    @Column (name = "direccionComprador")
    private String direccionComprador;

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getNombres() {
        return nombreComprador;
    }

    public void setNombres(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getApellidos() {
        return apellidoComprador;
    }

    public void setApellidos(String apellidos) {
        this.apellidoComprador = apellidoComprador;
    }

    public Long getTelefono() {
        return telefonoComprador;
    }

    public void setTelefono(Long telefono) {
        this.telefonoComprador = telefonoComprador;
    }

    public String getDireccionEntrega() {
        return direccionComprador;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionComprador = direccionComprador;
    }
}
