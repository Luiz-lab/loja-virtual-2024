package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public Marca insert(Marca marca){
        marca.setData_criacao(new Date());
        Marca newMarca = marcaRepository.saveAndFlush(marca);
        return newMarca;
    }

    public Marca update(Marca marca){
        marca.setData_update(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public List <Marca> findAll(){
        return marcaRepository.findAll();
    }

    @SuppressWarnings("null")
    public void delete(Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }


}
