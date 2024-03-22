package br.com.fiap.store.aula04.dto.cliente;

import br.com.fiap.store.aula04.model.CategoriaCliente;
import java.time.LocalDate;

public record CadastroClienteDto(String nome, String cpf,
                                 LocalDate dataNascimento, CategoriaCliente categoria) {



}
