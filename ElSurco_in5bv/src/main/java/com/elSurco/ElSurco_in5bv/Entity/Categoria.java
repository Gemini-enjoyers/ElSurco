package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Column(nullable = false, length = 50)
    private String nombreCategoria;

    @Column(length = 150)
    private String descripcionCategoria;
}