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

import com.dev.backend.entity.Produto;
import com.dev.backend.service.ProdutoService;




@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @SuppressWarnings("rawtypes")
    @GetMapping("/")
    public List findAllProdutos() {
        return produtoService.findAllProdutos();
    }

    @PostMapping("/")
    public Produto insertProduto(@RequestBody Produto produto) {
        return produtoService.insertProduto(produto);
    }

    @PutMapping("/")
    public Produto updateProduto(@RequestBody Produto produto) {        
        return produtoService.updateProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteProduto(@PathVariable("id") Long id ){
        produtoService.deleteProduto(id);
        return ResponseEntity.ok().build();
    }
    
    
}

