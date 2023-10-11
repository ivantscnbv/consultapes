package com.operacionespes.operacionespes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RelacionesDirecciones")
public class RelacionesDirecciones {

    @Id
    @Column(name = "DireccionId")
    private Integer DireccionId;

    @Column(name = "TipoDireccionId")
    private Integer TipoDireccionId;

    @Column(name = "DireccionCalle", columnDefinition = "nchar(250)", length = 250)
    private String DireccionCalle;

    @Column(name = "DireccionCP", length = 25)
    private String DireccionCP;

    @Column(name = "DireccionTelefono", length = 200)
    private String DireccionTelefono;

    @Column(name = "DireccionColonia")
    private Integer DireccionColonia;

    @Column(name = "DireccionDelegacion")
    private Integer DireccionDelegacion;

    @Column(name = "EstadoPaisId")
    private Integer EstadoPaisId;

    @Column(name = "PaisId")
    private Short PaisId;

    @Column(name = "RelacionesArbol_ArbolId")
    private Integer RelacionesArbol_ArbolId;

    @Column(name = "EstadoId")
    private Integer EstadoId;

    @Column(name = "DireccionCiudad", columnDefinition = "nchar(100)", length = 100)
    private String DireccionCiudad;

    @Column(name = "DireccionFax", columnDefinition = "nchar(200)")
    private String DireccionFax;
}
