package com.operacionespes.operacionespes.service;

import com.operacionespes.operacionespes.dto.QueryClavesDinamicasDto;
import com.operacionespes.operacionespes.dto.QueryContactosDto;
import com.operacionespes.operacionespes.dto.QueryDatosGeneralesDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesDto;
import com.operacionespes.operacionespes.repository.BusquedaClaveUnicaRepository;
import com.operacionespes.operacionespes.repository.BusquedaPorAreaRepository;
import com.operacionespes.operacionespes.response.BusquedaPorAreaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class BusquedaPorAreaService {

    @Autowired
    private BusquedaPorAreaRepository busquedaPorAreaRepository;
    @Autowired
    private BusquedaClaveUnicaRepository busquedaClaveUnicaRepository;

    public List<BusquedaPorAreaResponse> query(String AreaId) {
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaPorAreaService.");
        List<QueryDatosGeneralesDto> mainQueryResult = busquedaPorAreaRepository.queryDatosGenerales(AreaId);
        if (mainQueryResult.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<BusquedaPorAreaResponse> responses = new ArrayList<>();
        for(QueryDatosGeneralesDto row : mainQueryResult){
            Integer ArbolId = row.getArbolId();
            BusquedaPorAreaResponse response = new BusquedaPorAreaResponse();
            response.busquedaPorArea1(Collections.singletonList(row));

            List<QueryClavesDinamicasDto> subQueryClaves = busquedaClaveUnicaRepository.queryClavesDinamicas(ArbolId);
            List<QueryDireccionesDto> subQueryDirecciones = busquedaClaveUnicaRepository.queryDirecciones(ArbolId);
            List<QueryContactosDto> subQueryContactos = busquedaClaveUnicaRepository.queryContactos(ArbolId);

            response.busquedaPorArea2(subQueryClaves);
            response.busquedaPorArea3(subQueryDirecciones);
            response.busquedaPorArea4(subQueryContactos);

            responses.add(response);
        }
        return responses;
    }
}
