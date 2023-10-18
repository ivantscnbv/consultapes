package com.operacionespes.operacionespes.service;

import com.operacionespes.operacionespes.dto.QueryClavesDinamicasDto;
import com.operacionespes.operacionespes.dto.QueryContactosDto;
import com.operacionespes.operacionespes.dto.QueryDatosGeneralesDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesDto;
import com.operacionespes.operacionespes.repository.BusquedaClaveUnicaRepository;
import com.operacionespes.operacionespes.response.BusquedaClaveUnicaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class BusquedaClaveUnicaService {

    @Autowired
    private BusquedaClaveUnicaRepository busquedaClaveUnicaRepository;

    public BusquedaClaveUnicaResponse queryDatosGenerales(Integer ArbolId){
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaClaveUnicaService.");
        List<QueryDatosGeneralesDto> result = busquedaClaveUnicaRepository.queryDatosGenerales(ArbolId);
        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<QueryClavesDinamicasDto> result2 = busquedaClaveUnicaRepository.queryClavesDinamicas(ArbolId);
        List<QueryDireccionesDto> result3 = busquedaClaveUnicaRepository.queryDirecciones(ArbolId);
        List<QueryContactosDto> result4 = busquedaClaveUnicaRepository.queryContactos(ArbolId);
        BusquedaClaveUnicaResponse response = new BusquedaClaveUnicaResponse();
        response.busquedaClaveUnica1(result);
        response.busquedaClaveUnica2(result2);
        response.busquedaClaveUnica3(result3);
        response.busquedaClaveUnica4(result4);
        return response;
    }
}
