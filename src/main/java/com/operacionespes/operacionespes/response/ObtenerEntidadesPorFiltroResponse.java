package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.ObtenerEntidadesPorFiltroDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ObtenerEntidadesPorFiltroResponse {

    private List<ObtenerEntidadesPorFiltroDto> dataQueryObtenerEntidadesPorFiltro;

    public void obtenerEntidadesPorFiltro1 (List<ObtenerEntidadesPorFiltroDto> dataQueryObtenerEntidadesPorFiltro){
        this.dataQueryObtenerEntidadesPorFiltro = dataQueryObtenerEntidadesPorFiltro;
    }
}
