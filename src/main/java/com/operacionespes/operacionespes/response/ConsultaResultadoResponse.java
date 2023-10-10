package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.QueryContactosDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesDto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaResultadoResponse {

    private List<QueryDireccionesDto> resultadosIntermedios;
    private List<QueryContactosDto> resultadosFinales;

    public ConsultaResultadoResponse() {
        this.resultadosIntermedios = new ArrayList<>();
        this.resultadosFinales = new ArrayList<>();
    }

    public List<QueryDireccionesDto> getResultadosIntermedios() {
        return resultadosIntermedios;
    }

    public void setResultadosIntermedios(List<QueryDireccionesDto> resultadosIntermedios) {
        this.resultadosIntermedios = resultadosIntermedios;
    }

    public List<QueryContactosDto> getResultadosFinales() {
        return resultadosFinales;
    }

    public void setResultadosFinales(List<QueryContactosDto> resultadosFinales) {
        this.resultadosFinales = resultadosFinales;
    }
}