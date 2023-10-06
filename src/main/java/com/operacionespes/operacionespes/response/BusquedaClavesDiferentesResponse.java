package com.operacionespes.operacionespes.response;

import com.operacionespes.operacionespes.dto.QueryClavesDiferentesDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class BusquedaClavesDiferentesResponse extends BusquedaClavesDiferentesBaseResponse{

    private List<QueryClavesDiferentesDto> dataQueryClavesDiferentes;
}
