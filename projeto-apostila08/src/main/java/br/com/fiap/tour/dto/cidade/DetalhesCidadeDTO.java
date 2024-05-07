package br.com.fiap.tour.dto.cidade;

import br.com.fiap.tour.domain.Cidade;

public record DetalhesCidadeDTO(Long id, String nome, String uf, Integer ddd, Integer numeroHabitantes) {
    public DetalhesCidadeDTO(Cidade post) {
        this(post.getId(), post.getNome(), post.getUf(), post.getDdd(), post.getNumeroHabitantes());
    }
}
