package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="aula4_fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue
    @Column(name="cd_fornecedor")
    private Long codigo;

    @Column(name="nm_fornecedor", nullable = false, length = 50)
    private String nome;
    @Column(name="nr_cnpj", nullable = false, length = 22)
    private String cnpj;

}
