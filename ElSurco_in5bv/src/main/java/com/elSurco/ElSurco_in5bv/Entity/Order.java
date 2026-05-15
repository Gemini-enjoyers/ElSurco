package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.OrderStatus;
import com.elSurco.ElSurco_in5bv.Util.paymentMethod;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "BuyOrders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBuyOrder")
    private Integer idBuyOrder;

    @Column(name = "orderDate", insertable = false, updatable = false)
    private LocalDateTime orderDate;

    @Column(name = "orderTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal orderTotal;

    @Column(name = "orderQuantity", nullable = false)
    private Integer orderQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus", nullable = false)
    private OrderStatus orderStatus = OrderStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentMethod", nullable = false)
    private paymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

    public Order() {}

    public Integer getIdBuyOrder() { return idBuyOrder; }
    public void setIdBuyOrder(Integer idBuyOrder) { this.idBuyOrder = idBuyOrder; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public BigDecimal getOrderTotal() { return orderTotal; }
    public void setOrderTotal(BigDecimal orderTotal) { this.orderTotal = orderTotal; }
    public Integer getOrderQuantity() { return orderQuantity; }
    public void setOrderQuantity(Integer orderQuantity) { this.orderQuantity = orderQuantity; }
    public OrderStatus getOrderStatus() { return orderStatus; }
    public void setOrderStatus(OrderStatus orderStatus) { this.orderStatus = orderStatus; }
    public paymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(paymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}