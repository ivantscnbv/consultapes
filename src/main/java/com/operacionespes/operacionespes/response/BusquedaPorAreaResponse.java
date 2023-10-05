package com.operacionespes.operacionespes.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BusquedaPorAreaResponse {

    private List<Object[]> dataQueryDatosGenerales;
    private List<Object[]> dataQueryClavesDinamicas;
    private List<Object[]> dataQueryDirecciones;
    private List<Object[]> dataQueryContactos;
    public void busquedaPorArea1(List<Object[]> dataQueryDatosGenerales){
        this.dataQueryDatosGenerales = dataQueryDatosGenerales;
    }
    public void busquedaPorArea2(List<Object[]> dataQueryClavesDinamicas){
        this.dataQueryClavesDinamicas = dataQueryClavesDinamicas;
    }
    public void busquedaPorArea3(List<Object[]> dataQueryDirecciones){
        this.dataQueryDirecciones = dataQueryDirecciones;
    }
    public void busquedaPorArea4(List<Object[]> dataQueryContactos){
        this.dataQueryContactos = dataQueryContactos;
    }
}
