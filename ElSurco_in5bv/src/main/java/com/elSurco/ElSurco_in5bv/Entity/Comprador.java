package com.elSurco.ElSurco_in5bv.Entity;
import jakarta.persistence.*;
@Entity
@Table (name =  "Comprador")
public class Comprador {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idComprador")
    private Integer idComprador;
    @Column (name = "nombres")
    private String nombres;
    @Column (name = "apellidos")
    private String apellidos;
    @Column ( name = "telefono")
    private String telefono;
    @Column (name = "direccioEntrega")
    private String direccionEntrega;

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}
