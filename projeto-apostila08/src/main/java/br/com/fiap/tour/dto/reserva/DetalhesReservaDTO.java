package br.com.fiap.tour.dto.reserva;

import br.com.fiap.tour.domain.Destino;
import br.com.fiap.tour.domain.Reserva;
import br.com.fiap.tour.dto.cliente.DetalhesClienteDTO;
import br.com.fiap.tour.dto.pacote.DetalhesPacoteDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesReservaDTO(Long id, LocalDateTime data, DetalhesClienteDTO cliente, DetalhesPacoteDTO pacote) {
    public DetalhesReservaDTO(Reserva reserva) {
        this(reserva.getId(), reserva.getData(), new DetalhesClienteDTO(reserva.getCliente()), new DetalhesPacoteDTO(reserva.getPacote()));
    }

 }
