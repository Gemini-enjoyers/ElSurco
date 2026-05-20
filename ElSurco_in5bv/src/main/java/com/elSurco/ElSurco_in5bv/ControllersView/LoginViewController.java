package com.elSurco.ElSurco_in5bv.ControllersView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

    // Su única responsabilidad es renderizar visualmente el formulario HTML
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}