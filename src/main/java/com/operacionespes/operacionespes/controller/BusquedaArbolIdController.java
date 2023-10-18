package com.operacionespes.operacionespes.controller;



import com.operacionespes.operacionespes.response.BusquedaArbolIdResponse;
import com.operacionespes.operacionespes.service.BusquedaArbolIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class BusquedaArbolIdController {

    @Autowired
    private BusquedaArbolIdService busquedaArbolIdService;

    @GetMapping("/busquedaarbolid")
    public BusquedaArbolIdResponse queryRelacionArbol(@RequestParam Integer PersonaMoralId,
                                                       @RequestParam Integer SubSectorId){
        log.info("Dentro del metodo queryRelacionArbol de la clase BusquedaArbolIdController");
        return busquedaArbolIdService.queryRelacionArbol(PersonaMoralId, SubSectorId);
    }
}
