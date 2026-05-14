package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Order;
import com.elSurco.ElSurco_in5bv.Repository.OrderRepository;
import com.elSurco.ElSurco_in5bv.Util.OrderStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() { return orderRepository.findAll(); }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with wrong ID"));
    }

    @Override
    public Order create(Order order) {
        order.setIdOrder(null);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Integer id, Order order) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setOrderTotal(order.getOrderTotal());
            existingOrder.setOrderQuantity(order.getOrderQuantity());
            existingOrder.setOrderStatus(order.getOrderStatus());
            existingOrder.setBuyer(order.getBuyer());
            existingOrder.setProduct(order.getProduct());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    @Override
    public void delete(Integer id) { orderRepository.deleteById(id); }

    @Override
    public List<Order> getByBuyer(Integer idBuyer) {
        return orderRepository.findByBuyer_IdBuyer(idBuyer);
    }

    @Override
    public List<Order> getByStatus(OrderStatus status) {
        return orderRepository.findByOrderStatus(status);
    }
}