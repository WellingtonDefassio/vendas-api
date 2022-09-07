package br.vendasapi.controller;

import br.vendasapi.form.ClienteCadastroFormRequest;
import br.vendasapi.model.Cliente;
import br.vendasapi.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody ClienteCadastroFormRequest clienteRequest) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (!clienteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = clienteRequest.toModel();
        cliente.setId(id);
        clienteRepository.save(cliente);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.map(ClienteCadastroFormRequest::fromModel)
                .map(clientForm -> ResponseEntity.ok(clientForm))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {

        return clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity getLista() {
        List<ClienteCadastroFormRequest> clienteCadastroFormRequests = clienteRepository.findAll().stream().map(ClienteCadastroFormRequest::fromModel).toList();
        return new ResponseEntity<>(clienteCadastroFormRequests, HttpStatus.OK);
    }

}
