package br.com.fiap.aula03.dto.mercado;

import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;

public record ListagemMercadoDto(Integer id, String nome, CategoriaMercado categoria) {

    public ListagemMercadoDto(Mercado mercado){
        this(mercado.getId(), mercado.getNome(), mercado.getCategoria());
    }

}
