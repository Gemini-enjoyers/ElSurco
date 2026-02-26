package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import com.elSurco.ElSurco_in5bv.Service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<List<Login>> listarTodos() {
        return new ResponseEntity<>(loginService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> buscarPorId(@PathVariable Integer id) {
        Login login = loginService.findById(id);
        if (login != null) {
            return new ResponseEntity<>(login, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Login> guardar(@Valid @RequestBody Login login) {
        Login nuevoLogin = loginService.save(login);
        return new ResponseEntity<>(nuevoLogin, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        loginService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}