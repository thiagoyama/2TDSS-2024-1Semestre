package br.com.fiap.tour.repository;

import br.com.fiap.tour.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Criar a pesquisa de cliente por data de nascimento
    @Query("select c from Cliente c where c.dataNascimento = :data")
    Page<Cliente> buscarPorDataNascimento(@Param("data") LocalDate dataNascimento, Pageable page);

    @Query("from Cliente c where c.nome like %:nome%")
    Page<Cliente> buscarPorNome(@Param("nome") String nome, Pageable page);

}
