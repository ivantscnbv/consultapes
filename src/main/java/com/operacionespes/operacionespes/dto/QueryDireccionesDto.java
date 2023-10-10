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
    private Integer TipoDireccion;
    @JsonProperty("TipoDireccionNombre")
    private String tipoDireccionNombre;
    @JsonProperty("DirecccionCalle")
    private String direcccionCalle;
    @JsonProperty("DireccionCiudad")
    private String direccionCiudad;
    @JsonProperty("CodigoPostal")
    private Integer codigoPostal;
    @JsonProperty("ColoniaNombreLargo")
    private String coloniaNombreLargo;
    @JsonProperty("ColoniaId")
    private Integer coloniaId;
    @JsonProperty ("MunicipioNombreLargo")
    private String municipioNombreLargo;
    @JsonProperty ("delegacionMunicipioId")
    private Integer delegacionMunicipioId;
    @JsonProperty("EstadoPaisNombre")
    private String estadoPaisNombre;
    @JsonProperty("EstadoPaisId")
    private Integer estadoPaisId;
    @JsonProperty("PaisNombre")
    private String paisNombre;
    @JsonProperty("PaisId")
    private String paisId;
    @JsonProperty("DireccionTelefono")
    private Integer direccionTelefono;
    @JsonProperty("DireccionFax")
    private String direccionFax;
    @JsonProperty("EstadoId")
    private Integer estadoId;
}
