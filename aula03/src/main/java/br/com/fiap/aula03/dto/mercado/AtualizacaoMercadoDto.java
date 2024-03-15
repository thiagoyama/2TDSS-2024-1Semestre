package br.com.fiap.aula03.dto.mercado;

import br.com.fiap.aula03.model.CategoriaMercado;

public record AtualizacaoMercadoDto(String nome, CategoriaMercado categoria, Double faturamento) {
}
