package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.QuerySubSectoresActivosDto;
import com.operacionespes.operacionespes.service.ObtenerSubSectoresActivosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/operacionespes")
public class ObtenerSubSectoresActivosController {

    @Autowired
    private ObtenerSubSectoresActivosService obtenerSubSectoresActivos;

    @GetMapping("/ObtenerSubSectoresActivo")
    public ResponseEntity<List<QuerySubSectoresActivosDto>> obtenerTodosLosSubSectoresActivos() {
        log.info("Dentro del metodo obtenerTodosLosSubSectoresActivos de la clase ObtenerSubSectoresActivosController.");
        return obtenerSubSectoresActivos.obtenerTodosLosSubSectoresActivos();
    }

    @GetMapping("/SubSector")
    public ResponseEntity<QuerySubSectoresActivosDto> obtenerSubSectorActivo(
            @RequestParam("SubSectorId") Integer SubSectorId) {
        log.info("Dentro del metodo obtenerSubSectorActivo de la clase ObtenerSubSectoresActivosController.");
        return obtenerSubSectoresActivos.obtenerSubSectorActivo(SubSectorId);
    }
}
