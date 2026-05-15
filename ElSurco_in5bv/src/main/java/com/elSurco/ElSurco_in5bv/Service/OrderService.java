package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Order;
import com.elSurco.ElSurco_in5bv.Util.OrderStatus;
import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getById(Integer id);
    Order create(Order order);
    Order update(Integer id, Order order);
    void delete(Integer id);

    List<Order> getByUser(Integer idUser);

    List<Order> getByStatus(OrderStatus status);
}