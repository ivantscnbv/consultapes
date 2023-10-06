package com.operacionespes.operacionespes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuerySubSectoresActivosDto {

    @JsonProperty("SubSectorId")
    private Integer subSectorId;

    @JsonProperty("SubSectorNombreLargo")
    private String SubSectorNombreLargo;
}
