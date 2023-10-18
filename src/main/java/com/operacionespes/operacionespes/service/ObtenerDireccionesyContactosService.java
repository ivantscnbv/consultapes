package com.operacionespes.operacionespes.service;

import com.operacionespes.operacionespes.dto.QueryContactosODCEDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto;
import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;
import com.operacionespes.operacionespes.repository.ObtenerDireccionesyContactosRepository;
import com.operacionespes.operacionespes.response.ObtenerDireccionesyContactosResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ObtenerDireccionesyContactosService {

    @Autowired
    ObtenerDireccionesyContactosRepository obtenerDireccionesyContactosRepository;

    public List<ObtenerDireccionesyContactosResponse> queryODCE(Integer PersonaMoralId,
                                                                Integer SubSectorId){
        List<QueryRelacionArbolDto> arbolIdquery = obtenerDireccionesyContactosRepository.queryRelacionArbol(PersonaMoralId, SubSectorId);
        if(arbolIdquery.isEmpty()){
            //PTS QUERY VA AQUI
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<ObtenerDireccionesyContactosResponse> responses = new ArrayList<>();
        for(QueryRelacionArbolDto row : arbolIdquery){
            Integer ArbolId = row.getArbolId();
            ObtenerDireccionesyContactosResponse response = new ObtenerDireccionesyContactosResponse();
            response.busquedaArbolId(Collections.singletonList(row));
            List<QueryDireccionesODCEDto> direcciones = obtenerDireccionesyContactosRepository.queryDireccionesODCE(ArbolId);
            if(direcciones.isEmpty()){
                responses.add(response);
            }
            for(QueryDireccionesODCEDto row2 : direcciones){
                Integer DireccionId = row2.getDireccionId();
                response.obtenerDireccionesODCE(Collections.singletonList(row2));
                List<QueryContactosODCEDto> contactos = obtenerDireccionesyContactosRepository.queryContactosODCE(DireccionId);
                response.obtenerContactosODCE(contactos);
                responses.add(response);
            }
        }
        return responses;
    }
}
