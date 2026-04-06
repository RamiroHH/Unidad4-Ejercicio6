package com.programacion4.unidad4ej6.feature.insumo.controllers.post;

import com.programacion4.unidad4ej6.config.BaseResponse;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.InsumoCreateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoCreateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoCreateController {

    private final IInsumoCreateService service;

    @PostMapping
    public ResponseEntity<BaseResponse<InsumoResponseDTO>> create(
            @Valid @RequestBody InsumoCreateDTO dto) {

        return ResponseEntity.status(201).body(
                BaseResponse.ok(
                        service.create(dto),
                        "Insumo creado correctamente"
                )
        );
    }
}