package br.com.fiap.tour.dto.pacote;

import br.com.fiap.tour.domain.Pacote;
import br.com.fiap.tour.dto.destino.DetalhesDestinoDTO;

import java.time.LocalDate;

public record DetalhesPacoteDTO(Long id, String nome, String descricao, LocalDate dataSaida, Integer quantidadeDias, Float valor, DetalhesDestinoDTO destino) {
    public DetalhesPacoteDTO(Pacote pacote) {
        this(pacote.getId(), pacote.getNome(), pacote.getDescricao(), pacote.getDataSaida(), pacote.getQuantidadeDias(), pacote.getValor(), new DetalhesDestinoDTO(pacote.getDestino()));
    }
}
