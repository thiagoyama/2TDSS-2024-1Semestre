package br.com.fiap.tour.dto.cliente;

import br.com.fiap.tour.dto.endereco.CadastroEnderecoDTO;

import java.time.LocalDate;

public record CadastroClienteDTO(String nome, String cpf, LocalDate dataNascimento, CadastroEnderecoDTO endereco) {
}
