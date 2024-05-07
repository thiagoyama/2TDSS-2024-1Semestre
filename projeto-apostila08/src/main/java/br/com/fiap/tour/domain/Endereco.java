package br.com.fiap.tour.domain;

import br.com.fiap.tour.dto.endereco.CadastroEnderecoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_ead_endereco")
@SequenceGenerator(name="seq_endereco", sequenceName="seq_tb_ead_endereco", allocationSize=1)
public class Endereco {

	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_endereco")
	private Long id;
	
	@Column(name="ds_logradouro", length = 100, nullable=false)
	private String logradouro;
	
	@Column(nullable=false, name="nr_cep", length = 9)
	private String cep;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_cidade")
	private Cidade cidade;

    public Endereco(CadastroEnderecoDTO dto) {
		logradouro = dto.logradouro();
		cep = dto.cep();
    }
}
