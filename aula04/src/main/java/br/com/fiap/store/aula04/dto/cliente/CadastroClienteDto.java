package br.com.fiap.store.aula04.dto.cliente;

import br.com.fiap.store.aula04.model.CategoriaCliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroClienteDto(
        @NotBlank
        String nome,
        @NotBlank
        @Size(max = 11, min = 11, message = "CPF deve conter 11 caracteres")
        String cpf,
        @Past(message = "Data de nascimento deve estar no passado")
        @NotNull
        LocalDate dataNascimento,
        @NotNull(message = "Categoria é obrigatório")
        CategoriaCliente categoria) {}
