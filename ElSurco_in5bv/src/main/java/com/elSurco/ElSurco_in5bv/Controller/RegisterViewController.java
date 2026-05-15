package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterViewController {

    @Controller
    public class RegisterController {

        // Esto sirve para mostrar la página (el HTML que hicimos)
        @GetMapping("/register")
        public String showRegisterPage() {
            return "register"; // Debe coincidir con el nombre del archivo en /templates
        }

        // Esto sirve para recibir los datos del formulario
        @PostMapping("/register")
        public String processRegister(User user) {
            // Aquí iría la lógica para guardar en la DB usando tu Service
            System.out.println("Usuario recibido: " + user.getHandle());
            return "redirect:/login?success"; // Redirige al login tras éxito
        }
    }

}
