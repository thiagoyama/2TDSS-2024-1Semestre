package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
