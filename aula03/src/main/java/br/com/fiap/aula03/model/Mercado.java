package br.com.fiap.aula03.model;

import br.com.fiap.aula03.dto.mercado.AtualizacaoMercadoDto;
import br.com.fiap.aula03.dto.mercado.CadastroMercadoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "TB_MERCADO")
public class Mercado {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private CategoriaMercado categoria;
    private String cnpj;
    private Double faturamento;

    //Cria um construtor que recebe o dto para cadastro
    public Mercado(CadastroMercadoDto mercadoDto) {
        nome = mercadoDto.nome();
        categoria = mercadoDto.categoria();
        cnpj = mercadoDto.cnpj();
        faturamento = mercadoDto.faturamento();
    }

    public void atualizarDados(AtualizacaoMercadoDto mercadoDto) {
        if (mercadoDto.nome() != null)
            nome = mercadoDto.nome();
        if (mercadoDto.categoria() != null)
            categoria = mercadoDto.categoria();
        if (mercadoDto.faturamento() != null)
            faturamento = mercadoDto.faturamento();
    }
}
