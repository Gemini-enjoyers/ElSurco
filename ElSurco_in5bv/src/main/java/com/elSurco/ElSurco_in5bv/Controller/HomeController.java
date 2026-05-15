package com.elSurco.ElSurco_in5bv.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController{

    @GetMapping("/home")

    public String home(){

        return "home"; //<-este es el nombre de la home en html.

    }

}
