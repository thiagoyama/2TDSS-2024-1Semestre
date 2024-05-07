package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
