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
public class QueryContactosDto {

    @JsonProperty("Titulo")
    private String titulo;

    @JsonProperty ("Nombre")
    private String nombre;

    @JsonProperty ("Paterno")
    private String paterno;

    @JsonProperty("Materno")
    private String materno;

    @JsonProperty("CargoId")
    private Integer cargoId;

    @JsonProperty("CargoDescripcion")
    private String cargoDescripcion;
}
