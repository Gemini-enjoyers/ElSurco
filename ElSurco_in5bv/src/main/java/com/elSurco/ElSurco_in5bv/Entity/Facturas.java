package com.elSurco.ElSurco_in5bv.Entity;
import jakarta.persistence.*;
@Entity
@Table (name = "facturas")

public class Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactoras")

    private Integer idfacturas;
    @Column(name = "nitfactura")

    private  Integer nitfactura;
    @Column(name = "fechaEmisionfac")

    private String fechaEmisionfac;
    @Column(name = "totalfactura")

    private Integer totalfactura;
    @Column(name = "idPedido")

    private String idPedido;

    public Integer getIdfacturas() {
        return idfacturas;
    }

    public void setIdfacturas(Integer idfacturas) {
        this.idfacturas = idfacturas;
    }

    public Integer getNitfactura() {
        return nitfactura;
    }

    public void setNitfactura(Integer nitfactura) {
        this.nitfactura = nitfactura;
    }

    public String getFechaEmisionfac() {
        return fechaEmisionfac;
    }

    public void setFechaEmisionfac(String fechaEmisionfac) {
        this.fechaEmisionfac = fechaEmisionfac;
    }

    public Integer getTotalfactura() {
        return totalfactura;
    }

    public void setTotalfactura(Integer totalfactura) {
        this.totalfactura = totalfactura;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
}
