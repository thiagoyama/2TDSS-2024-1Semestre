package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Pacote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

    @Query("from Pacote p where p.destino.id = :id")
    Page<Pacote>  buscarPorDestino(Long id, Pageable pageable);

    @Query("from Pacote p where p.dataSaida between :inicio and :fim")
    Page<Pacote> buscarPorData(LocalDate inicio, LocalDate fim, Pageable pageable);

}
