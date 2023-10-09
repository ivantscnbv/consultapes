package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.QueryContactosDto;
import com.operacionespes.operacionespes.dto.QueryDireccionesDto;
import com.operacionespes.operacionespes.dto.QueryRelacionArbolDto;

import java.util.ArrayList;
import java.util.List;

public class ConsultaResultadoResponse {

    private List<QueryRelacionArbolDto> resultadosIniciales;
    private List<QueryDireccionesDto> resultadosIntermedios;
    private List<QueryContactosDto> resultadosFinales;

    public  ConsultaResultadoResponse() {

        this.resultadosIntermedios = new ArrayList<>();
        this.resultadosFinales = new ArrayList<>();
        this.resultadosIniciales = new ArrayList<>();
    }

    public List<QueryRelacionArbolDto> getResultadosIniciales(){ return resultadosIniciales;}


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

    public void setResultadosIniciales(List<QueryRelacionArbolDto> resultadosIniciales) {
        this.resultadosIniciales = resultadosIniciales;
    }
}




