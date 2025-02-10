package com.entidades.buenSabor.domain.dto;

import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticuloInsumo_stock_SucursalDto extends ArticuloDto {
    private Integer stockActual;
    private ArticuloInsumo articuloInsumo;
    private Sucursal sucursal;
}
