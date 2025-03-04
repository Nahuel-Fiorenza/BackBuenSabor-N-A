package com.entidades.buenSabor.business.facade.Base;


import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.DomicilioService;
import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.entities.Base;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseFacadeImp <E extends Base,D extends BaseDto, GD extends BaseDto, ID extends Serializable> implements BaseFacade<D,GD,ID> {

    protected BaseService<E,ID> baseService;
    protected BaseMapper<E,D,GD> baseMapper;

    public BaseFacadeImp(BaseService<E,ID> baseService, BaseMapper<E,D,GD> baseMapper) {
        this.baseService = baseService;
        this.baseMapper = baseMapper;
    }

    public BaseFacadeImp(DomicilioService domicilioService) {
    }

    public GD createNew(D request){
        // Convierte a entidad
        var entityToCreate = baseMapper.toEntity(request);
        // Graba una entidad
        var entityCreated = baseService.create(entityToCreate);
        // convierte a Dto para devolver
        return baseMapper.toDTO(entityCreated);
    }

    public GD getById(ID id){
        // Busca una entidad por id
        var entity = baseService.getById(id);
        // convierte la entidad a DTO
        return baseMapper.toDTO(entity);
    }

    public List<GD> getAll(){
        // trae una lista de entidades
        var entities = baseService.getAll();
        //  devuelve una lista de DTO
        return entities
                .stream()
                .map(baseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(ID id){
        var entity = baseService.getById(id);
        baseService.deleteById(id);
    }

    public GD update(D request, ID id){
        var entityToUpdate = baseMapper.toEntity(request);
        var entityUpdated = baseService.update(entityToUpdate, id);
        return baseMapper.toDTO(entityUpdated);
    }

}
