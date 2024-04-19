package br.com.fiap.aula04.exercicio.dto.post;

import br.com.fiap.aula04.exercicio.model.Post;

import java.time.LocalDateTime;

public record DetalhesPostDto(Long codigo, String titulo, String conteudo,
                              String autor, LocalDateTime dataCriacao, LocalDateTime dataPublicacao) {

    public DetalhesPostDto(Post post){
        this(post.getId(), post.getTitulo(), post.getConteudo(), post.getDetalhes().getAutor(),
                post.getDetalhes().getDataCriacao(), post.getDetalhes().getDataPublicacao());
    }

}
