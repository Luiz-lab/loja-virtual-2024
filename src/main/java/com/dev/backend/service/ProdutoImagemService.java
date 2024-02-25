package com.dev.backend.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutoImagem;
import com.dev.backend.repository.ProdutoImagemRepository;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagemService {
    
    @Autowired
    private ProdutoImagemRepository produtoImagemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List <ProdutoImagem> findAllProdutoImagem(){
        return produtoImagemRepository.findAll();
    }

    public ProdutoImagem insertImagem(Long id, MultipartFile file){
        Produto produto = produtoRepository.findById(id).get();
        ProdutoImagem produtoImagem = new ProdutoImagem();
        try {
            if (file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path fileAddress =  Paths
                .get("/Users/luizcalixto/Documents/Estudo/Programação/JavaAcademy/LojaVirtualYoutube/imagens/"+ nomeImagem);
                Files.write(fileAddress, bytes);
                produtoImagem.setName(nomeImagem);
            }
        } catch (Exception e) {
            System.err.println("Imagem não salva"+e.getMessage());
        }
        produtoImagem.setProduto(produto);
        produtoImagem.setDataCriacao(new Date());
        return produtoImagemRepository.saveAndFlush(produtoImagem);
    }

    public ProdutoImagem updateProdutoImagem(ProdutoImagem produtoImagem){
        produtoImagem.setDataUpdate(new Date());
        return produtoImagemRepository.saveAndFlush(produtoImagem);
    }


    
}
