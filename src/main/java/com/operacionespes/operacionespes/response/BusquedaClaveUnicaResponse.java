package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.*;
import lombok.Getter;

import java.util.List;

@Getter
public class BusquedaClaveUnicaResponse {

    private List<QueryDatosGeneralesDto> dataQueryDatosGenerales;
    private List<QueryClavesDinamicasDto> dataQueryClavesDinamicas;
    private List<QueryDireccionesDto> dataQueryDirecciones;
    private List<QueryContactosDto> dataQueryContactos;
    public void busquedaClaveUnica1(List<QueryDatosGeneralesDto> dataQueryDatosGenerales){
        this.dataQueryDatosGenerales = dataQueryDatosGenerales;
    }
    public void busquedaClaveUnica2(List<QueryClavesDinamicasDto> dataQueryClavesDinamicas){
        this.dataQueryClavesDinamicas = dataQueryClavesDinamicas;
    }
    public void busquedaClaveUnica3(List<QueryDireccionesDto> dataQueryDirecciones){
        this.dataQueryDirecciones = dataQueryDirecciones;
    }
    public void busquedaClaveUnica4(List<QueryContactosDto> dataQueryContactos){
        this.dataQueryContactos = dataQueryContactos;
    }
}
