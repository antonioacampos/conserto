package com.example.conserto.controller;

import com.example.conserto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosConserto conserto, UriComponentsBuilder uriBuilder)
    {
        Conserto entity = new Conserto(conserto);
        repository.save(entity);
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoConserto(entity));

    }

    @GetMapping
    public ResponseEntity listarTodos(Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("dados")
    public ResponseEntity listarDados(Pageable pageable){
        return ResponseEntity.ok(repository.findAllByAtivoTrue(pageable).map(DadosListagemConserto::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<Conserto> consertoOptional= repository.findById(id);
        if(consertoOptional.isPresent()){
            return ResponseEntity.ok(new DetalhamentoConserto(consertoOptional.get()));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizaConserto dados){
        Conserto conserto=repository.getReferenceById(dados.id());
        conserto.update(dados);
        return ResponseEntity.ok(new DetalhamentoConserto(repository.getReferenceById(dados.id())));


    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletaConserto(@PathVariable long id){
        Conserto conserto=repository.getReferenceById(id);
        conserto.delete();
        return ResponseEntity.noContent().build();
    }


}


