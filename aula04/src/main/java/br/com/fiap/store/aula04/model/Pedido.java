package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="aula4_pedido")
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name="cd_pedido")
    private Long codigo;

    @Column(name="vl_pedido", scale = 2, precision = 9)
    private BigDecimal valor;

    @Column(name="dt_pedido")
    private LocalDateTime data;

}
