package com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain;

import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoDetailDTO;

public interface IInsumoGetByIdService {

    InsumoDetailDTO getById(Long id);
}