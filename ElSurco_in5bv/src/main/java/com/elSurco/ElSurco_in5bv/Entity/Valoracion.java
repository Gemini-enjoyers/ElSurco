package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "Valoracion")
public class Valoracion {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name = "idValoracion")
private Integer idValoracion;
@Column (name = "puntuacionValoracion")
private Integer puntuacionValoracion;
@Column (name = "comentarioValoracion", columnDefinition = "TEXT")
private  String comentarioValoracion;
@Column (name = "fechaValoracion")
private LocalDate fechaValoracion;
@Column (name = "idProducto")
private int idProducto;
@Column (name = "idComprador")
private int idComprador;
    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Integer getPuntuacionValoracion() {
        return puntuacionValoracion;
    }

    public void setPuntuacionValoracion(Integer puntuacionValoracion) {
        this.puntuacionValoracion = puntuacionValoracion;
    }

    public String getComentarioValoracion() {
        return comentarioValoracion;
    }

    public void setComentarioValoracion(String comentarioValoracion) {
        this.comentarioValoracion = comentarioValoracion;
    }

    public LocalDate getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(LocalDate fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

}
