package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Invoice;
import com.elSurco.ElSurco_in5bv.Repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getById(Integer id) {
        return invoiceRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Invoice with ID " + id + " not found."));
    }

    @Override
    public Invoice create(Invoice invoice) {
        // Aseguramos que sea una inserción nueva
        invoice.setIdInvoice(null);
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Integer id, Invoice invoice) {
        Invoice existingInvoice = getById(id);

        // Actualizamos usando los getters y setters exactos de tu nueva entidad
        existingInvoice.setInvoiceNit(invoice.getInvoiceNit());
        existingInvoice.setInvoiceTotal(invoice.getInvoiceTotal());

        // Actualizamos la relación directa con el pedido (BuyOrder)
        existingInvoice.setOrder(invoice.getOrder());

        // Nota: invoiceIssueDate no se actualiza aquí porque la base de datos
        // la maneja automáticamente (updatable = false en la entidad).

        return invoiceRepository.save(existingInvoice);
    }

    @Override
    public void delete(Integer id) {
        Invoice existingInvoice = getById(id);
        invoiceRepository.delete(existingInvoice);
    }
}