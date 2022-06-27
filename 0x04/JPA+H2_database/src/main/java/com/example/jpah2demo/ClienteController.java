package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente){
        try {
            cliente.setId(null);
            Cliente clientCreated = clienteRepository.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clientCreated);

        } catch (Exception e){
            System.out.println("Error on create Client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients(){
        try {
            List<Cliente> listaClientes = clienteRepository.findAll();
            return ResponseEntity.ok(listaClientes);
        } catch (Exception e){
            System.out.println("Error on update Client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("findClienteById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient){
        try {
            Optional<Cliente> cliente = clienteRepository.findById(idClient);
            return ResponseEntity.ok(cliente.get());
        } catch (Exception e){
            System.out.println("Error on find client by ID: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        try {
            clienteRepository.deleteById(idClient);
        } catch (Exception e){
            System.out.println("Error on remove client: " + e.getMessage());
        }
    }

    @PutMapping("/updateClienteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        try {
            Optional<Cliente> clientFound = clienteRepository.findById(id);

            if (clientFound.isPresent()){
                Cliente clientUpdate = clientFound.get();
                clientUpdate.setNome(cliente.getNome());
                clientUpdate.setIdade(cliente.getIdade());
                clientUpdate.setEmail(cliente.getEmail());
                clientUpdate.setEnderecos(cliente.getEnderecos());
                clientUpdate.setTelefones(cliente.getTelefones());
                clienteRepository.save(clientUpdate);
            }


        } catch (Exception e){
            System.out.println("Error on update client: " + e.getMessage());
        }
    }

}
