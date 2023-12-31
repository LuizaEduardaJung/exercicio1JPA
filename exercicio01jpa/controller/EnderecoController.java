package com.example.exercicio01jpa.controller;
import com.example.exercicio01jpa.entity.Endereco;
import com.example.exercicio01jpa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller

@RequestMapping("api/v1")
@RestController
public class EnderecoController {

        @Autowired
        private EnderecoService enderecoService;

        @PostMapping("endereco")
        public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco){
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvarEndereco(endereco));
        }

        @GetMapping("endereco/{id}")
        public ResponseEntity<Endereco> buscarEndereco(@PathVariable Long id){
            Endereco endereco = enderecoService.buscarEndereco(id);
            if(endereco==null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
            }else{
                return ResponseEntity.status(HttpStatus.OK).body(endereco);
            }
        }

        @GetMapping("enderecos")
        public ResponseEntity<List<Endereco>> buscarEnderecos(){
            return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarEnderecos());
        }

        @PutMapping("endereco")
        public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco){
            return ResponseEntity.status(HttpStatus.OK).body(enderecoService.atualizarEndereco(endereco));
        }

        @DeleteMapping("excluir/{id}")
        public ResponseEntity<String> apagarEndereco(@PathVariable Long id) {
            try {
                enderecoService.apagarEndereco(id);
                return ResponseEntity.status(HttpStatus.OK).body("Endereco com id " + id + " excluído com sucesso!");
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            }
        }

    @GetMapping("cidade/{cidade}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorCidade(@PathVariable String cidade){
        List<Endereco> endereco = enderecoService.buscarEnderecoPorCidade(cidade);
        if(endereco==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }
    @GetMapping("cep/{cep}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorCep(@PathVariable String cep){
        List<Endereco> endereco= enderecoService.buscarEnderecoPorCep(cep);
        if(endereco==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }

    @GetMapping("rua/{rua}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorRua(@PathVariable String rua){
        List<Endereco> endereco = enderecoService.buscarEnderecoPorRua(rua);
        if(endereco==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
    }

    }


