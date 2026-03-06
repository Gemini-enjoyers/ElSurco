package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table (name = "Valoracion")
public class Valoracion {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name = "idValoracion")
private Integer idValoracion;

@Min(value = 1, message = "la valoracion minima es 1")
@Max(value = 5, message = "La valoracion maxima es 5")
@Column (name = "puntuacionValoracion")
private Integer puntuacionValoracion;

@Size (max = 200, message = "El maximo de caracteres son 200")
@Column (name = "comentarioValoracion", columnDefinition = "TEXT")
private  String comentarioValoracion;
@NotNull(message = "EL campo fecha, es obligatoria ")
@PastOrPresent (message = "La fecha no puede ser futura")
@Column (name = "fechaValoracion")
private LocalDate fechaValoraciom;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/feature/bran
@Column (name = "idProducto")
private int idProducto;
@Column (name = "idComprador")
private int idComprador;
<<<<<<< HEAD
=======
=======
    @Column (name = "idProducto")
    private Integer idProducto;
    @Column (name = "idComprador")
    private Integer idComprador;
>>>>>>> 7a85fe964c59855380cc0dec41339eb352353e30
>>>>>>> origin/feature/bran
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

    public LocalDate getFechaValoraciom() {
        return fechaValoraciom;
    }

    public void setFechaValoraciom(LocalDate fechaValoraciom) {
        this.fechaValoraciom = fechaValoraciom;
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
