package com.operacionespes.operacionespes.service;

import com.operacionespes.operacionespes.dto.ObtenerEntidadesPorFiltroDto;
import com.operacionespes.operacionespes.repository.ObtenerEntidadesPorFiltroRepository;
import com.operacionespes.operacionespes.response.ObtenerEntidadesPorFiltroResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class ObtenerEntidadesPorFiltroService {

    @Autowired
    ObtenerEntidadesPorFiltroRepository obtenerEntidadesPorFiltroRepository;

    public ObtenerEntidadesPorFiltroResponse queryBuilder(String SubSectorNombreLargo,
                                                          Integer SubSectorId,
                                                          Integer PersonaMoralId){
        log.info("Dentro del metodo queryBuilder de la clase ObtenerEntidadesPorFiltroService.");
        ObtenerEntidadesPorFiltroResponse response = new ObtenerEntidadesPorFiltroResponse();
        List<ObtenerEntidadesPorFiltroDto> result = obtenerEntidadesPorFiltroRepository.queryObtenerEntidadesFiltro(SubSectorNombreLargo,
                SubSectorId, PersonaMoralId);
        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        response.obtenerEntidadesPorFiltro1(result);
        return response;
    }
}
