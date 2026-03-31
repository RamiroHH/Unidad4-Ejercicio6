package com.programacion4.unidad4ej6.feature.producto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad4ej6.feature.producto.models.HistorialPrecio;

@Repository
public interface IHistorialPrecioRepository extends CrudRepository<HistorialPrecio, Long> {
    
}
