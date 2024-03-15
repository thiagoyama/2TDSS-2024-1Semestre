package br.com.fiap.aula03.dto.produto;

import java.time.LocalDate;

public record CadastroProdutoDto(String nome, Double valor, Integer quantidade, LocalDate dataCadastro) {
}
