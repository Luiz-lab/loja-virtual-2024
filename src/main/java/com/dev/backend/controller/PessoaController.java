package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Marca;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.MarcaService;
import com.dev.backend.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;  

    @SuppressWarnings("rawtypes")
    @GetMapping("/")
    public List findAll() {
        return pessoaService.findAll();
    }

    @PostMapping("/")
    public Pessoa insert(@RequestBody Pessoa pessoa) {        
        return pessoaService.insertName(pessoa);
    }

    @PutMapping("/")
    public Pessoa update(@RequestBody Pessoa pessoa ) {
        return pessoaService.updateName(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Long id){
        pessoaService.deleteName(id);
        return ResponseEntity.ok().build();
    }


}
