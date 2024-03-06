package br.com.fiap.aula03.repository;

import br.com.fiap.aula03.model.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoRepository extends JpaRepository<Mercado,Integer> {
}
