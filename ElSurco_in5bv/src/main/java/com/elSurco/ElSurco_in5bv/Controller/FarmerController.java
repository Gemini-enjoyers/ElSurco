package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Farmer;
import com.elSurco.ElSurco_in5bv.Service.FarmerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/farmer")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping("/getAll")
    public List<Farmer> getAll(){
        return farmerService.getAll();
    }

    @GetMapping("/{id}")
    public Farmer getById(@PathVariable Integer id){
        return farmerService.getById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Farmer create (@Valid @RequestBody Farmer farmer){
        return farmerService.create(farmer);
    }

    @PutMapping("/update/{id}")
    public Farmer update(@PathVariable("id") Integer id, @RequestBody Farmer farmer){
        return farmerService.update(id, farmer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        farmerService.delete(id);
    }

    @PostMapping("/register")
    public String processFarmerRegistration(
            @RequestParam("farmerFirstName") String firstName,
            @RequestParam("farmerLastName") String lastName,
            @RequestParam("farmerDpi") String dpi,
            @RequestParam("farmerPhone") Long phone,
            @RequestParam("farmerAddress") String address,
            @RequestParam(value = "farmerHistory", required = false) String history,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        if (principal == null) {
            redirectAttributes.addFlashAttribute("error", "Debes iniciar sesión para volverte agricultor.");
            return "redirect:/login";
        }

        try {
            String userEmail = principal.getName();

            // Enviamos todos los parámetros exactos exigidos por tu base de datos al Service
            farmerService.createFarmerProfile(userEmail, firstName, lastName, dpi, phone, address, history);

            redirectAttributes.addFlashAttribute("success", "¡Felicidades! Tu perfil de Agricultor ha sido aprobado con éxito. Vuelve a iniciar sesión para actualizar tus permisos.");
            return "redirect:/contact";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al procesar la solicitud: " + e.getMessage());
            return "redirect:/contact";
        }
    }
}