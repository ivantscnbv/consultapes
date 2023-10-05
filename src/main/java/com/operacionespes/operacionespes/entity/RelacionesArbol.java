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
@Table(name = "RelacionesArbol")
public class RelacionesArbol {

    @Id
    @Column(name = "ArbolId")
    private Integer ArbolId;

    @Column(name = "PersonaMoralId")
    private Integer PersonaMoralId;

    @Column(name = "SubSectorId")
    private Integer SubSectorId;

    @Column(name = "Filial")
    private Boolean Filial;

    @Column(name = "AreaId", length = 8)
    private String AreaId;

    @Column(name = "PadrePersonaMoralId")
    private Integer PadrePersonaMoralId;

    @Column(name = "GrupoFinanciero")
    private Integer GrupoFinanciero;

    @Column(name = "SituacionId")
    private Integer SituacionId;

    @Column(name = "EstadoId")
    private Integer EstadoId;
}
