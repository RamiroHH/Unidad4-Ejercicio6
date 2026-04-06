package com.programacion4.unidad4ej6.feature.insumo.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class InsumoCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50)
    private String nombre;

    @NotBlank(message = "El código es obligatorio")
    @Pattern(regexp = "LUMI-\\d{4}", message = "Formato inválido (LUMI-XXXX)")
    private String codigoInterno;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precioInicial;
}