package br.com.fiap.aula04.exercicio.controller;

import br.com.fiap.aula04.exercicio.dto.post.AtualizacaoPostDto;
import br.com.fiap.aula04.exercicio.dto.post.CadastroPostDto;
import br.com.fiap.aula04.exercicio.dto.post.DetalhesPostDto;
import br.com.fiap.aula04.exercicio.model.Post;
import br.com.fiap.aula04.exercicio.repository.PostRepository;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPostDto> create(@RequestBody @Valid CadastroPostDto dto,
                                                  UriComponentsBuilder uriBuilder) {
        var post = new Post(dto);
        postRepository.save(post);
        var url = uriBuilder.path("/posts/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPostDto(post));
    }

    @GetMapping
    public ResponseEntity<List<DetalhesPostDto>> get(Pageable pageable){
        var lista = postRepository.findAll(pageable).stream().map(DetalhesPostDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPostDto> get(@PathVariable("id") Long id){
        var post = postRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesPostDto(post));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPostDto> put(@PathVariable("id") Long id, @RequestBody AtualizacaoPostDto dto){
        var post = postRepository.getReferenceById(id);
        post.atualizar(dto);
        return ResponseEntity.ok(new DetalhesPostDto(post));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
