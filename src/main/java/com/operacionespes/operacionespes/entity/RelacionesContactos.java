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
@Table(name = "RelacionesContactos")
public class RelacionesContactos {

    @Id
    @Column(name = "ContactoId")
    private Integer ContactoId;

    @Column(name = "ContactoTitulo", columnDefinition = "nchar(66)", length = 66)
    private String ContactoTitulo;

    @Column(name = "ContactoNombre", columnDefinition = "nchar(100)", length = 100)
    private String ContactoNombre;

    @Column(name = "ContactoPaterno", columnDefinition = "nchar(100)", length = 100)
    private String ContactoPaterno;

    @Column(name = "ContactoMaterno", columnDefinition = "nchar(100)", length = 100)
    private String ContactoMaterno;

    @Column(name = "CargoId")
    private Integer CargoId;

    @Column(name = "ArbolId")
    private Integer ArbolId;

    @Column (name = "EstadoId")
    private Integer EstadoId;
}
