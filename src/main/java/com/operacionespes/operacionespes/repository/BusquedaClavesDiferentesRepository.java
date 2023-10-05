package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusquedaClavesDiferentesRepository extends JpaRepository<RelacionesArbol, Integer> {

    @Query(value = "Select ArbolId, PersonaMoralId as ClavePES, SubSectorId " +
            "from RelacionesArbol " +
            "where ArbolId = (select RelacionesArbol_ArbolId from RelacionesClavesDinamicasArbol " +
            "where ClaveDinamicaId = :ClaveDinamicaId and Valor_ClaveDinamica = :Valor_ClaveDinamica)", nativeQuery = true)
    List<Object[]> queryClavesDiferentes(@Param("ClaveDinamicaId") Integer ClaveDinamicaId,
                                         @Param("Valor_ClaveDinamica") String Valor_ClaveDinamica);

    @Query(value = "SELECT TOP 1 a.ArbolId, b.PersonaMoralId, b.SubSectorId " +
            "                    FROM HistoricoClavesDinamicas a " +
            "                    JOIN RelacionesArbol b ON (a.ArbolId = b.ArbolId) " +
            "                    WHERE a.EstadoId = 1 " +
            "                    AND b.EstadoId = 1 " +
            "                    AND a.ClaveDinamicaId = :ClaveDinamicaId " +
            "                    AND a.ValorClaveDinamica = :ValorClaveDinamica", nativeQuery = true)
    List<Object[]> queryHistorico(@Param("ClaveDinamicaId") Integer ClaveDinamica,
                                  @Param("ValorClaveDinamica") String Valor_ClaveDinamica);
}
