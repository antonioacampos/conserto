package com.example.conserto.controller;

import com.example.conserto.Conserto;
import com.example.conserto.ConsertoRepository;
import com.example.conserto.DadosConserto;
import com.example.conserto.DadosListagemConserto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import java.util.List;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto conserto) {
        repository.save(new Conserto(conserto));
    }

    @GetMapping
    public Page<Conserto> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("dados")
    public Page<DadosListagemConserto> listarDados(Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemConserto::new);
    }

}


