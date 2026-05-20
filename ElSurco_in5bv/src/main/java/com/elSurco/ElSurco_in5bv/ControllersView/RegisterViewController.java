package com.elSurco.ElSurco_in5bv.ControllersView;

import com.elSurco.ElSurco_in5bv.Entity.User;
import com.elSurco.ElSurco_in5bv.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterViewController {

    @Autowired
    private AuthService authService; // 👈 Conectamos tu servicio real de registro

    // 1. Muestra la página e inyecta un objeto User vacío al modelo
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User()); // 👈 CRUCIAL para que Thymeleaf no falle
        return "register";
    }

    // 2. Recibe los datos del formulario de manera limpia
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user, Model model) {
        try {
            // Guarda el usuario (Cifra la contraseña y valida emails duplicados)
            authService.register(user);

            // Redirige al login con parámetro de éxito
            return "redirect:/login?success";
        } catch (IllegalArgumentException e) {
            // Si el correo ya existe, recarga la página mostrando el error
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}