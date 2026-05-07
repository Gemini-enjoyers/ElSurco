package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Buyer;
import com.elSurco.ElSurco_in5bv.Repository.BuyerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<Buyer> getAll() { return buyerRepository.findAll(); }

    @Override
    public Buyer getById(Integer id) {
        return buyerRepository.findById(id).orElseThrow(() -> new RuntimeException("Buyer " + id + " not found."));
    }

    @Override
    public Buyer create(Buyer buyer) {
        buyer.setIdBuyer(null);
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer update(Integer id, Buyer buyer) {
        Buyer existingBuyer = getById(id);
        existingBuyer.setBuyerName(buyer.getBuyerName());
        existingBuyer.setBuyerLastName(buyer.getBuyerLastName());
        existingBuyer.setBuyerPhone(buyer.getBuyerPhone());
        existingBuyer.setBuyerAddress(buyer.getBuyerAddress());
        existingBuyer.setLoginId(buyer.getLoginId());
        return buyerRepository.save(existingBuyer);
    }

    @Override
    public void delete(Integer id) {
        Buyer existingBuyer = getById(id);
        buyerRepository.delete(existingBuyer);
    }
}