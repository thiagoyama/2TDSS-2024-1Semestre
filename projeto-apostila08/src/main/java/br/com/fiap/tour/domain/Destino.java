package br.com.fiap.tour.domain;

import br.com.fiap.tour.dto.destino.AtualizacaoDestinoDTO;
import br.com.fiap.tour.dto.destino.CadastroDestinoDTO;
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
@Table(name="tb_ead_destino")
@SequenceGenerator(name="seq_destino", sequenceName="seq_tb_ead_destino", allocationSize=1)
public class Destino {

	@Id
	@Column(name="cd_destino")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_destino")
	private Long id;
	
	@Column(nullable=false, name="nm_destino", length = 80)
	private String nome;

    public Destino(CadastroDestinoDTO dto) {
		nome = dto.nome();
    }

	public void atualizar(AtualizacaoDestinoDTO dto) {
		if (dto.nome() != null)
			nome = dto.nome();
	}
}
