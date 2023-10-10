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

    @JsonProperty("ContactoTitulo")
    private String contactoTitulo;
    @JsonProperty ("ContactoNombre")
    private String contactoNombre;
    @JsonProperty ("ContactoPaterno")
    private String contactoPaterno;
    @JsonProperty("ContactoMaterno")
    private String contactoMaterno;
    @JsonProperty("CargoId")
    private Integer cargoId;
    @JsonProperty("CargoNombre")
    private String cargoNombre;


}
