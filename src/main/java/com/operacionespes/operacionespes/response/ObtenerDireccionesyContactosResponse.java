package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.QueryContactosODCEDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesODCEDto;
import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ObtenerDireccionesyContactosResponse {

    private List<QueryRelacionArbolDto> dataQueryRelacionArbol;
    private List<QueryDireccionesODCEDto> dataQueryDireccionesODCE;
    private List<QueryContactosODCEDto> dataQueryContactosODCE;

    public void obtenerDireccionesODCE(List<QueryDireccionesODCEDto> dataQueryDireccionesODCE){
        this.dataQueryDireccionesODCE = dataQueryDireccionesODCE;
    }

    public void obtenerContactosODCE(List<QueryContactosODCEDto> dataQueryContactosODCE){
        this.dataQueryContactosODCE = dataQueryContactosODCE;
    }

    public void busquedaArbolId(List<QueryRelacionArbolDto> dataQueryRelacionArbol){
        this.dataQueryRelacionArbol = dataQueryRelacionArbol;
    }
}
