package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import com.elSurco.ElSurco_in5bv.Service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/get")
    public List<Login> listar() {
        return loginService.listar();
    }

    @GetMapping("/{id}")
    public Login obtener(@PathVariable Integer id) {
        return loginService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Login crear(@RequestBody Login login) {
        return loginService.agregar(login);
    }

    @PutMapping("/put/{Id}")
    public Login actualizar(@PathVariable("Id") Integer id, @RequestBody Login login) {
        return loginService.actualizar(id, login);
    }

    @DeleteMapping("/{id}")
    public Login eliminar(@PathVariable Integer id) {
        loginService.eliminar(id);
        return null;
    }
}