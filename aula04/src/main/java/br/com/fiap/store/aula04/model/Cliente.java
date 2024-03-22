package br.com.fiap.store.aula04.model;

import br.com.fiap.store.aula04.dto.cliente.CadastroClienteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "aula4_cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name="cd_codigo")
    private Long codigo;

    @Column(name="nm_cliente", nullable = false, length = 100)
    private String nome;

    @Column(name = "nr_cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name="dt_cadastro")
    @CreatedDate
    private LocalDateTime dataCadastro;

    @Column(name="ds_categoria", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private CategoriaCliente categoria;

    @Transient //Não será uma coluna no banco de dados
    private String token;

    @Column(name="nr_pontos", precision = 10)
    private Integer pontos;


    public Cliente(CadastroClienteDto dto){
        nome = dto.nome();
        cpf = dto.cpf();
        dataNascimento = dto.dataNascimento();
        categoria = dto.categoria();
    }

}
