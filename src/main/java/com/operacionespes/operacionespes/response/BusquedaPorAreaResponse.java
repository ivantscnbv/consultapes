package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.QueryClavesDinamicasDto;
import com.operacionespes.operacionespes.dto.QueryContactosDto;
import com.operacionespes.operacionespes.dto.QueryDatosGeneralesDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesDto;
import lombok.Getter;

import java.util.List;

@Getter
public class BusquedaPorAreaResponse {

    private List<QueryDatosGeneralesDto> dataQueryDatosGenerales;
    private List<QueryClavesDinamicasDto> dataQueryClavesDinamicas;
    private List<QueryDireccionesDto> dataQueryDirecciones;
    private List<QueryContactosDto> dataQueryContactos;
    public void busquedaPorArea1(List<QueryDatosGeneralesDto> dataQueryDatosGenerales){
        this.dataQueryDatosGenerales = dataQueryDatosGenerales;
    }
    public void busquedaPorArea2(List<QueryClavesDinamicasDto> dataQueryClavesDinamicas){
        this.dataQueryClavesDinamicas = dataQueryClavesDinamicas;
    }
    public void busquedaPorArea3(List<QueryDireccionesDto> dataQueryDirecciones){
        this.dataQueryDirecciones = dataQueryDirecciones;
    }
    public void busquedaPorArea4(List<QueryContactosDto> dataQueryContactos){
        this.dataQueryContactos = dataQueryContactos;
    }
}
