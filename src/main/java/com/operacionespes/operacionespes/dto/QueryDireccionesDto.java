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

    @JsonProperty("tipoDireccionId")
    private Integer tipoDireccion;

    @JsonProperty("tipoDireccionDescripcion")
    private String tipoDireccionDescripcion;

    @JsonProperty("calleNumero")
    private String calleNumero;

    @JsonProperty("Ciudad")
    private String ciudad;

    @JsonProperty("codigoPostal")
    private Integer codigoPostal;

    @JsonProperty("Colonia")
    private String colonia;

    @JsonProperty("ColoniaId")
    private Integer coloniaId;

    @JsonProperty ("DeloMup")
    private String deloMup;

    @JsonProperty ("delegacionMunicipioId")
    private Integer delegacionMunicipioId;

    @JsonProperty("Estado")
    private String estado;

    @JsonProperty("EstadoPaisId")
    private String estadoPaisId;

    @JsonProperty("Pais")
    private String pais;

    @JsonProperty("PaisId")
    private Integer paisId;

    @JsonProperty("Telefono")
    private Integer telefono;

    @JsonProperty("Faxes")
    private Integer faxes;

    @JsonProperty("Activos")
    private Integer activos;
}
