package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.QueryHistoricoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BusquedaClavesDiferentesHistoricoResponse extends BusquedaClavesDiferentesBaseResponse{

    private List<QueryHistoricoDto> dataQueryHistorico;
}
