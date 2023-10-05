package com.operacionespes.operacionespes.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BusquedaPorSubSectorResponse {

    private List<Object[]> dataQueryDatosGenerales;
    private List<Object[]> dataQueryClavesDinamicas;

    public void busquedaPorSubSector1(List<Object[]> dataQueryDatosGenerales){
        this.dataQueryDatosGenerales = dataQueryDatosGenerales;
    }
    public void busquedaPorSubSector2(List<Object[]> dataQueryClavesDinamicas){
        this.dataQueryClavesDinamicas = dataQueryClavesDinamicas;
    }
}
