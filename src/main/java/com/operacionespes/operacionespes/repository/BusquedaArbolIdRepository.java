package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.entity.RelacionesArbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusquedaArbolIdRepository extends JpaRepository<RelacionesArbol, Integer> {

    @Query(value = "SELECT ra.ArbolId FROM RelacionesArbol ra " +
            "WHERE ra.PersonaMoralId = :PersonaMoralId " +
            "AND ra.SubSectorId = :SubSectorId")
    List<Object[]> queryRelacionArbol(@Param("PersonaMoralId") Integer PersonaMoralId,
                                      @Param("SubSectorId") Integer SubSectorId);
}
