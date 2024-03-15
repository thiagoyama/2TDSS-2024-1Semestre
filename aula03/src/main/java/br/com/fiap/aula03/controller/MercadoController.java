package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.mercado.AtualizacaoMercadoDto;
import br.com.fiap.aula03.dto.mercado.CadastroMercadoDto;
import br.com.fiap.aula03.dto.mercado.DetalhesMercadoDto;
import br.com.fiap.aula03.dto.mercado.ListagemMercadoDto;
import br.com.fiap.aula03.model.Mercado;
import br.com.fiap.aula03.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @Autowired //Injeção de dependencia, o spring coloca o objeto no atributo
    private MercadoRepository mercadoRepository;

    @GetMapping("{id}")
    public ResponseEntity<DetalhesMercadoDto> buscar(@PathVariable("id") Integer id){
        var mercado = mercadoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesMercadoDto(mercado));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        mercadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesMercadoDto> atualizar(@PathVariable("id") Integer id,
                                                        @RequestBody AtualizacaoMercadoDto mercadoDto){
        //pesquisando o mercado no banco
        var mercado = mercadoRepository.getReferenceById(id);
        //atualizar os dados do objeto do banco com os dados do dto
        mercado.atualizarDados(mercadoDto);
        return ResponseEntity.ok(new DetalhesMercadoDto(mercado));
    }

    @GetMapping
    public ResponseEntity<List<ListagemMercadoDto>> listar(Pageable pageable){
        var lista = mercadoRepository.findAll(pageable)
                .stream().map(ListagemMercadoDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesMercadoDto> cadastrar(@RequestBody CadastroMercadoDto mercadoDto,
                                                        UriComponentsBuilder uri){
        var mercado = new Mercado(mercadoDto);
        mercadoRepository.save(mercado);
        var url = uri.path("/mercados/{id}").buildAndExpand(mercado.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesMercadoDto(mercado));
    }

}
