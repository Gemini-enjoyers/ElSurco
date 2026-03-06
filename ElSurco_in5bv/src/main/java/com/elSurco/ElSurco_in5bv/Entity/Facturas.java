package com.elSurco.ElSurco_in5bv.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "facturas")

public class Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactoras")

    private Integer idfacturas;
    @Column(name = "nitfactura")

    @NotBlank(message = "El NIT tiene que ser obligatorio.")
    @Size(min = 9, max = 9, message = "El nit tiene que tener 9 digitos.")
    private  Integer nitfactura;
    @Column(name = "fechaEmisionfac")

    @NotBlank(message = "La fecha tiene que ser obligatoria.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "La fecha debe tener el formato YYYY-MM-DD.")
    private String fechaEmisionfac;

    @NotBlank(message = "El total de la factura tiene que ser obligatoria.")
    @PositiveOrZero(message = "El total de puede ser negativo.")
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
