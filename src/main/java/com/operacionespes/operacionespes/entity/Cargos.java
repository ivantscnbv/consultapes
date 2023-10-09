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
@Table(name = "Cargos")

public class Cargos {

    @Id
    @Column (name = "CargoId")
    private Integer CargoId;

    @Column (name = "CargoNombre" , columnDefinition = "nchar(100)")
    private String CargoNombre;

    @Column (name = "EstadoId")
    private Integer EstadoId;





}
