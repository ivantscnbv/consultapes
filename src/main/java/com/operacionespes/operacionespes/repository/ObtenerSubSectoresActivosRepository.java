package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.entity.SubSectores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObtenerSubSectoresActivosRepository  extends JpaRepository<SubSectores, Integer> {

    @Query(value = "SELECT SubSectorId\n" +
            "      ,LTRIM(RTRIM(SubSectorNombreLargo)) AS SubSectorNombreLargo\n" +
            "  FROM SubSectores\n" +
            "  WHERE EstadoId = 1\n" +
            "  ORDER BY SubSectorNombreLargo", nativeQuery = true)
    List<Object[]> obtenerTodosLosSubSectoresActivos ();



    @Query (value = "SELECT SubSectorId" +
            "  ,LTRIM(RTRIM(SubSectorNombreLargo)) AS SubSectorNombreLargo" +
            "  FROM SubSectores" +
            "  WHERE EstadoId = 1 AND SubSectorId = :SubSectorId" +
            "ORDER BY SubSectorNombreLargo", nativeQuery = true)
    List<Object[]> obtenerSubSectoresActivos (@Param("SubSectorId") Integer SubSectorId);

}
