package com.operacionespes.operacionespes.entity;

import ch.qos.logback.core.boolex.EvaluationException;
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
@Table(name = "RelacionesClavesDinamicasArbol")
public class RelacionesClavesDinamicasArbol {

    @Id
    @Column(name = "ClaveDinamicaId")
    private Integer ClaveDinamicaId;

    @Column(name = "Valor_ClaveDinamica", length = 50)
    private String Valor_ClaveDinamica;

    @Column(name = "RelacionesArbol_ArbolId")
    private Integer RelacionesArbol_ArbolId;
}
