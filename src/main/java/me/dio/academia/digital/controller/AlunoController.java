package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;


    @GetMapping
    public List<Aluno> recuperarAlunos() {
        return service.getAll();
    }

    @PostMapping
    public Aluno create(@RequestBody AlunoForm alunoForm) {
        return service.create(alunoForm);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> recuperarAvaliacoesFisica(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

}
