package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.EmpresaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.EmpresaMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.EmpresaService;
import com.entidades.buenSabor.domain.dto.EmpresaDto;
import com.entidades.buenSabor.domain.dto.EmpresaLargeDto;
import com.entidades.buenSabor.domain.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaFacadeImp extends BaseFacadeImp<Empresa, EmpresaDto, EmpresaDto,Long> implements EmpresaFacade {

    public EmpresaFacadeImp(BaseService<Empresa, Long> baseService, BaseMapper<Empresa, EmpresaDto, EmpresaDto>baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    EmpresaMapper empresaMapper;


    @Autowired
    EmpresaService empresaService;
    @Override
    public EmpresaLargeDto addSucursal(Long idEmpresa, Long idSucursal) {
        return empresaMapper.toLargeDto(empresaService.addSucursal(idEmpresa, idSucursal));
    }

    @Override
    public EmpresaDto findBySucursal(Long idSucursal) {
        return this.empresaMapper.toDTO(this.empresaService.findBySucursal(idSucursal));
    }

    @Override
    public List<EmpresaDto> getAll() {
        return super.getAll();
    }


    @Override
    public EmpresaDto findBySucursalID(Long idSucursal) {
        return this.empresaMapper.toDTO(this.empresaService.findBySucursalID(idSucursal));
    }
}
