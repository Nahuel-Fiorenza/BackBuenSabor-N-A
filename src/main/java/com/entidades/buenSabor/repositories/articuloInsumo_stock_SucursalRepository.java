package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.ArticuloInsumo_stock_Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface articuloInsumo_stock_SucursalRepository extends BaseRepository<ArticuloInsumo_stock_Sucursal,Long> {

       @Query("SELECT ss FROM ArticuloInsumo_stock_Sucursal ss WHERE ss.sucursal.id = :idSucursal")
    List<ArticuloInsumo_stock_Sucursal> findBySucursalId(@Param("idSucursal") Long idSucursal);

    @Query("SELECT ss FROM ArticuloInsumo_stock_Sucursal ss WHERE ss.articuloInsumo.id = :articuloInsumoId AND ss.sucursal.id = :sucursalId")
    List<ArticuloInsumo_stock_Sucursal> findByArticuloInsumoIdAndSucursalId(@Param("articuloInsumoId") Long articuloInsumoId, @Param("sucursalId") Long sucursalId);
}
