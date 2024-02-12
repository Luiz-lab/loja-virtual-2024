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
import com.dev.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;  

    @GetMapping("/")
    public List findAll() {
        return marcaService.findAll();
    }

    @PostMapping("/")
    public Marca insert(@RequestBody Marca marca) {        
        return marcaService.insert(marca);
    }

    @PutMapping("/")
    public Marca update(@RequestBody Marca marca ) {
        return marcaService.update(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Long id){
        marcaService.delete(id);
        return ResponseEntity.ok().build();
    }


}
