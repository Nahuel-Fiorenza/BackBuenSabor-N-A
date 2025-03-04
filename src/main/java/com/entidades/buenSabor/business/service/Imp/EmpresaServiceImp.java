package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.EmpresaService;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Empresa;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImp extends BaseServiceImp<Empresa,Long> implements EmpresaService {

    @Autowired
    SucursalService sucursalService;

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public Empresa addSucursal(Long idEmpresa, Long idSucursal) {
        Empresa empresa = empresaRepository.findWithSucursalesById(idEmpresa);
        empresa.getSucursales().add(sucursalService.getById(idSucursal));
        Sucursal sucursal = this.sucursalService.getById(idSucursal);
        sucursal.setEmpresa(empresa);
        this.sucursalService.update(sucursal,idSucursal);
        return empresa;
    }

    @Override
    public Empresa update(Empresa request, Long id) {
        Empresa empresa = this.empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La empresa id: " + id + " no existe."));
        request.setSucursales(empresa.getSucursales());
        return super.update(request, id);
    }

    @Override
    public Empresa findBySucursal(Long idSucursal) {
        return this.empresaRepository.findWithSucursalesById(idSucursal);
    }

    @Override
    public Empresa findBySucursalID(Long idSucursal) {
        return this.empresaRepository.findSucursalesByID(idSucursal);
    }
 }
