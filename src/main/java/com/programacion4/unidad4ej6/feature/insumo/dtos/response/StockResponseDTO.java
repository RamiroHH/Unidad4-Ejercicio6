package com.programacion4.unidad4ej6.feature.insumo.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockResponseDTO {

    private Long insumoId;
    private Double stockActual;
}