package br.com.fiap.aula04.exercicio.model;

import br.com.fiap.aula04.exercicio.dto.post.CadastroPostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany
    @JoinTable(name="TB_TAG_POST",
        joinColumns = @JoinColumn(name="cd_post"),
        inverseJoinColumns = @JoinColumn(name="cd_tag"))
    private List<Tag> tags;

    @OneToMany(mappedBy = "post")
    private List<Comentario> comentarios;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private DetalhesPost detalhes;

    public Post(CadastroPostDto dto){
        titulo = dto.titulo();
        conteudo = dto.conteudo();
        detalhes = new DetalhesPost(dto);
        detalhes.setPost(this); //seta a FK da relação
    }

}
