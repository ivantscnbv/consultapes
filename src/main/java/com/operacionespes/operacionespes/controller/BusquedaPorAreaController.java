package com.operacionespes.operacionespes.controller;


import com.operacionespes.operacionespes.response.BusquedaPorAreaResponse;
import com.operacionespes.operacionespes.service.BusquedaPorAreaService;
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
public class BusquedaPorAreaController {

    @Autowired
    private BusquedaPorAreaService busquedaPorAreaService;

    @GetMapping("/busquedaporarea")
    public List<BusquedaPorAreaResponse> query(@RequestParam("AreaId") String AreaId) {
        log.info("Dentro del metodo queryDatosGenerales de la clase BusquedaPorAreaController.");
        return busquedaPorAreaService.query(AreaId);
    }
}
