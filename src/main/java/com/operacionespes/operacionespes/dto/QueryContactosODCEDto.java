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
public class QueryContactosODCEDto {
    @JsonProperty("Titulo")
    private String titulo;
    @JsonProperty ("Nombre")
    private String nombre;
    @JsonProperty ("paterno")
    private String paterno;
    @JsonProperty("materno")
    private String materno;
    @JsonProperty("cargoId")
    private Integer cargoId;
    @JsonProperty("cargoDescripcion")
    private String cargoDescripcion;
}
