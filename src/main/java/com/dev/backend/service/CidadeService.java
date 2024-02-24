package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    @SuppressWarnings("null")
    public Cidade insert(Cidade cidade ){
        cidade.setDataCriacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    @SuppressWarnings("null")
    public Cidade update( Cidade cidade){
        cidade.setDataUpdate(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public List <Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    @SuppressWarnings("null")
    public void delete(Long id){
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }
    

}
