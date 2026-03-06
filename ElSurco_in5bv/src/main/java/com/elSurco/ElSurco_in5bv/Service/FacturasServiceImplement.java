package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Repository.FacturaRepositoty;
import com.elSurco.ElSurco_in5bv.Entity.Facturas;
import com.elSurco.ElSurco_in5bv.Repository.FacturaRepositoty;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturasServiceImplement implements FacturasService{
    private final FacturaRepositoty facturaRepositoty;

    public FacturasServiceImplement (FacturaRepositoty getFacturaRepository){
        this.facturaRepositoty = getFacturaRepository;
    }

    @Override
    public List<Facturas> listar(){return facturaRepositoty.findAll();}

    @Override
    public Facturas obtenerporid(Integer id){
        return facturaRepositoty.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    @Override
    public Facturas crear(Facturas facturas){
        facturas.setIdfacturas(null);
        return facturaRepositoty.save(facturas);
    }

    @Override
    public Facturas actualizar(Integer id, Facturas facturas){
        Facturas existente = obtenerporid(id);
        existente.setFechaEmisionfac(facturas.getFechaEmisionfac());
        existente.setNitfactura(facturas.getNitfactura());
        existente.setTotalfactura(facturas.getTotalfactura());
        existente.setIdPedido(facturas.getIdPedido());
        return facturaRepositoty.save(existente);
    }

    @Override
    public void eliminar(Integer id){
        Facturas existente = obtenerporid(id);
        facturaRepositoty.delete(existente);
    }
}
