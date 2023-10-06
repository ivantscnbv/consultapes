package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.repository.BusquedaClaveUnicaRepository;
import com.operacionespes.operacionespes.repository.BusquedaPorAreaRepository;
import com.operacionespes.operacionespes.response.BusquedaPorAreaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class BusquedaPorAreaController {

    @Autowired
    private BusquedaPorAreaRepository busquedaPorAreaRepository;
    @Autowired
    private BusquedaClaveUnicaRepository busquedaClaveUnicaRepository;

    @GetMapping("/busquedaporarea")
    public List<BusquedaPorAreaResponse> query(@RequestParam("AreaId") String AreaId) {
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaPorAreaController.");
        List<Object[]> mainQueryResult = busquedaPorAreaRepository.queryDatosGenerales(AreaId);
        if (mainQueryResult.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<BusquedaPorAreaResponse> responses = new ArrayList<>();
        for(Object[] row : mainQueryResult){
            Integer ArbolId = (Integer) row[0];

            BusquedaPorAreaResponse response = new BusquedaPorAreaResponse();
            response.busquedaPorArea1(Collections.singletonList(row));

            List<Object[]> subQueryClaves = busquedaClaveUnicaRepository.queryClavesDinamicas(ArbolId);
            List<Object[]> subQueryDirecciones = busquedaClaveUnicaRepository.queryDirecciones(ArbolId);
            List<Object[]> subQueryContactos = busquedaClaveUnicaRepository.queryContactos(ArbolId);

            response.busquedaPorArea2(subQueryClaves);
            response.busquedaPorArea3(subQueryDirecciones);
            response.busquedaPorArea4(subQueryContactos);

            responses.add(response);
        }
        return responses;
    }
}
