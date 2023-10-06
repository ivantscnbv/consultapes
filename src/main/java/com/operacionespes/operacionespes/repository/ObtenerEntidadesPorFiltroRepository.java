package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.dto.ObtenerEntidadesPorFiltroDto;
import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObtenerEntidadesPorFiltroRepository extends JpaRepository<RelacionesArbol, Integer> {

    @Query(value = "SELECT NEW com.operacionespes.operacionespes.dto.ObtenerEntidadesPorFiltroDto (ra.ArbolId, pm.PersonaMoralId, LTRIM(RTRIM(pm.PersonaMoralRazonSocial)) AS RazonSocial, " +
            "                           LTRIM(RTRIM(pm.PersonaMoralNomcorto)) AS NombreCorto, ss.SubSectorId, " +
            "                           LTRIM(RTRIM(ss.SubSectorNombreLargo)) AS SubsectorNombreLargo, " +
            "                           LTRIM(RTRIM(ar.AreaId)) as AreaId, LTRIM(RTRIM(ar.AreaNombre)) AS AreaNombre) " +
            "FROM RelacionesArbol ra " +
            "INNER JOIN PersonasMorales pm ON (ra.PersonaMoralId = pm.PersonaMoralId) " +
            "INNER JOIN SubSectores ss ON (ra.SubSectorId = ss.SubSectorId) " +
            "INNER JOIN Areas ar ON (ra.AreaId = ar.AreaId) " +
            "WHERE " +
            "    (pm.PersonaMoralId IS NOT NULL OR ss.SubSectorId IS NOT NULL OR ss.SubSectorNombreLargo IS NOT NULL) " +
            "    AND " +
            "    (pm.PersonaMoralId = :PersonaMoralId OR ss.SubSectorId = :SubSectorId OR ss.SubSectorNombreLargo = :SubSectorNombreLargo)")
    List<ObtenerEntidadesPorFiltroDto> queryObtenerEntidadesFiltro(@Param("SubSectorNombreLargo") String SubSectorNombreLargo,
                                                                   @Param("SubSectorId") Integer SubSectorId,
                                                                   @Param("PersonaMoralId") Integer PersonaMoralId);
}
