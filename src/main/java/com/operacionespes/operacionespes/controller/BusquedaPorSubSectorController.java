package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.response.BusquedaPorSubSectorResponse;
import com.operacionespes.operacionespes.service.BusquedaPorSubSectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class BusquedaPorSubSectorController {

    @Autowired
    BusquedaPorSubSectorService busquedaPorSubSectorService;

    @GetMapping("/busquedaporsubsector")
    public List<BusquedaPorSubSectorResponse> query(@RequestParam("SubSectorId") Integer SubSectorId){
        log.info("Dentro del metodo query de la clase BusquedaPorSubSectorController.");
        return busquedaPorSubSectorService.query(SubSectorId);
    }
}


