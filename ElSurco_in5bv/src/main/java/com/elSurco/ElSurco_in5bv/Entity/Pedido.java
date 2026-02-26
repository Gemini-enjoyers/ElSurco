package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.EstadoPedido;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "fechaPedido", nullable = false)
    private LocalDateTime fechaPedido;

    @Column(name = "totalPedido", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPedido;

    @Column(name = "cantidadPedido", nullable = false)
    private Integer cantidadPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoPedido", nullable = false)
    private EstadoPedido estadoPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idComprador", nullable = false)
    private Comprador comprador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @PrePersist
    protected void onCreate() {
        this.fechaPedido = LocalDateTime.now();
    }
    public Integer getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }
    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    public BigDecimal getTotalPedido() {
        return totalPedido;
    }
    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
    public Integer getCantidadPedido() {
        return cantidadPedido;
    }
    public void setCantidadPedido(Integer cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    public Comprador getComprador() {
        return comprador;
    }
    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}