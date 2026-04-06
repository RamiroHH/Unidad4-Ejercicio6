package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsumoResponseDTO {

    private Long id;
    private String nombre;
    private String codigoInterno;
    private Double precioActual;
    private Double stockActual;
}