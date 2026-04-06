package com.programacion4.unidad4ej6.feature.insumo.controllers.post;

import com.programacion4.unidad4ej6.config.BaseResponse;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.MovimientoStockDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.StockResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoStockService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoStockController {

    private final IInsumoStockService service;

    @PostMapping("/{id}/stock")
    public ResponseEntity<BaseResponse<StockResponseDTO>> movimiento(
            @PathVariable Long id,
            @Valid @RequestBody MovimientoStockDTO dto) {

        return ResponseEntity.ok(
                BaseResponse.ok(
                        service.movimiento(id, dto),
                        "Movimiento registrado correctamente"
                )
        );
    }
}