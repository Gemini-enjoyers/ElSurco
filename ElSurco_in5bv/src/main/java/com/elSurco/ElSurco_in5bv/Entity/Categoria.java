package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Integer idCategoria;

    @NotBlank(message = "El nombre de categoria es obligatorio.")
    @Size(min = 2, max = 50, message = "El nombre debe tener 2 a 50 carractere.")
    @Column(name = "nombreCategoria", nullable = false, length = 50)
    private String nombreCategoria;

    @NotBlank(message = "La descripcion de las categorias tiene que ser obligatoria.")
    @Size(min = 20, max = 200, message = "La categoria no puede ser menos de 20 ni mayor a 200.")
    @Column(name = "descripcionCategoria", length = 150)
    private String descripcionCategoria;


    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
}