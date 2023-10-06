package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.dto.QueryClavesDiferentesDto;
import com.operacionespes.operacionespes.dto.QueryHistoricoDto;
import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusquedaClavesDiferentesRepository extends JpaRepository<RelacionesArbol, Integer> {

    @Query(value = "SELECT NEW com.operacionespes.operacionespes.dto.QueryClavesDiferentesDto(ra.ArbolId, ra.PersonaMoralId, ra.SubSectorId) " +
            "from RelacionesArbol ra " +
            "where ArbolId = (SELECT RelacionesArbol_ArbolId from RelacionesClavesDinamicasArbol rcd " +
            "where rcd.ClaveDinamicaId = :ClaveDinamicaId and rcd.Valor_ClaveDinamica = :Valor_ClaveDinamica)")
    List<QueryClavesDiferentesDto> queryClavesDiferentes(@Param("ClaveDinamicaId") Integer ClaveDinamicaId,
                                                         @Param("Valor_ClaveDinamica") String Valor_ClaveDinamica);

    @Query(value = "SELECT NEW com.operacionespes.operacionespes.dto.QueryHistoricoDto(a.ArbolId, b.PersonaMoralId, b.SubSectorId) " +
            "FROM HistoricoClavesDinamicas a " +
            "JOIN RelacionesArbol b ON (a.ArbolId = b.ArbolId) " +
            "WHERE a.EstadoId = 1 " +
            "AND b.EstadoId = 1 " +
            "AND a.ClaveDinamicaId = :ClaveDinamicaId " +
            "AND a.ValorClaveDinamica = :ValorClaveDinamica")
    List<QueryHistoricoDto> queryHistorico(@Param("ClaveDinamicaId") Integer ClaveDinamica,
                                           @Param("ValorClaveDinamica") String Valor_ClaveDinamica,
                                           Pageable pageable);
}
