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
@Table(name = "Colonia")
public class Colonia {

    @Id
    @Column(name = "ColoniaId")
    private Integer ColoniaId;

    @Id
    @Column(name = "MunicipioId")
    private Integer MunicipioId;

    @Id
    @Column(name = "EstadoMunicipioId")
    private Integer EstadoMunicipioId;

    @Column(name = "ColoniaNombreLargo", length = 160)
    private String ColoniaNombreLargo;
}
