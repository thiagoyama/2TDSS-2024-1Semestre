package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.CategoriaMercado;

public record CadastroMercadoDto(String nome, CategoriaMercado categoria, String cnpj, Double faturamento) {

}
