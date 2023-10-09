package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.QueryContactosDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesDto;
import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;
import com.operacionespes.operacionespes.repository.DireccionesyContactosRepository;
import com.operacionespes.operacionespes.response.ConsultaResultadoResponse;
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
public class DireccionesyContactosController {

    @Autowired
    private DireccionesyContactosRepository direccionesyContactosRepository;

    @GetMapping("/consulta")
    public ResponseEntity<ConsultaResultadoResponse> consultarDireccionesyContactos(
            @RequestParam("PersonaMoralId") Integer PersonaMoralId,
            @RequestParam("SubSectorId") Integer SubSectorId
    ) {
        ConsultaResultadoResponse consultaResultado = new ConsultaResultadoResponse();

        try {
            // Paso 1: Realiza la primera consulta
            List<QueryRelacionArbolDto> resultadosIniciales = direccionesyContactosRepository.obtenerArbolIds(PersonaMoralId, SubSectorId);
            consultaResultado.setResultadosIniciales(resultadosIniciales);

            // Paso 2: Utiliza el resultado de la primera consulta como parámetro para la segunda consulta
            List<QueryDireccionesDto> resultadosIntermedios = new ArrayList<>();
            for (QueryRelacionArbolDto ArbolDto : resultadosIniciales) {
                Integer ArbolId = ArbolDto.getArbolId();
                List<QueryDireccionesDto> direccionesyContactosQuery = direccionesyContactosRepository.obtenerDireccionesyContactosQuery(ArbolId);
                resultadosIntermedios.addAll(direccionesyContactosQuery);
            }
            consultaResultado.setResultadosIntermedios(resultadosIntermedios);

            // Paso 3: Utiliza el resultado de la segunda consulta como parámetro para la tercera consulta
            List<QueryContactosDto> resultadosFinales = new ArrayList<>();

            for (QueryDireccionesDto row : resultadosIntermedios) {
                Integer DireccionId = row.getDireccionId();
                List<QueryContactosDto> contactos = direccionesyContactosRepository.obtenerContactosIdQuery(DireccionId);
                    resultadosFinales.addAll(contactos);

            }
            consultaResultado.setResultadosFinales(resultadosFinales);

            // Devuelve los resultados combinados
            return new ResponseEntity<>(consultaResultado, HttpStatus.OK);
        } catch (Exception e) {
            // Manejo de excepciones
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

