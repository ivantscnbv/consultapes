package com.operacionespes.operacionespes.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ObtenerEntidadesPorFiltroResponse {

    private List<Object[]> dataQueryObtenerEntidadesPorFiltro;

    public void obtenerEntidadesPorFiltro1 (List<Object[]> dataQueryObtenerEntidadesPorFiltro){
        this.dataQueryObtenerEntidadesPorFiltro = dataQueryObtenerEntidadesPorFiltro;
    }
}
