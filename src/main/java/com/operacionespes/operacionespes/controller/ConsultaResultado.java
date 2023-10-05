package com.operacionespes.operacionespes.controller;

import java.util.ArrayList;
import java.util.List;

public class ConsultaResultado {
    private List<Object[]> resultadosIntermedios;
    private List<Object[]> resultadosFinales;

    public ConsultaResultado() {
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