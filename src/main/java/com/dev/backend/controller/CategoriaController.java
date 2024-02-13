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

import com.dev.backend.entity.Categoria;
import com.dev.backend.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;  

    @SuppressWarnings("rawtypes")
    @GetMapping("/")
    public List findAll() {
        return categoriaService.findAll();
    }

    @PostMapping("/")
    public Categoria insert(@RequestBody Categoria categoria) {        
        return categoriaService.insert(categoria);
    }

    @PutMapping("/")
    public Categoria update(@RequestBody Categoria categoria ) {
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Long id){
        categoriaService.delete(id);
        return ResponseEntity.ok().build();
    }


}
