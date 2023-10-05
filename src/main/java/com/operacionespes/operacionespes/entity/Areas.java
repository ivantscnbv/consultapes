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
@Table(name = "Areas")
public class Areas {

    @Id
    @Column(name = "AreaId", length = 8)
    private String AreaId;

    @Column(name = "EstadoId")
    private Integer EstadoId;
}
