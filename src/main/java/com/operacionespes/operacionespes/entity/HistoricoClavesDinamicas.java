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
@Table(name = "HistoricoClavesDinamicas")
public class HistoricoClavesDinamicas {

    @Id
    @Column(name = "HistoricoId")
    private Integer HistoricoId;

    @Column(name = "ArbolId")
    private Integer ArbolId;

    @Column(name = "EstadoId")
    private Integer EstadoId;

    @Column(name = "ClaveDinamicaId")
    private Integer ClaveDinamicaId;

    @Column(name = "ValorClaveDinamica", columnDefinition = "nchar(50)", length = 50)
    private String ValorClaveDinamica;
}
