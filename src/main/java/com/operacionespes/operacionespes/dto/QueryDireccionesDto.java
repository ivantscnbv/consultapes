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

    @JsonProperty("DireccionId")
    private Integer DireccionId;

    @JsonProperty("TipoDireccionId")
    private Integer tipoDireccion;

    @JsonProperty("TipoDireccionDescripcion")
    private Integer tipoDireccionDescripcion;

    @JsonProperty("calleNumero")
    private String calleNumero;

    @JsonProperty("Ciudad")
    private Integer ciudad;

    @JsonProperty("codigoPostal")
    private Integer codigoPostal;

    @JsonProperty("Colonia")
    private String colonia;

    @JsonProperty("ColoniaId")
    private String coloniaId;

    @JsonProperty ("DeloMup")
    private String deloMup;

    @JsonProperty ("DelegacionMunicipioId")
    private String delegacionMunicipioId;

    @JsonProperty("Estado")
    private String estado;

    @JsonProperty("EstadoPaisId")
    private String estadoPaisId;

    @JsonProperty("Pais")
    private String pais;

    @JsonProperty("PaisId")
    private String paisId;

    @JsonProperty("Telefono")
    private Integer telefono;

    @JsonProperty("Faxes")
    private String faxes;

    @JsonProperty("Activos")
    private Integer activos;
}
