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
@Table(name = "Paises")
public class Paises {

    @Id
    @Column(name = "PaisId")
    private Short PaisId;

    @Column(name = "PaisNombre", length = 160)
    private String PaisNombre;
}
