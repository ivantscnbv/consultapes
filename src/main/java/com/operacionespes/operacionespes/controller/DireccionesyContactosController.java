package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.*;
import com.operacionespes.operacionespes.repository.DireccionesyContactosRepository;
import com.operacionespes.operacionespes.response.ConsultaResultadoResponse;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
            log.info("inside try 1");
            // Paso 1: Realiza la primera consulta
            List<QueryRelacionArbolDto> resultadosIniciales = direccionesyContactosRepository.obtenerArbolIds(PersonaMoralId, SubSectorId);
            consultaResultado.setResultadosIniciales(resultadosIniciales);
            log.info("inside try 2");
            // Paso 2: Utiliza el resultado de la primera consulta como parámetro para la segunda consulta
            List<QueryDireccionesODCEDto> resultadosIntermedios = new ArrayList<>();
            log.info("inside try 3");
            for (QueryRelacionArbolDto row : resultadosIniciales) {
                Integer ArbolId = row.getArbolId();
                List<QueryDireccionesODCEDto> direccionesyContactosQuery = direccionesyContactosRepository.obtenerDireccionesyContactosQuery(ArbolId);
                resultadosIntermedios.addAll(direccionesyContactosQuery);
            }
            log.info("inside try 4");
            consultaResultado.setResultadosIntermedios(resultadosIntermedios);
            // Paso 3: Utiliza el resultado de la segunda consulta como parámetro para la tercera consulta
            List<QueryContactosODCEDto> resultadosFinales = new ArrayList<>();
            for (QueryDireccionesODCEDto row : resultadosIntermedios) {
                Integer DireccionId = row.getDireccionId();
                List<QueryContactosODCEDto> contactos = direccionesyContactosRepository.obtenerContactosIdQuery(DireccionId);
                    resultadosFinales.addAll(contactos);
            }
            consultaResultado.setResultadosFinales(resultadosFinales);
            // Devuelve los resultados combinados
            return new ResponseEntity<>(consultaResultado, HttpStatus.OK);
        } catch (Exception e) {
            // Manejo de excepciones
            log.info("Error al consultar direcciones y contactos", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

