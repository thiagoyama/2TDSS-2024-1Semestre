package br.com.fiap.tour.controller;

import br.com.fiap.tour.domain.Destino;
import br.com.fiap.tour.dto.destino.AtualizacaoDestinoDTO;
import br.com.fiap.tour.dto.destino.CadastroDestinoDTO;
import br.com.fiap.tour.dto.destino.DetalhesDestinoDTO;
import br.com.fiap.tour.repository.DestinoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    @Autowired
    private DestinoRepository destinoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesDestinoDTO> cadastrar(@RequestBody @Valid CadastroDestinoDTO dto, UriComponentsBuilder builder) {
        var destino = new Destino(dto);
        destino = destinoRepository.save(destino);
        var uri = builder.path("/destinos/{id}").buildAndExpand(destino.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesDestinoDTO(destino));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesDestinoDTO>> pesquisar(Pageable pageable){
        var page = destinoRepository.findAll(pageable).map(DetalhesDestinoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDestinoDTO> pesquisar(@PathVariable("id") Long id){
        var destino = new DetalhesDestinoDTO(destinoRepository.getReferenceById(id));
        return ResponseEntity.ok(destino);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDestinoDTO> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizacaoDestinoDTO dto){
        var destino = destinoRepository.getReferenceById(id);
        destino.atualizar(dto);
        return ResponseEntity.ok(new DetalhesDestinoDTO(destino));
    }
}
