package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.dto.*;
import com.operacionespes.operacionespes.repository.BusquedaClaveUnicaRepository;
import com.operacionespes.operacionespes.response.BusquedaClaveUnicaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class BusquedaClaveUnicaController {

    @Autowired
    private BusquedaClaveUnicaRepository busquedaClaveUnicaRepository;

    @GetMapping("/busquedaclaveunica")
    public BusquedaClaveUnicaResponse queryDatosGenerales(@RequestParam Integer ArbolId){
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaClaveUnicaController");
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
