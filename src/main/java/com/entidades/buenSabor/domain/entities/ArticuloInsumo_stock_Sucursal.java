package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class ArticuloInsumo_stock_Sucursal extends Articulo{
    private Integer stockActual;
    private ArticuloInsumo articuloInsumo;
    private Sucursal sucursal;
}
