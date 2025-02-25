package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends BaseRepository<Empresa,Long> {
    @Query("SELECT e FROM Empresa e LEFT JOIN FETCH e.sucursales WHERE e.id = :id")
    Empresa findWithSucursalesById(@Param("id") Long id);

    @Query("SELECT s.empresa FROM Sucursal s WHERE s.id = :sucursalId")
    Empresa findSucursalesByID(@Param("sucursalId") Long sucursalId);


}
