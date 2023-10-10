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
    private Integer tipoDireccion;
    @JsonProperty("Calle")
    private String calle;
    @JsonProperty("CP")
    private String codigoPostal;
    @JsonProperty("Colonia")
    private String colonia;
    @JsonProperty ("DelOMup")
    private String deloMup;
    @JsonProperty("Estado")
    private String estado;
    @JsonProperty("Pais")
    private String pais;
    @JsonProperty("Telefono")
    private String telefono;
}
