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
    public List<Invoice> getAll() { return invoiceRepository.findAll(); }

    @Override
    public Invoice getById(Integer id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    @Override
    public Invoice create(Invoice invoice) {
        invoice.setIdInvoice(null);
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Integer id, Invoice invoice) {
        Invoice existingInvoice = getById(id);
        existingInvoice.setIssueDate(invoice.getIssueDate());
        existingInvoice.setTaxId(invoice.getTaxId());
        existingInvoice.setInvoiceTotal(invoice.getInvoiceTotal());
        existingInvoice.setIdOrder(invoice.getIdOrder());
        return invoiceRepository.save(existingInvoice);
    }

    @Override
    public void delete(Integer id) {
        Invoice existingInvoice = getById(id);
        invoiceRepository.delete(existingInvoice);
    }
}