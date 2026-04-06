package com.programacion4.unidad4ej6.feature.insumo.controllers.put;

import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoRestoreService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insumos")
@AllArgsConstructor
public class InsumoRestoreController {

    private final IInsumoRestoreService service;

    @PutMapping("/{id}/restore")
    public ResponseEntity<Void> restore(@PathVariable Long id) {

        service.restore(id);
        return ResponseEntity.ok().build();
    }
}