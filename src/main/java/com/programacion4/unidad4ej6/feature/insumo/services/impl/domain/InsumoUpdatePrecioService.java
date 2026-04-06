package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import com.programacion4.unidad4ej6.config.exceptions.BadRequestException;
import com.programacion4.unidad4ej6.config.exceptions.NotFoundException;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.PrecioUpdateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IHistorialPrecioRepository;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoUpdatePrecioService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class InsumoUpdatePrecioService implements IInsumoUpdatePrecioService {

    private final IInsumoRepository insumoRepository;
    private final IHistorialPrecioRepository historialRepository;

    @Override
    public InsumoResponseDTO updatePrecio(Long id, PrecioUpdateDTO dto) {

        Insumo insumo = insumoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Insumo no encontrado"));

        HistorialPrecio ultimo = historialRepository
                .findTopByInsumoIdOrderByFechaDesc(id)
                .orElseThrow(() -> new BadRequestException("No hay historial de precios"));

        if (ultimo.getPrecio().equals(dto.getNuevoPrecio())) {
            throw new BadRequestException("El nuevo precio debe ser diferente al actual");
        }

        HistorialPrecio nuevo = new HistorialPrecio();
        nuevo.setInsumo(insumo);
        nuevo.setPrecio(dto.getNuevoPrecio());
        nuevo.setFecha(LocalDateTime.now());

        historialRepository.save(nuevo);

        return new InsumoResponseDTO(
                insumo.getId(),
                insumo.getNombre(),
                insumo.getCodigoInterno(),
                dto.getNuevoPrecio(),
                insumo.getStockActual()
        );
    }
}