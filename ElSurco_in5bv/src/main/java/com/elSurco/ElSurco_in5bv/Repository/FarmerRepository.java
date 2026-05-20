package com.elSurco.ElSurco_in5bv.Repository;
import com.elSurco.ElSurco_in5bv.Entity.Farmer;
import com.elSurco.ElSurco_in5bv.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
        boolean existsByUser(User user);
}