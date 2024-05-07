package br.com.fiap.tour.dto.cliente;

import java.time.LocalDate;

public record AtualizacaoClienteDTO(String nome, String cpf, LocalDate dataNascimento) {
}
