package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.QueryClavesDinamicasDto;
import com.operacionespes.operacionespes.dto.QueryDatosGeneralesDto;
import lombok.Getter;

import java.util.List;

@Getter
public class BusquedaPorSubSectorResponse {

    private List<QueryDatosGeneralesDto> dataQueryDatosGenerales;
    private List<QueryClavesDinamicasDto> dataQueryClavesDinamicas;

    public void busquedaPorSubSector1(List<QueryDatosGeneralesDto> dataQueryDatosGenerales){
        this.dataQueryDatosGenerales = dataQueryDatosGenerales;
    }
    public void busquedaPorSubSector2(List<QueryClavesDinamicasDto> dataQueryClavesDinamicas){
        this.dataQueryClavesDinamicas = dataQueryClavesDinamicas;
    }
}
