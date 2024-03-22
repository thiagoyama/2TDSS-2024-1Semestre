package br.com.fiap.store.aula04.controller;

import br.com.fiap.store.aula04.dto.cliente.CadastroClienteDto;
import br.com.fiap.store.aula04.dto.cliente.DetalhesClienteDto;
import br.com.fiap.store.aula04.model.Cliente;
import br.com.fiap.store.aula04.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDto> cadastrar(@RequestBody CadastroClienteDto clienteDto,
                                                        UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(clienteDto);
        clienteRepository.save(cliente);
        var url = uriBuilder.path("clientes/{codigo}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesClienteDto(cliente));
    }

}
