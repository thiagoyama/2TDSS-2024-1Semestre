package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Page<Reserva> findByClienteCpfEquals(String cpf, Pageable pageable);

    Page<Reserva> findByDataBetween(LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable);

}
