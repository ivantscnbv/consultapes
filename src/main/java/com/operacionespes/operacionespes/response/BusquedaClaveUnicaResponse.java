package com.operacionespes.operacionespes.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BusquedaClaveUnicaResponse {

    private List<Object[]> dataQueryDatosGenerales;
    private List<Object[]> dataQueryClavesDinamicas;
    private List<Object[]> dataQueryDirecciones;
    private List<Object[]> dataQueryContactos;
    public void busquedaClaveUnica1(List<Object[]> dataQueryDatosGenerales){
        this.dataQueryDatosGenerales = dataQueryDatosGenerales;
    }
    public void busquedaClaveUnica2(List<Object[]> dataQueryClavesDinamicas){
        this.dataQueryClavesDinamicas = dataQueryClavesDinamicas;
    }
    public void busquedaClaveUnica3(List<Object[]> dataQueryDirecciones){
        this.dataQueryDirecciones = dataQueryDirecciones;
    }
    public void busquedaClaveUnica4(List<Object[]> dataQueryContactos){
        this.dataQueryContactos = dataQueryContactos;
    }
}
