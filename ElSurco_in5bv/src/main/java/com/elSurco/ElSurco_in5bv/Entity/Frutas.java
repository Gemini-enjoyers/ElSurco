package com.elSurco.ElSurco_in5bv.Entity;
import jakarta.persistence.*;
@Entity
@Table (name = "frutas")
public class Frutas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfrutas")

    private Integer idfrutas;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    public Integer getIdfrutas() {
        return idfrutas;
    }

    public void setIdfrutas(Integer idfruta) {
        this.idfrutas = idfruta;
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