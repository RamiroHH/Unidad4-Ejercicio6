package com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain;

import com.programacion4.unidad4ej6.feature.insumo.dtos.request.MovimientoStockDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.StockResponseDTO;

public interface IInsumoStockService {

    StockResponseDTO movimiento(Long id, MovimientoStockDTO dto);
}