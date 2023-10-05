package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.repository.DireccionesyContactosRepository;
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
    public ResponseEntity<ConsultaResultado> obtenerDireccionesyContactosQuery(
            @RequestParam("PersonaMoralId") Integer PersonaMoralId,
            @RequestParam("SubSectorId") Integer SubSectorId
    ) {
        ConsultaResultado consultaResultado = new ConsultaResultado();

        // Paso 1: Realiza la primera consulta
        List<Integer> arbolIds = direccionesyContactosRepository.obtenerArbolIds(PersonaMoralId, SubSectorId);

        // Paso 2: Utiliza el resultado de la primera consulta como parámetro para la segunda consulta
        List<Object[]> resultadosIntermedios = new ArrayList<>();
        for (Integer ArbolId : arbolIds) {
            List<Object[]> direccionesyContactos = direccionesyContactosRepository.obtenerDireccionesyContactosQuery(ArbolId);
            resultadosIntermedios.addAll(direccionesyContactos);
        }
        consultaResultado.setResultadosIntermedios(resultadosIntermedios);

        // Paso 3: Utiliza el resultado de la segunda consulta como parámetro para la tercera consulta
        List<Object[]> resultadosFinales = new ArrayList<>();
        for (Object[] direccionyContacto : resultadosIntermedios) {
            Integer DireccionId = (Integer) direccionyContacto[0];
            List<Object[]> direccionesId = direccionesyContactosRepository.obtenerDireccionesIdQuery(DireccionId);
            resultadosFinales.addAll(direccionesId);
        }
        consultaResultado.setResultadosFinales(resultadosFinales);

        // Devuelve los resultados combinados
        return new ResponseEntity<>(consultaResultado, HttpStatus.OK);
    }
}

