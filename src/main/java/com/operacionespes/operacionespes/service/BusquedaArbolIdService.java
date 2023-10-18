package com.operacionespes.operacionespes.service;

import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;
import com.operacionespes.operacionespes.repository.BusquedaArbolIdRepository;
import com.operacionespes.operacionespes.response.BusquedaArbolIdResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class BusquedaArbolIdService {

    @Autowired
    private BusquedaArbolIdRepository busquedaArbolIdRepository;

    public BusquedaArbolIdResponse queryRelacionArbol(Integer PersonaMoralId,
                                                      Integer SubSectorId){
        log.info("Dentro del metodo queryRelacionArbol de la clase BusquedaArbolIdService");
        List<QueryRelacionArbolDto> result = busquedaArbolIdRepository.queryRelacionArbol(PersonaMoralId, SubSectorId);
        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BusquedaArbolIdResponse response = new BusquedaArbolIdResponse();
        response.busquedaArbolId(result);
        return response;
    }
}
