package br.com.fiap.tour.dto.destino;

import br.com.fiap.tour.domain.Destino;

public record DetalhesDestinoDTO(Long id, String nome) {
    public DetalhesDestinoDTO(Destino destino) {
        this(destino.getId(), destino.getNome());
    }
}
