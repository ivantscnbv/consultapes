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
    private String Titulo;
    @JsonProperty ("Nombre")
    private String Nombre;
    @JsonProperty ("ApellidoPaterno")
    private String ApellidoPaterno;
    @JsonProperty("ApellidoMaterno")
    private String ApellidoMaterno;
    @JsonProperty("Cargo")
    private Integer Cargo;
}
