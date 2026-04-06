package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InsumoDetailDTO {

    private Long id;
    private String nombre;
    private String codigoInterno;
    private Double precioActual;
    private Double stockActual;
    private List<HistorialPrecioDTO> historial;
}