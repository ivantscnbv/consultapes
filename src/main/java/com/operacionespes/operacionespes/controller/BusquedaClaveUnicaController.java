package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.response.BusquedaClaveUnicaResponse;
import com.operacionespes.operacionespes.service.BusquedaClaveUnicaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class BusquedaClaveUnicaController {

    @Autowired
    private BusquedaClaveUnicaService busquedaClaveUnicaService;

    @GetMapping("/busquedaclaveunica")
    public BusquedaClaveUnicaResponse queryDatosGenerales(@RequestParam Integer ArbolId){
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaClaveUnicaController");
        return busquedaClaveUnicaService.queryDatosGenerales(ArbolId);
    }
}
