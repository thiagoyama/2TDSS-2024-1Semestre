package br.com.fiap.aula03.repository;

import br.com.fiap.aula03.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRespository extends JpaRepository<Produto, Integer> {
}
