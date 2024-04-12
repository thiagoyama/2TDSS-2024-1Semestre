package br.com.fiap.aula04.exercicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_POST")
public class Post {

    @Id
    @GeneratedValue
    @Column(name="cd_post")
    private Long id;

    @Column(name="ds_titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "ds_conteudo", nullable = false, length = 500)
    private String conteudo;

}
