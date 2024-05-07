package br.com.fiap.tour.dto.cliente;

import br.com.fiap.tour.domain.Cliente;
import br.com.fiap.tour.dto.endereco.DetalhesEnderecoDTO;

import java.time.LocalDate;

public record DetalhesClienteDTO(Long id, String nome, String cpf, LocalDate dataNascimento, DetalhesEnderecoDTO endereco) {
    public DetalhesClienteDTO(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento(), new DetalhesEnderecoDTO(cliente.getEndereco()));
    }
}
