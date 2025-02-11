package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

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

    @ManyToOne
    @JoinColumn(name = "articulo_insumo_id", nullable = false)
    private ArticuloInsumo articuloInsumo;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

}
