package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Invoice;
import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll();
    Invoice getById(Integer id);
    Invoice create(Invoice invoice);
    Invoice update(Integer id, Invoice invoice);
    void delete(Integer id);
}