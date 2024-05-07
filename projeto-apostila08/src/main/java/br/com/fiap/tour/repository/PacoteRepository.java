package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacoteRepository extends JpaRepository<Pacote, Long> {
}
