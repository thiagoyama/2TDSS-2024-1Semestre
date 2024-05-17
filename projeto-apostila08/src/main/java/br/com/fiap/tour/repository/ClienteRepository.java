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

    //buscarPorEstados(List<String> estados): retorna
    //todos os clientes conforme os estados passados
    //como parâmetro;
    @Query("from Cliente c where c.endereco.cidade.uf in :estados")
    Page<Cliente> buscarPorEstados(List<String> estados, Pageable pageable);

    //buscar(String nome, String cidade): retorna os
    //clientes que possuam parte do nome o texto
    //informado como parâmetro e que tenham algum
    //endereço por parte do nome de cidade informado;
    @Query("from Cliente c where c.nome like %:nome% and c.endereco.cidade.nome like %:cidade%")
    Page<Cliente> buscarPorNomeCidade(String nome, String cidade, Pageable pageable);

    //Obter todos os clientes que possuem reservas
    //de um pacote com preço maior do que o
    //especificado.
    @Query("select cliente from Reserva r where r.pacote.valor > :valorPacote")
    Page<Cliente> buscarPorValorPacote(@Param("valorPacote") Double valor, Pageable pageable);

    //Criar a pesquisa de cliente por data de nascimento
    @Query("select c from Cliente c where c.dataNascimento = :data")
    Page<Cliente> buscarPorDataNascimento(@Param("data") LocalDate dataNascimento, Pageable page);

    @Query("from Cliente c where lower(c.nome) like %:nome%")
    Page<Cliente> buscarPorNome(@Param("nome") String nome, Pageable page);

    @Query("from Cliente c where c.endereco.cidade.uf = :estado")
    Page<Cliente> buscarPorEstado(String estado, Pageable pageable);



}
