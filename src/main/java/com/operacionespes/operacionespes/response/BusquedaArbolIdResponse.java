package com.operacionespes.operacionespes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusquedaArbolIdResponse {

    private List<QueryRelacionArbolDto> dataQueryRelacionArbol;
    public void busquedaArbolId(List<QueryRelacionArbolDto> dataQueryRelacionArbol){
        this.dataQueryRelacionArbol = dataQueryRelacionArbol;
    }
}
