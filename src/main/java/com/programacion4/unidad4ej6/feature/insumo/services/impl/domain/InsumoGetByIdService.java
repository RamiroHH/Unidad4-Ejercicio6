package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import com.programacion4.unidad4ej6.config.exceptions.NotFoundException;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.HistorialPrecioDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoDetailDTO;
import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IHistorialPrecioRepository;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoGetByIdService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InsumoGetByIdService implements IInsumoGetByIdService {

    private final IInsumoRepository insumoRepository;
    private final IHistorialPrecioRepository historialRepository;

    @Override
    public InsumoDetailDTO getById(Long id) {

        Insumo insumo = insumoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Insumo no encontrado"));

        List<HistorialPrecio> historial = historialRepository
                .findTop5ByInsumoIdOrderByFechaDesc(id);

        List<HistorialPrecioDTO> historialDTO = historial.stream()
                .map(h -> new HistorialPrecioDTO(h.getPrecio(), h.getFecha()))
                .toList();

        Double precioActual = historial.isEmpty() ? 0.0 : historial.get(0).getPrecio();

        return new InsumoDetailDTO(
                insumo.getId(),
                insumo.getNombre(),
                insumo.getCodigoInterno(),
                precioActual,
                insumo.getStockActual(),
                historialDTO
        );
    }
}