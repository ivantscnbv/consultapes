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
@Table(name = "EstadoPais")
public class EstadoPais {

    @Id
    @Column(name = "EstadoPaisId")
    private Integer EstadoPaisId;

    @Column(name = "EstadoPaisNombre", length = 160)
    private String EstadoPaisNombre;

    @Column(name = "PaisId")
    private Short PaisId;
}
