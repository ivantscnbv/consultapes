package com.operacionespes.operacionespes.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BusquedaClavesDiferentesHistoricoResponse extends BusquedaClavesDiferentesBaseResponse{

    private List<Object[]> dataQueryHistorico;
}