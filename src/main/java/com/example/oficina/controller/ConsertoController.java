package com.example.oficina.controller;

import com.example.oficina.Conserto;
import com.example.oficina.ConsertoRepository;
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
    public void cadastrar(@RequestBody Conserto conserto) {
        repository.save(conserto);
    }

    @GetMapping
    public List<Conserto> listarTodos() {
        return repository.findAll();
    }
}

