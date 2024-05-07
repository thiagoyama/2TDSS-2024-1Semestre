package br.com.fiap.tour.dto.endereco;

import br.com.fiap.tour.domain.Endereco;
import br.com.fiap.tour.dto.cidade.DetalhesCidadeDTO;

public record DetalhesEnderecoDTO(Long id, String logradouro, String cep, DetalhesCidadeDTO cidade) {
    public DetalhesEnderecoDTO(Endereco endereco) {
        this(endereco.getId(), endereco.getLogradouro(), endereco.getCep(), new DetalhesCidadeDTO(endereco.getCidade()));
    }
}
