package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoPedido> itens = new ArrayList<>();

    //Método para "setar" a FK na tabela ProdutoPedido
    public void addItens(ProdutoPedido item){
        //Setar a FK no item
        item.setPedido(this);
        //Adicionar o item na lista
        itens.add(item);
    }

}
