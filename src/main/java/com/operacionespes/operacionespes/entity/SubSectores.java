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
@Table(name = "SubSectores")
public class SubSectores {

    @Id
    @Column(name = "SubSectorId")
    private Integer SubSectorId;

    @Column(name = "EstadoId")
    private Integer EstadoId;

    @Column(name = "SubSectorNombreLargo", columnDefinition = "nchar(200)" )
    private String SubSectorNombreLargo;
}
