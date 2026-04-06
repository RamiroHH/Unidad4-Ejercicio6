package com.programacion4.unidad4ej6.feature.insumo.controllers.delete;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoDeleteService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoDeleteController {

    private final IInsumoDeleteService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }
}