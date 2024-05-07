package br.com.fiap.tour.domain;

import br.com.fiap.tour.dto.pacote.AtualizacaoPacoteDTO;
import br.com.fiap.tour.dto.pacote.CadastroPacoteDTO;
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
@Table(name="tb_ead_pacote")
@SequenceGenerator(name="seq_pacote", sequenceName="seq_tb_ead_pacote", allocationSize=1)
public class Pacote {

	@Id
	@Column(name="cd_pacote")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_pacote")
	private Long id;

	@Column(name="nm_pacote", length = 50, nullable=false)
	private String nome;

	@Column(name="ds_pacote", length = 200, nullable=false)
	private String descricao;
	
	@Column(name="dt_saida",nullable=false)
	private LocalDate dataSaida;
	
	@Column(name="qt_dias")
	private Integer quantidadeDias;
	
	@Column(name="vl_pacote")
	private Float valor;
	
	@ManyToOne
	@JoinColumn(name="cd_destino")
	private Destino destino;

    public Pacote(CadastroPacoteDTO dto) {
		nome = dto.nome();
		descricao = dto.descricao();
		dataSaida = dto.dataSaida();
		quantidadeDias = dto.quantidadeDias();
		valor = dto.valor();
    }

	public void atualizar(AtualizacaoPacoteDTO dto) {
		if (dto.nome() != null)
			nome = dto.nome();
		if (dto.descricao() != null)
			descricao = dto.descricao();
		if (dto.dataSaida() != null)
			dataSaida = dto.dataSaida();
		if (dto.quantidadeDias() != null)
			quantidadeDias = dto.quantidadeDias();
		if (dto.valor() != null)
			valor = dto.valor();
	}
}
