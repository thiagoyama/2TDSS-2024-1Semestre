package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="aula4_produto_pedido")
public class ProdutoPedido {

    @Id
    @GeneratedValue
    @Column(name="cd_produto_pedido")
    private Long codigo;

    @Column(name="vl_produto_pedido", nullable = false, scale = 2, precision = 9)
    private BigDecimal valor;

    @Column(name="qt_produto_pedido", nullable = false)
    private Long quantidade;

}
