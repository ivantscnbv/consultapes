package com.operacionespes.operacionespes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonasMorales")
public class PersonasMorales {

    @Id
    @Column(name = "PersonaMoralId")
    private Integer PersonaMoralId;

    @Column(name = "PersonaMoralRazonSocial", columnDefinition = "nchar(500)", length = 500)
    private String PersonaMoralRazonSocial;

    @Column(name = "PersonaMoralNomcorto", length = 50)
    private String PersonaMoralNomcorto;

    @Column(name = "PersonaMoralRFC", columnDefinition = "nchar(13)", length = 13)
    private String PersonaMoralRFC;

    @Column(name = "PersonaMoralFechaConstitucion")
    private LocalDateTime PersonaMoralFechaConstitucion;

    @Column(name = "EstadoId")
    private Integer EstadoId;
}
