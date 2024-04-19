package br.com.fiap.aula04.exercicio.controller;

import br.com.fiap.aula04.exercicio.dto.post.CadastroPostDto;
import br.com.fiap.aula04.exercicio.dto.post.DetalhesPostDto;
import br.com.fiap.aula04.exercicio.model.Post;
import br.com.fiap.aula04.exercicio.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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

}
