package com.elSurco.ElSurco_in5bv.ControllersView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactViewController {

    @GetMapping("/contact")
    public String contactView(){
        return "contact";
    }
}
