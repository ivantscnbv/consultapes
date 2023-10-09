package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.dto.QueryDatosGeneralesDto;
import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusquedaPorSubSectorRepository extends JpaRepository<RelacionesArbol, Integer> {

    @Query(value = "SELECT NEW com.operacionespes.operacionespes.dto.QueryDatosGeneralesDto(a.ArbolId, " +
            "a.PersonaMoralId, " +
            "a.SubSectorId, " +
            "TRIM(b.PersonaMoralRazonSocial) AS RazonSocial, " +
            "b.PersonaMoralNomcorto, " +
            "b.PersonaMoralRFC, " +
            "b.PersonaMoralFechaConstitucion, " +
            "CASE a.Filial " +
            "WHEN 1 THEN 'Filia' " +
            "ELSE 'Nacional' " +
            "END AS Origen, " +
            "a.AreaId, " +
            "COALESCE(a.PadrePersonaMoralId, 0) AS Tenedoraid, " +
            "COALESCE(a.GrupoFinanciero, 0) AS GrupoFinanciero, " +
            "a.SituacionId, " +
            "d.EstatusId, " +
            "f.GrupoEstatusId) " +
            "FROM RelacionesArbol a, " +
            "PersonasMorales b, " +
            "SubSectores c, " +
            "Situaciones d, " +
            "Estatus f, " +
            "Areas g " +
            "WHERE " +
            "a.PersonaMoralId = b.PersonaMoralId AND " +
            "a.SubSectorId = c.SubSectorId AND " +
            "a.SituacionId = d.SituacionId AND " +
            "d.EstatusId = f.EstatusId AND " +
            "a.AreaId = g.AreaId AND " +
            "a.EstadoId = 1 AND " +
            "b.EstadoId = 1 AND " +
            "c.EstadoId = 1 AND " +
            "d.EstadoId = 1 AND " +
            "f.EstadoId = 1 AND " +
            "g.EstadoId = 1 AND " +
            "a.SubSectorId = :SubSectorId")
    List<QueryDatosGeneralesDto> queryDatosGenerales(@Param("SubSectorId") Integer SubSectorId);
}