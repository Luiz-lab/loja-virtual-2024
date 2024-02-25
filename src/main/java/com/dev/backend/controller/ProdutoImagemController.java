package com.dev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.ProdutoImagem;
import com.dev.backend.service.ProdutoImagemService;


@RestController
@RequestMapping("/api/produtoImagem")
public class ProdutoImagemController {

    @Autowired
    private ProdutoImagemService produtoImagemService;

    @PostMapping("/")
    public ProdutoImagem insertImagem(@RequestParam("idProduto") Long idProduto,@RequestParam("file") MultipartFile file) {
        return produtoImagemService.insertImagem(idProduto, file);
    }
    
}
