package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.QuerySubSectoresActivosDto;
import com.operacionespes.operacionespes.repository.ObtenerSubSectoresActivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operacionespes")
public class ObtenerSubSectoresActivosController {

    @Autowired
    private ObtenerSubSectoresActivosRepository obtenerSubSectoresActivosRepository;

    @GetMapping("/ObtenerSubSectoresActivo")
    public ResponseEntity<List<QuerySubSectoresActivosDto>> obtenerTodosLosSubSectoresActivos() {
        List<QuerySubSectoresActivosDto> relaciones = obtenerSubSectoresActivosRepository.obtenerTodosLosSubSectoresActivos();
        return new ResponseEntity<>(relaciones, HttpStatus.OK);
    }

    @GetMapping("/SubSector")
    public ResponseEntity<QuerySubSectoresActivosDto> obtenerSubSectorActivo(
            @RequestParam("SubSectorId") Integer SubSectorId) {
        try {
            QuerySubSectoresActivosDto relacion = (QuerySubSectoresActivosDto) obtenerSubSectoresActivosRepository.obtenerSubSectoresActivos(SubSectorId);
            if (relacion != null) {
                return new ResponseEntity<>(relacion, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
