package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Buyer;
import java.util.List;

public interface BuyerService {
    List<Buyer> getAll();
    Buyer getById(Integer id);
    Buyer create(Buyer buyer);
    Buyer update(Integer id, Buyer buyer);
    void delete(Integer id);
}