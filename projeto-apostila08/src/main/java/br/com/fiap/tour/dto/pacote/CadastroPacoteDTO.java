package br.com.fiap.tour.dto.pacote;

import java.time.LocalDate;

public record CadastroPacoteDTO(String nome, String descricao, LocalDate dataSaida, Integer quantidadeDias, Float valor, Long destinoId) {
}
