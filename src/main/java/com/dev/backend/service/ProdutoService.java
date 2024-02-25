package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto insertProduto(Produto produto){
        produto.setDataCriacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public Produto updateProduto(Produto produto){
        produto.setDataUpdate(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public List <Produto> findAllProdutos(){
        return produtoRepository.findAll();
    }

    @SuppressWarnings("null")
    public void deleteProduto(Long id){
        @SuppressWarnings("null")
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }

}
