package br.com.fiap.tour.domain;

import br.com.fiap.tour.dto.reserva.CadastroReservaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_ead_reserva")
@SequenceGenerator(name="seq_reserva", sequenceName="seq_tb_ead_reserva", allocationSize=1)
public class Reserva {

	@Id
	@Column(name="cd_reserva")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_reserva")
	private Long id;

	@Column(name="dt_reserva")
	private LocalDateTime data;
	
	@ManyToOne
	@JoinColumn(name="cd_pacote")
	private Pacote pacote;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;

    public Reserva(CadastroReservaDTO dto) {
		data = dto.data();
    }
}
