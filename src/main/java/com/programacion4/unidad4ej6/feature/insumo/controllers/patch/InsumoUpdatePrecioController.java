package com.programacion4.unidad4ej6.feature.insumo.controllers.patch;

import com.programacion4.unidad4ej6.config.BaseResponse;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.PrecioUpdateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoUpdatePrecioService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoUpdatePrecioController {

    private final IInsumoUpdatePrecioService service;

    @PatchMapping("/{id}/precio")
    public ResponseEntity<BaseResponse<InsumoResponseDTO>> updatePrecio(
            @PathVariable Long id,
            @Valid @RequestBody PrecioUpdateDTO dto) {

        return ResponseEntity.ok(
                BaseResponse.ok(
                        service.updatePrecio(id, dto),
                        "Precio actualizado correctamente"
                )
        );
    }
}