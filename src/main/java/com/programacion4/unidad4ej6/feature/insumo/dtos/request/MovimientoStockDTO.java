package com.programacion4.unidad4ej6.feature.insumo.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MovimientoStockDTO {

    @NotNull(message = "La cantidad es obligatoria")
    @DecimalMin(value = "0.01", message = "Debe ser mayor a 0.01")
    private Double cantidad;

    @NotBlank(message = "El tipo es obligatorio")
    @Pattern(regexp = "ENTRADA|SALIDA", message = "Debe ser ENTRADA o SALIDA")
    private String tipo;
}