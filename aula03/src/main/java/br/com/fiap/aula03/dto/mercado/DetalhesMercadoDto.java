package br.com.fiap.aula03.dto.mercado;

import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;

public record DetalhesMercadoDto(Integer id, String nome, CategoriaMercado categoria,
                                 String cnpj, Double faturamento) {

    public DetalhesMercadoDto(Mercado mercado) {

        this(mercado.getId(), mercado.getNome(), mercado.getCategoria(),
                        mercado.getCnpj(), mercado.getFaturamento());
    }
    
}
