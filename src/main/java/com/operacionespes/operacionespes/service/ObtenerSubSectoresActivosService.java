package com.operacionespes.operacionespes.service;

import com.operacionespes.operacionespes.dto.QuerySubSectoresActivosDto;
import com.operacionespes.operacionespes.repository.ObtenerSubSectoresActivosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ObtenerSubSectoresActivosService {

    @Autowired
    private ObtenerSubSectoresActivosRepository obtenerSubSectoresActivosRepository;

    public ResponseEntity<List<QuerySubSectoresActivosDto>> obtenerTodosLosSubSectoresActivos() {
        log.info("Dentro del metodo obtenerTodosLosSubSectoresActivos de la clase ObtenerSubSectoresActivosService.");
        List<QuerySubSectoresActivosDto> relaciones = obtenerSubSectoresActivosRepository.obtenerTodosLosSubSectoresActivos();
        return new ResponseEntity<>(relaciones, HttpStatus.OK);
    }

    public ResponseEntity<QuerySubSectoresActivosDto> obtenerSubSectorActivo(
            Integer SubSectorId) {
        log.info("Dentro del metodo obtenerSubSectorActivo de la clase ObtenerSubSectoresActivosService.");
        try {
            QuerySubSectoresActivosDto relacion = obtenerSubSectoresActivosRepository.obtenerSubSectoresActivos(SubSectorId);
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
