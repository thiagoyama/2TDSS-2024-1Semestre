package br.com.fiap.aula03.dto.produto;

import br.com.fiap.aula03.model.Produto;

import java.time.LocalDate;

public record DetalhesProdutoDto(Integer id, String nome, Double valor, Integer quantidade, LocalDate dataCadastro) {

    public DetalhesProdutoDto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getValor(), produto.getQuantidade(), produto.getDataCadatro());
    }

}
