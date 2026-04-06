package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import com.programacion4.unidad4ej6.config.exceptions.BadRequestException;
import com.programacion4.unidad4ej6.config.exceptions.NotFoundException;
import com.programacion4.unidad4ej6.feature.insumo.dtos.request.MovimientoStockDTO;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.StockResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.models.MovimientoStock;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IMovimientoStockRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoStockService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class InsumoStockService implements IInsumoStockService {

    private final IInsumoRepository insumoRepository;
    private final IMovimientoStockRepository movimientoRepository;

    @Override
    public StockResponseDTO movimiento(Long id, MovimientoStockDTO dto) {

        Insumo insumo = insumoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Insumo no encontrado"));

        Double stockActual = insumo.getStockActual();

        if (dto.getTipo().equals("SALIDA")) {

            if (stockActual < dto.getCantidad()) {
                throw new BadRequestException("Stock insuficiente");
            }

            stockActual -= dto.getCantidad();

        } else {

            stockActual += dto.getCantidad();
        }

        insumo.setStockActual(stockActual);
        insumoRepository.save(insumo);

        MovimientoStock mov = new MovimientoStock();
        mov.setInsumo(insumo);
        mov.setCantidad(dto.getCantidad());
        mov.setTipo(dto.getTipo());
        mov.setFecha(LocalDateTime.now());

        movimientoRepository.save(mov);

        return new StockResponseDTO(insumo.getId(), stockActual);
    }
}