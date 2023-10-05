package com.operacionespes.operacionespes.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BusquedaArbolIdResponse {

    private List<Object[]> dataQueryRelacionArbol;
    public void busquedaArbolId(List<Object[]> dataQueryRelacionArbol){
        this.dataQueryRelacionArbol = dataQueryRelacionArbol;
    }
}
