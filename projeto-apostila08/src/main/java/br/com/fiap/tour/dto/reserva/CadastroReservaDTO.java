package br.com.fiap.tour.dto.reserva;

import java.time.LocalDateTime;

public record CadastroReservaDTO(LocalDateTime data, Long clienteId, Long pacoteId) {
}
