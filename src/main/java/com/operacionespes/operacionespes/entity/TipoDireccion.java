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
@Table(name = "TipoDireccion")
public class TipoDireccion {

    @Id
    @Column (name = "TipoDireccionId")
    private Integer TipoDireccionId;

    @Column (name = "TipoDireccionNombre" , columnDefinition = "nchar(50)")
    private String TipoDireccionNombre;
}
