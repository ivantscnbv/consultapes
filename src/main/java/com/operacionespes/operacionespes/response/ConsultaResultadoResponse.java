package com.operacionespes.operacionespes.response;

import java.util.ArrayList;
import java.util.List;

public class ConsultaResultadoResponse {
    private List<Object[]> resultadosIntermedios;
    private List<Object[]> resultadosFinales;

    public  ConsultaResultadoResponse() {
        this.resultadosIntermedios = new ArrayList<>();
        this.resultadosFinales = new ArrayList<>();
    }

    public List<Object[]> getResultadosIntermedios() {
        return resultadosIntermedios;
    }

    public void setResultadosIntermedios(List<Object[]> resultadosIntermedios) {
        this.resultadosIntermedios = resultadosIntermedios;
    }

    public List<Object[]> getResultadosFinales() {
        return resultadosFinales;
    }

    public void setResultadosFinales(List<Object[]> resultadosFinales) {
        this.resultadosFinales = resultadosFinales;
    }
}




