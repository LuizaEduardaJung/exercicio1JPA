package com.example.exercicio01jpa.repository;

import com.example.exercicio01jpa.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByCidade(String cidade);
    List<Endereco> findByCep(String cep);
    List<Endereco> findByRua(String rua);
}