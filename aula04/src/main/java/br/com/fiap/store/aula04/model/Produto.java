package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "aula4_produto")
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @GeneratedValue
    @Column(name="cd_produto")
    private Long codigo;

    @Column(name="nm_produto", nullable = false, length = 50)
    private String nome;

    @Column(name="vl_produto", scale = 2, precision = 9, nullable = false)
    private BigDecimal valor;

    @Column(name="nr_estoque", precision = 9)
    private Long estoque;

    @Column(name="st_frete_gratis")
    private Boolean freteGratis;

    @Column(name="dt_fabricacao")
    private LocalDate dataFabricacao;

    @Column(name="dt_cadastro")
    @CreatedDate
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name="ds_estado", nullable = false, length = 20)
    private EstadoProduto estado;

}
