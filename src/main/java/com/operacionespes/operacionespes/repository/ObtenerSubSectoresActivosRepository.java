package com.operacionespes.operacionespes.repository;

import com.operacionespes.operacionespes.entity.SubSectores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObtenerSubSectoresActivosRepository  extends JpaRepository<SubSectores, Integer> {

    @Query("SELECT NEW com.operacionespes.operacionespes.dto.QuerySubSectoresActivosDto(SubSectorId" +
            "  ,LTRIM(RTRIM(SubSectorNombreLargo)) AS SubSectorNombreLargo)" +
            "  FROM SubSectores" +
            "  WHERE EstadoId = 1" +
            "  ORDER BY SubSectorNombreLargo")
    List<Object[]> obtenerTodosLosSubSectoresActivos ();



    @Query ("SELECT NEW com.operacionespes.operacionespes.dto.QuerySubSectoresActivosDto(SubSectorId" +
            "  ,LTRIM(RTRIM(SubSectorNombreLargo)) AS SubSectorNombreLargo)" +
            "  FROM SubSectores" +
            "  WHERE EstadoId = 1 AND SubSectorId = :SubSectorId" +
            "ORDER BY SubSectorNombreLargo")
    List<Object[]> obtenerSubSectoresActivos (@Param("SubSectorId") Integer SubSectorId);

}
