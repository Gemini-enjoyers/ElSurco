package com.elSurco.ElSurco_in5bv.Repository;
import com.elSurco.ElSurco_in5bv.Entity.Order;
import com.elSurco.ElSurco_in5bv.Util.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser_IdUser(Integer idUser);
    List<Order> findByOrderStatus(OrderStatus status);
}