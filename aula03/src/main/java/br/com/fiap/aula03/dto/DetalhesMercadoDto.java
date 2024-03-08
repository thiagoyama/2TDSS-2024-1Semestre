package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;

public record DetalhesMercadoDto(Integer id, String nome, CategoriaMercado categoria) {

    public DetalhesMercadoDto(Mercado mercado) {
        this(mercado.getId(), mercado.getNome(), mercado.getCategoria());
    }
    
}
