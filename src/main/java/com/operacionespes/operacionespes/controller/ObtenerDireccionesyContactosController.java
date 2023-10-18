package com.operacionespes.operacionespes.controller;


import com.operacionespes.operacionespes.response.ObtenerDireccionesyContactosResponse;
import com.operacionespes.operacionespes.service.ObtenerDireccionesyContactosService;
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
public class ObtenerDireccionesyContactosController {

    @Autowired
    ObtenerDireccionesyContactosService obtenerDireccionesyContactosService;

    @GetMapping("/obtenerdireccionesycontactos")
    public List<ObtenerDireccionesyContactosResponse> queryODCE(@RequestParam Integer PersonaMoralId,
                                                          @RequestParam Integer SubSectorId){
        log.info("Dentro del metodo queryODCE de la clase ObtenerDireccionesyContactosController.");
        return obtenerDireccionesyContactosService.queryODCE(PersonaMoralId, SubSectorId);
    }
}
