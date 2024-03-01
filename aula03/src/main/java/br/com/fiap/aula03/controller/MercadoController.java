package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.dto.CadastroMercadoDto;
import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @PostMapping
    public ResponseEntity<Mercado> cadastrar(@RequestBody CadastroMercadoDto mercadoDto, UriComponentsBuilder uri){
        System.out.println(mercadoDto.nome() + " " + mercadoDto.categoria());
        var url = uri.path("/mercados/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(url).body(new Mercado(1, "Sonda", CategoriaMercado.HIPER));
    }

    @GetMapping
    public Mercado get(){
        return new Mercado(1,"Atacadão", CategoriaMercado.HIPER);
    }

}
