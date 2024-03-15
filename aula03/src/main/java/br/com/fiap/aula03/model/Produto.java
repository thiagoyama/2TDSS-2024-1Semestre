package br.com.fiap.aula03.model;

import br.com.fiap.aula03.dto.produto.CadastroProdutoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private Double valor;
    private Integer quantidade;
    private LocalDate dataCadatro;

    public Produto(CadastroProdutoDto dto){
        nome = dto.nome();
        valor = dto.valor();
        quantidade = dto.quantidade();
        dataCadatro = dto.dataCadastro();
    }

}
