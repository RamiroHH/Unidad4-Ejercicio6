package com.programacion4.unidad4ej6.feature.insumo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad4ej6.feature.insumo.models.HistorialPrecio;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHistorialPrecioRepository extends CrudRepository<HistorialPrecio, Long> {
    Optional<HistorialPrecio> findTopByInsumoIdOrderByFechaDesc(Long insumoId);
    List<HistorialPrecio> findTop5ByInsumoIdOrderByFechaDesc(Long insumoId);
}
