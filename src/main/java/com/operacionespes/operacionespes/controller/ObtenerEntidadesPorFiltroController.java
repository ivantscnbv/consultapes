package com.operacionespes.operacionespes.controller;

import com.operacionespes.operacionespes.repository.ObtenerEntidadesPorFiltroRepository;
import com.operacionespes.operacionespes.response.ObtenerEntidadesPorFiltroResponse;
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
public class ObtenerEntidadesPorFiltroController {

    @Autowired
    private ObtenerEntidadesPorFiltroRepository obtenerEntidadesPorFiltroRepository;

    @GetMapping("/obtenerentidadfiltro")
    public ObtenerEntidadesPorFiltroResponse queryBuilder(@RequestParam(required = false) String SubSectorNombreLargo,
                                                          @RequestParam(required = false) Integer SubSectorId,
                                                          @RequestParam(required = false) Integer PersonaMoralId){
        log.info("Dentro del metodo queryBuilder de la clase ObtenerEntidadesPorFiltroController");
        ObtenerEntidadesPorFiltroResponse response = new ObtenerEntidadesPorFiltroResponse();
        List<Object[]> result = obtenerEntidadesPorFiltroRepository.queryObtenerEntidadesFiltro(SubSectorNombreLargo,
                SubSectorId, PersonaMoralId);
        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        response.obtenerEntidadesPorFiltro1(result);
        return response;
    }
}
