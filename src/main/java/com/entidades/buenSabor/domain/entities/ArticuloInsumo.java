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
public class ArticuloInsumo extends Articulo{
    private Double precioCompra;

    @OneToMany(mappedBy = "articuloInsumo", cascade = CascadeType.ALL)
    @NotAudited
    private ArticuloInsumo_stock_Sucursal articuloInsumo_stock_sucursal;

    private Integer stockMaximo;
    private Integer stockMinimo;
    private Boolean esParaElaborar;

}
