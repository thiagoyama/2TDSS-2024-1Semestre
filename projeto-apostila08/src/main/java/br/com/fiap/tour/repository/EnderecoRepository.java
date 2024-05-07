package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
