package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HistorialPrecioDTO {

    private Double precio;
    private LocalDateTime fecha;
}