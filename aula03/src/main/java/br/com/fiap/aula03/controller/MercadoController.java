package br.com.fiap.aula03.controller;

import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mercado")
public class MercadoController {

    //GET
    @GetMapping
    public Mercado get(){
        return new Mercado(1,"Atacadão", CategoriaMercado.HIPER);
    }

}
