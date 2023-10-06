package com.operacionespes.operacionespes.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryDatosGeneralesDto {

    @JsonProperty("ArbolId")
    private Integer ArbolId;
    @JsonProperty("PersonaMoralId")
    private Integer PersonaMoralId;
    @JsonProperty("SubSectorId")
    private Integer SubSectorId;
    @JsonProperty("RazonSocial")
    private String RazonSocial;
    @JsonProperty("PersonaMoralNomcorto")
    private String PersonaMoralNomcorto;
    @JsonProperty("PersonaMoralRFC")
    private String PersonaMoralRFC;
    @JsonProperty("PersonaMoralFechaConstitucion")
    private LocalDateTime PersonaMoralFechaConstitucion;
    @JsonProperty("Origen")
    private String Origen;
    @JsonProperty("AreaId")
    private String AreaId;
    @JsonProperty("Tenedoraid")
    private Integer Tenedoraid;
    @JsonProperty("GrupoFinanciero")
    private Integer GrupoFinanciero;
    @JsonProperty("SituacionId")
    private Integer SituacionId;
    @JsonProperty("EstatusId")
    private Integer EstatusId;
    @JsonProperty("GrupoEstatusId")
    private Integer GrupoEstatusId;
}
