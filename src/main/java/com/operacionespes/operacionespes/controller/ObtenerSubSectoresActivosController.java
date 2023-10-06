package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.QuerySubSectoresActivosDto;
import com.operacionespes.operacionespes.entity.SubSectores;
import com.operacionespes.operacionespes.repository.ObtenerSubSectoresActivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operacionespes")
public class ObtenerSubSectoresActivosController {

    @Autowired
    private ObtenerSubSectoresActivosRepository obtenerSubSectoresActivosRepository;

    @GetMapping("/ObtenerSubSectoresActivo")
    public ResponseEntity<List<SubSectores>> obtenerTodosLosSubSectoresActivos() {
        List<SubSectores> resultados = new ArrayList<>();
        List<Object[]> relaciones = obtenerSubSectoresActivosRepository.obtenerTodosLosSubSectoresActivos();

        for (Object[] relacion : relaciones) {
            SubSectores resultado = new SubSectores();
            resultado.setSubSectorId((Integer) relacion[0]);
            resultado.setSubSectorNombreLargo((String) relacion[1]);
            resultados.add(resultado);
        }

        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }

    @GetMapping("/Id")
    public ResponseEntity<List<SubSectores>> obtenerSubSectoresActivos(
            @RequestParam("SubSectorId") Integer SubSectorId) {
        List<SubSectores> resultados = new ArrayList<>();
        List<Object[]> relaciones = obtenerSubSectoresActivosRepository.obtenerSubSectoresActivos(SubSectorId);

        for (Object[] relacion : relaciones) {
            SubSectores resultado = new SubSectores();
            resultado.setSubSectorId((Integer) relacion[0]);
            resultado.setSubSectorNombreLargo((String) relacion[1]);
            resultados.add(resultado);
        }

        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }

}
