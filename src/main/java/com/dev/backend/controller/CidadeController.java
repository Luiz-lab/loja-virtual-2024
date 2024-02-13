package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Cidade;
import com.dev.backend.service.CidadeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> findAll() {
        return cidadeService.findAll();
    }
    
    @PostMapping("/")
    public Cidade insert(@RequestBody Cidade cidade) {        
        return cidadeService.insert(cidade);
    }

    @PutMapping("/")
    public Cidade update(@RequestBody Cidade cidade) {        
        return cidadeService.update(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestParam("id") Long id){
        cidadeService.delete(id);
        return ResponseEntity.ok().build();
    }

}
