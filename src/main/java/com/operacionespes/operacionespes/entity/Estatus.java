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
@Table(name = "Estatus")
public class Estatus {

    @Id
    @Column(name = "EstatusId")
    private Integer EstatusId;

    @Column(name = "GrupoEstatusId")
    private Integer GrupoEstatusId;

    @Column(name = "EstadoId")
    private Integer EstadoId;
}
