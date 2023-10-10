package com.operacionespes.operacionespes.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuerySubSectoresActivosDto {

    @JsonProperty("SubSectorId")
    private Integer subSectorId;
    @JsonProperty("SubSectorNombreLargo")
    private String SubSectorNombreLargo;
}
