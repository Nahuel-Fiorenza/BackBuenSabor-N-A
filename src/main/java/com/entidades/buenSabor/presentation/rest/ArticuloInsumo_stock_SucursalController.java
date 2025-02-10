package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ArticuloInsumoFacadeImp;
import com.entidades.buenSabor.domain.dto.ArticuloInsumo_stock_SucursalDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo_stock_Sucursal;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articuloInsumo_stock_Sucursal")
@CrossOrigin("*")
public class ArticuloInsumo_stock_SucursalController extends BaseControllerImp<ArticuloInsumo_stock_Sucursal, ArticuloInsumo_stock_SucursalDto, ArticuloInsumo_stock_SucursalDto, Long, ArticuloInsumo_stock_SucursalFacadeImp> {
    public ArticuloInsumo_stock_SucursalController(ArticuloInsumoFacadeImp facade) {
        super(facade);
    }

    @GetMapping("/findBySucursal/{idSucursal}")
    // @PreAuthorize("hasAnyAuthority('superadmin','administrador', 'cajero', 'cocinero')")
    public ResponseEntity<?> findBySucursales(@PathVariable("idSucursal") Long idSucursal) {
        return ResponseEntity.ok(facade.findBySucursales(idSucursal));
    }

    @GetMapping("/paraVenta/{idSucursal}")
    public ResponseEntity<?> paraVenta(@PathVariable("idSucursal") Long idSucursal) {
        return ResponseEntity.ok(facade.paraVenta(idSucursal));
    }

   }