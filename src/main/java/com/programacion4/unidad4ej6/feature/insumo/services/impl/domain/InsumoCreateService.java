package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import com.programacion4.unidad4ej6.config.exceptions.BadRequestException;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.InsumoCreateDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IHistorialPrecioRepository;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoCreateService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class InsumoCreateService implements IInsumoCreateService {

    private final IInsumoRepository insumoRepository;
    private final IHistorialPrecioRepository historialRepository;

    @Override
    public InsumoResponseDTO create(InsumoCreateDTO dto) {

        if (insumoRepository.existsByCodigoInterno(dto.getCodigoInterno())) {
            throw new BadRequestException("El código ya existe");
        }

        Insumo insumo = new Insumo();
        insumo.setNombre(dto.getNombre());
        insumo.setCodigoInterno(dto.getCodigoInterno());
        insumo.setStockActual(0.0);
        insumo.setActivo(true);

        insumoRepository.save(insumo);

        HistorialPrecio historial = new HistorialPrecio();
        historial.setInsumo(insumo);
        historial.setPrecio(dto.getPrecioInicial());
        historial.setFecha(LocalDateTime.now());

        historialRepository.save(historial);

        return new InsumoResponseDTO(
                insumo.getId(),
                insumo.getNombre(),
                insumo.getCodigoInterno(),
                dto.getPrecioInicial(),
                0.0
        );
    }
}