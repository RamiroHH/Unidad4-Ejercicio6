package com.programacion4.unidad4ej6.feature.insumo.controllers.get;

import com.programacion4.unidad4ej6.config.BaseResponse;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoDetailDTO;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoGetByIdService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoGetController {

    private final IInsumoGetByIdService service;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<InsumoDetailDTO>> getById(@PathVariable Long id) {

        return ResponseEntity.ok(
                BaseResponse.ok(
                        service.getById(id),
                        "Detalle del insumo"
                )
        );
    }
}