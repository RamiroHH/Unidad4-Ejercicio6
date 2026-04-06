package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import com.programacion4.unidad4ej6.config.exceptions.NotFoundException;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoDeleteService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InsumoDeleteService implements IInsumoDeleteService {

    private final IInsumoRepository insumoRepository;

    @Override
    public void delete(Long id) {

        Insumo insumo = insumoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Insumo no encontrado"));

        insumo.setActivo(false); // 🔥 soft delete
        insumoRepository.save(insumo);
    }
}