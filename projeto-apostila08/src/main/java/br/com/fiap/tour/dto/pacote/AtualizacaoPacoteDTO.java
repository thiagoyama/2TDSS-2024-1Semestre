package br.com.fiap.tour.dto.pacote;

import java.time.LocalDate;

public record AtualizacaoPacoteDTO(String nome, String descricao, LocalDate dataSaida, Integer quantidadeDias, Float valor) {
}
