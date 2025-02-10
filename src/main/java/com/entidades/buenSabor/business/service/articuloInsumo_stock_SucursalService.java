package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo_stock_Sucursal;

import java.util.List;

public interface articuloInsumo_stock_SucursalService extends BaseService<ArticuloInsumo_stock_Sucursal, Long> {
    List<ArticuloInsumo_stock_Sucursal> findBySucursales(Long idSucursal);
}
