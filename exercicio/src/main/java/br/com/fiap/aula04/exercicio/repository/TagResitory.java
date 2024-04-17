package br.com.fiap.aula04.exercicio.repository;

import br.com.fiap.aula04.exercicio.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagResitory extends JpaRepository<Tag, Long> {
}
