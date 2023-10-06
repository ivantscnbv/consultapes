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
public class ObtenerEntidadesPorFiltroDto {

    @JsonProperty("ArbolId")
    private Integer ArbolId;
    @JsonProperty("PersonaMoralId")
    private Integer PersonaMoralId;
    @JsonProperty("RazonSocial")
    private String RazonSocial;
    @JsonProperty("NombreCorto")
    private String NombreCorto;
    @JsonProperty("SubSectorId")
    private Integer SubSectorId;
    @JsonProperty("SubsectorNombreLargo")
    private String SubsectorNombreLargo;
    @JsonProperty("AreaId")
    private String AreaId;
    @JsonProperty("AreaNombre")
    private String AreaNombre;
}
