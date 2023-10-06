package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.QueryClavesDinamicasDto;
import com.operacionespes.operacionespes.dto.QueryDatosGeneralesDto;
import com.operacionespes.operacionespes.repository.BusquedaClaveUnicaRepository;
import com.operacionespes.operacionespes.repository.BusquedaPorSubSectorRepository;
import com.operacionespes.operacionespes.response.BusquedaPorSubSectorResponse;
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
public class BusquedaPorSubSectorController {

    @Autowired
    BusquedaPorSubSectorRepository busquedaPorSubSectorRepository;
    @Autowired
    BusquedaClaveUnicaRepository busquedaClaveUnicaRepository;

    @GetMapping("/busquedaporsubsector")
    public List<BusquedaPorSubSectorResponse> query(@RequestParam("SubSectorId") Integer SubSectorId){
        log.info("Dentro del metodo query de la clase BusquedaPorSubSectorController.");
        List<QueryDatosGeneralesDto> mainQueryResult = busquedaPorSubSectorRepository.queryDatosGenerales(SubSectorId);
        if(mainQueryResult.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<BusquedaPorSubSectorResponse> responses = new ArrayList<>();
        for(QueryDatosGeneralesDto row : mainQueryResult){
            Integer ArbolId = row.getArbolId();

            BusquedaPorSubSectorResponse response = new BusquedaPorSubSectorResponse();
            response.busquedaPorSubSector1(Collections.singletonList(row));

            List<QueryClavesDinamicasDto> subQueryClaves = busquedaClaveUnicaRepository.queryClavesDinamicas(ArbolId);

            response.busquedaPorSubSector2(subQueryClaves);

            responses.add(response);
        }
        return responses;
    }
}
