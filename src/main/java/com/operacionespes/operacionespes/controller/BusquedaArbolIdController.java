package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.repository.BusquedaArbolIdRepository;
import com.operacionespes.operacionespes.response.BusquedaArbolIdResponse;
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
public class BusquedaArbolIdController {

    @Autowired
    private BusquedaArbolIdRepository busquedaArbolIdRepository;

    @GetMapping("/busquedaarbolid")
    public BusquedaArbolIdResponse queryRelacionArbol(@RequestParam Integer PersonaMoralId,
                                                      @RequestParam Integer SubSectorId){
        log.info("Dentro del metodo queryRelacionArbol de la clase BusquedaArbolIdController");
        List<Object[]> result = busquedaArbolIdRepository.queryRelacionArbol(PersonaMoralId, SubSectorId);
        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BusquedaArbolIdResponse response = new BusquedaArbolIdResponse();
        response.busquedaArbolId(result);
        return response;
    }
}
