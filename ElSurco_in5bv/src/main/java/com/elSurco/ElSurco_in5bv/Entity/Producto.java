package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "nombreProducto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "descripcionProducto", length = 200)
    private String descripcionProducto;

    @Column(name = "precioProducto", nullable = false, precision = 10, scale = 2)
    @DecimalMin(value = "0.00", inclusive = false, message = "para realizar su pedido a domicilio el precio de su compra tiene que ser mayor a 0")
    private BigDecimal precioProducto;

    @Column(name = "stockProducto", nullable = false)
    @Min(value = 0, message = "el valor no puede ser 0")
    private Integer stockProducto;

    @NotNull(message = "La fecha de la cosecha no puede ser nula")
    @PastOrPresent(message = "La fecha de cosecha no puede estar en el futuro")
    @Column(name = "fechaCosechaProducto", nullable = false)
    private LocalDate fechaCosechaProducto;


    @ManyToOne
    @JoinColumn(name = "idAgricultor", nullable = false)
    private Agricultor agricultor;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    // --- GETTERS Y SETTERS MANUALES ---

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(Integer stockProducto) {
        this.stockProducto = stockProducto;
    }

    public LocalDate getFechaCosechaProducto() {
        return fechaCosechaProducto;
    }

    public void setFechaCosechaProducto(LocalDate fechaCosechaProducto) {
        this.fechaCosechaProducto = fechaCosechaProducto;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}