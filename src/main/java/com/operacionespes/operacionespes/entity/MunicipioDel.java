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
@Table(name = "MunicipioDel")
public class MunicipioDel {

    @Id
    @Column(name = "MunicipioId")
    private Integer MunicipioId;

    @Column(name = "MunicipioNombreLargo", length = 160)
    private String MunicipioNombreLargo;

    @Id
    @Column(name = "EstadoMunicipioId")
    private Integer EstadoMunicipioId;
}
