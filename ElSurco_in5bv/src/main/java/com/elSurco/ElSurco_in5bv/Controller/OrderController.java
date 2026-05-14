package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Order;
import com.elSurco.ElSurco_in5bv.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping("/getAll")
    public List<Order> getAll() { return orderService.getAll(); }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Integer id) { return orderService.getById(id); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) { return orderService.create(order); }

    @PutMapping("/update/{id}")
    public Order update(@PathVariable("id") Integer id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) { orderService.delete(id); }
}