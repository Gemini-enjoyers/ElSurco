package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.User; // Nueva importación
import com.elSurco.ElSurco_in5bv.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody User user) {
        authService.register(user);
        return "User registered successfully.";
    }

    @PostMapping("/login")
    public Map<String, Object> login(@Valid @RequestBody User user) {
        return authService.login(user);
    }
}