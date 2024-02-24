package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria insert (Categoria categoria){
        categoria.setDataCriacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public Categoria update (Categoria categoria){
        categoria.setDataUpDate(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public List <Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    @SuppressWarnings("null")
    public void delete(Long id){
        @SuppressWarnings("null")
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria); 
    }
}
