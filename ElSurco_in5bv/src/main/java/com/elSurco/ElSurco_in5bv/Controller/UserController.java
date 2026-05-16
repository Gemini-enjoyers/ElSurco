package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.User;
import com.elSurco.ElSurco_in5bv.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/getAll")
    public List<User> getAll() { return userService.getAll(); }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) { return userService.getById(id); }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User user) { return userService.create(user); }

    @PutMapping("/update/{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) { userService.delete(id); }
}