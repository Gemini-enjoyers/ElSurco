package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInvoice")
    private Integer idInvoice;

    @NotNull(message = "Tax ID (NIT) is required.")
    @Min(value = 100000000, message = "Tax ID must have 9 digits.")
    @Max(value = 999999999, message = "Tax ID must have 9 digits.")
    @Column(name = "taxId")
    private Integer taxId;

    @Column(name = "issueDate")
    @NotBlank(message = "Date is required.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be YYYY-MM-DD format.")
    private String issueDate;

    @NotNull(message = "Invoice total is required.")
    @PositiveOrZero(message = "Total cannot be negative.")
    @Column(name = "invoiceTotal")
    private Integer invoiceTotal;

    @Column(name = "idOrder")
    private String idOrder;

    public Integer getIdInvoice() { return idInvoice; }
    public void setIdInvoice(Integer idInvoice) { this.idInvoice = idInvoice; }
    public Integer getTaxId() { return taxId; }
    public void setTaxId(Integer taxId) { this.taxId = taxId; }
    public String getIssueDate() { return issueDate; }
    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }
    public Integer getInvoiceTotal() { return invoiceTotal; }
    public void setInvoiceTotal(Integer invoiceTotal) { this.invoiceTotal = invoiceTotal; }
    public String getIdOrder() { return idOrder; }
    public void setIdOrder(String idOrder) { this.idOrder = idOrder; }
}