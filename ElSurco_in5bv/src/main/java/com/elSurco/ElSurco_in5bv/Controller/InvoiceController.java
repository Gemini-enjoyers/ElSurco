package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Invoice;
import com.elSurco.ElSurco_in5bv.Service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) { this.invoiceService = invoiceService; }

    @GetMapping("/getAll")
    public List<Invoice> getAll() { return invoiceService.getAll(); }

    @GetMapping("/{id}")
    public Invoice getById(@PathVariable Integer id) { return invoiceService.getById(id); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice create(@Valid @RequestBody Invoice invoice) { return invoiceService.create(invoice); }

    @PutMapping("/update/{id}")
    public Invoice update(@PathVariable("id") Integer id, @RequestBody Invoice invoice) {
        return invoiceService.update(id, invoice);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) { invoiceService.delete(id); }
}