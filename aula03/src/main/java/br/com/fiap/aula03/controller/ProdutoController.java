package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.produto.CadastroProdutoDto;
import br.com.fiap.aula03.dto.produto.DetalhesProdutoDto;
import br.com.fiap.aula03.model.Produto;
import br.com.fiap.aula03.repository.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRespository produtoRespository;
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> post(@RequestBody CadastroProdutoDto dto, UriComponentsBuilder uriBuilder){
        var produto = new Produto(dto);
        produtoRespository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesProdutoDto(produto));
    }

}
