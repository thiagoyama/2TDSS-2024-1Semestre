package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="aula4_nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue
    @Column(name="cd_nota_fiscal")
    private Long codigo;

    @Column(name="vl_nota_fiscal", nullable = false, scale = 2, precision = 9)
    private BigDecimal valor;

    @Column(name="dt_nota_fiscal")
    private LocalDateTime data;

}
