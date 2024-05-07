package br.com.fiap.tour.domain;

import br.com.fiap.tour.dto.cliente.AtualizacaoClienteDTO;
import br.com.fiap.tour.dto.cliente.CadastroClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_ead_cliente")
@SequenceGenerator(name="seq_cliente", sequenceName="seq_tb_ead_cliente", allocationSize=1)
public class Cliente {

	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cliente")
	private Long id;
	
	@Column(name="nm_cliente", length = 80, nullable=false)
	private String nome;
	
	@Column(length=11,nullable=false, name="nr_cpf")
	private String cpf;
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_endereco")
	private Endereco endereco;

    public Cliente(CadastroClienteDTO dto) {
		nome = dto.nome();
		cpf = dto.cpf();
		dataNascimento = dto.dataNascimento();
		endereco = new Endereco(dto.endereco());
    }

	public void atualizar(AtualizacaoClienteDTO dto) {
		if (dto.nome() != null)
			nome = dto.nome();
		if (dto.cpf() != null)
			cpf = dto.cpf();
		if (dto.dataNascimento() != null)
			dataNascimento = dto.dataNascimento();
	}
}
