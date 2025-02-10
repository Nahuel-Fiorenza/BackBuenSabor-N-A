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

         @Autowired
        private ArticuloInsumo_stock_SucursalControllerFacade stockSucursalFacade;

        @PutMapping("/actualizar")
        public ResponseEntity<StockSucursalDto> actualizarStock(
                @RequestParam Long articuloInsumoId,
                @RequestParam Long sucursalId,
                @RequestParam Integer cantidad) {
            return ResponseEntity.ok(stockSucursalFacade.actualizarStock(articuloInsumoId, sucursalId, cantidad));
        }
    }


}