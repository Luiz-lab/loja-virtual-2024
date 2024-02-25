package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Permissao;
import com.dev.backend.service.PermissaoService;




@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> findAllPermissao() {
        return permissaoService.findAllPermissaos();
    }

    @PostMapping("/")
    public Permissao insertPermissao(@RequestBody Permissao permissao) {
        return permissaoService.insertPermissao(permissao);
    }
    
    @PutMapping("/")
    public Permissao updPermissao(@RequestBody Permissao permissao) {
        return permissaoService.updatePermissao(permissao);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissao(@RequestParam("id") Long Id){
        permissaoService.deletePermissao(Id);
        return ResponseEntity.ok().build();
    }
    
}
