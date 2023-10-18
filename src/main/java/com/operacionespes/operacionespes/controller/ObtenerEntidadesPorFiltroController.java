package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.response.ObtenerEntidadesPorFiltroResponse;
import com.operacionespes.operacionespes.service.ObtenerEntidadesPorFiltroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/operacionespes")
@Slf4j
public class ObtenerEntidadesPorFiltroController {

    @Autowired
    private ObtenerEntidadesPorFiltroService obtenerEntidadesPorFiltroService;

    @GetMapping("/obtenerentidadesporfiltro")
    public ObtenerEntidadesPorFiltroResponse queryBuilder(@RequestParam(required = false) String SubSectorNombreLargo,
                                                          @RequestParam(required = false) Integer SubSectorId,
                                                          @RequestParam(required = false) Integer PersonaMoralId){
        log.info("Dentro del metodo queryBuilder de la clase ObtenerEntidadesPorFiltroController");
        return obtenerEntidadesPorFiltroService.queryBuilder(SubSectorNombreLargo, SubSectorId, PersonaMoralId);
    }
}
