package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInvoice")
    private Integer idInvoice;

    @Column(name = "invoiceNit")
    private String invoiceNit = "CF";

    @Column(name = "invoiceIssueDate", insertable = false, updatable = false)
    private LocalDateTime invoiceIssueDate;

    @Column(name = "invoiceTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal invoiceTotal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBuyOrder", unique = true, nullable = false)
    private Order order;

    public Invoice() {
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getInvoiceNit() {
        return invoiceNit;
    }

    public void setInvoiceNit(String invoiceNit) {
        this.invoiceNit = invoiceNit;
    }

    public LocalDateTime getInvoiceIssueDate() {
        return invoiceIssueDate;
    }

    public void setInvoiceIssueDate(LocalDateTime invoiceIssueDate) {
        this.invoiceIssueDate = invoiceIssueDate;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}