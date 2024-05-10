package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Pacote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {

    @Query("from Pacote p where p.destino.id = :id")
    Page<Pacote>  buscarPorDestino(Long id, Pageable pageable);

}
