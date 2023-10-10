package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ConsultaResultadoResponse {

    private List<QueryRelacionArbolDto> resultadosIniciales;
    private List<QueryDireccionesODCEDto> resultadosIntermedios;
    private List<QueryContactosODCEDto> resultadosFinales;
    public void setResultadosIntermedios(List<QueryDireccionesODCEDto> resultadosIntermedios) {
        this.resultadosIntermedios = resultadosIntermedios;
    }

    public void setResultadosFinales(List<QueryContactosODCEDto> resultadosFinales) {
        this.resultadosFinales = resultadosFinales;
    }

    public void setResultadosIniciales(List<QueryRelacionArbolDto> resultadosIniciales) {
        this.resultadosIniciales = resultadosIniciales;
    }
}




