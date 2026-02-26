package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(nullable = false)
    private Integer idAgricultor;

    @Column
    private Integer idVerdura;

    @Column
    private Integer idFruta;

    @Column(nullable = false)
    private Double precioPorLibra;

    @Column(nullable = false)
    private Integer cantidadLibras;

    @Column(nullable = false)
    private LocalDate fechaCosecha;

    public Producto() {
    }

    public Producto(Integer idProducto, Integer idAgricultor, Integer idVerdura, Integer idFruta, Double precioPorLibra, Integer cantidadLibras, LocalDate fechaCosecha) {
        this.idProducto = idProducto;
        this.idAgricultor = idAgricultor;
        this.idVerdura = idVerdura;
        this.idFruta = idFruta;
        this.precioPorLibra = precioPorLibra;
        this.cantidadLibras = cantidadLibras;
        this.fechaCosecha = fechaCosecha;
    }

    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public Integer getIdAgricultor() { return idAgricultor; }
    public void setIdAgricultor(Integer idAgricultor) { this.idAgricultor = idAgricultor; }

    public Integer getIdVerdura() { return idVerdura; }
    public void setIdVerdura(Integer idVerdura) { this.idVerdura = idVerdura; }

    public Integer getIdFruta() { return idFruta; }
    public void setIdFruta(Integer idFruta) { this.idFruta = idFruta; }

    public Double getPrecioPorLibra() { return precioPorLibra; }
    public void setPrecioPorLibra(Double precioPorLibra) { this.precioPorLibra = precioPorLibra; }

    public Integer getCantidadLibras() { return cantidadLibras; }
    public void setCantidadLibras(Integer cantidadLibras) { this.cantidadLibras = cantidadLibras; }

    public LocalDate getFechaCosecha() { return fechaCosecha; }
    public void setFechaCosecha(LocalDate fechaCosecha) { this.fechaCosecha = fechaCosecha; }
}