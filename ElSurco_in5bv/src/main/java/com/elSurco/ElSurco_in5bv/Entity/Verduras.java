package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "verduras")
public class Verduras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idverdura")

private Integer idverdura;
    @Column(name = "nombre")
private String nombre;
    @Column(name = "descripcion")
private String descripcion;

    public Integer getIdverdura() {
        return idverdura;
    }

    public void setIdverdura(Integer idverdura) {
        this.idverdura = idverdura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
