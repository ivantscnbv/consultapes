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
public class QueryDireccionesDto {

    @JsonProperty("TipoDireccion")
    private Integer TipoDireccion;
    @JsonProperty("Calle")
    private String Calle;
    @JsonProperty("CP")
    private String CP;
    @JsonProperty("Colonia")
    private String Colonia;
    @JsonProperty("DelOMup")
    private String DelOMup;
    @JsonProperty("Estado")
    private String Estado;
    @JsonProperty("Pais")
    private String Pais;
    @JsonProperty("Telefono")
    private String Telefono;
}
