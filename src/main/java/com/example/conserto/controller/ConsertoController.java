package com.example.conserto.controller;

import com.example.conserto.Conserto;
import com.example.conserto.ConsertoRepository;
import com.example.conserto.DadosConserto;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Conserto> listarTodos() {
        return repository.findAll();
    }
}

