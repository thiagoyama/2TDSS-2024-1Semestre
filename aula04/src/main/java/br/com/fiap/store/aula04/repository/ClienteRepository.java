package br.com.fiap.store.aula04.repository;

import br.com.fiap.store.aula04.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
