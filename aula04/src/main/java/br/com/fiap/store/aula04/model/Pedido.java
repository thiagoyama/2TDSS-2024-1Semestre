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

    //mappedBy - nome do atributo que mapeia a FK
    //cascade - realiza as ações em cascata, ou seja, se cadastrar/atualizar/remover o pedido a nota tb pode sofrer a mesma ação
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private NotaFiscal notaFiscal;

}
