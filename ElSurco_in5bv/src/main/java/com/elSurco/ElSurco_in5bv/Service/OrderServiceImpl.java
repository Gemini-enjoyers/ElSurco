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
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Order with ID " + id + " not found."));
    }

    @Override
    public Order create(Order order) {
        order.setIdBuyOrder(null);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Integer id, Order order) {
        Order existingOrder = getById(id);

        // Actualizamos los campos
        existingOrder.setOrderTotal(order.getOrderTotal());
        existingOrder.setOrderQuantity(order.getOrderQuantity());
        existingOrder.setOrderStatus(order.getOrderStatus());
        existingOrder.setPaymentMethod(order.getPaymentMethod()); // Añadido de tu nueva BD

        // CRÍTICO: Reemplazamos Buyer por User
        existingOrder.setUser(order.getUser());
        existingOrder.setProduct(order.getProduct());

        return orderRepository.save(existingOrder);
    }

    @Override
    public void delete(Integer id) {
        Order existingOrder = getById(id);
        orderRepository.delete(existingOrder);
    }

    // CRÍTICO: Cambiamos este método para que busque por User en lugar de Buyer
    @Override
    public List<Order> getByUser(Integer idUser) {
        return orderRepository.findByUser_IdUser(idUser);
    }

    @Override
    public List<Order> getByStatus(OrderStatus status) {
        return orderRepository.findByOrderStatus(status);
    }
}