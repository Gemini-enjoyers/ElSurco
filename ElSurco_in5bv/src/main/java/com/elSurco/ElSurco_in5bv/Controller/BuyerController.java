package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Buyer;
import com.elSurco.ElSurco_in5bv.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {
    private final UserService userService;

    public BuyerController(UserService userService) { this.userService = userService; }

    @GetMapping("/getAll")
    public List<Buyer> getAll() { return userService.getAll(); }

    @GetMapping("/{id}")
    public Buyer getById(@PathVariable Integer id) { return userService.getById(id); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer create(@Valid @RequestBody Buyer buyer) { return userService.create(buyer); }

    @PutMapping("/update/{id}")
    public Buyer update(@PathVariable("id") Integer id, @RequestBody Buyer buyer) {
        return userService.update(id, buyer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) { userService.delete(id); }
}