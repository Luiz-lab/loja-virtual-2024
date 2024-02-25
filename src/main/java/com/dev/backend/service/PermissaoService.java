package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Permissao;
import com.dev.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository permissaoRepository;

    public List <Permissao> findAllPermissaos(){
        return permissaoRepository.findAll();
    }

    public Permissao insertPermissao(Permissao permissao){
        permissao.setDataCriacao(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public Permissao updatePermissao(Permissao permissao){
        permissao.setDataUpdate(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public void deletePermissao(Long Id){
        Permissao permissao = permissaoRepository.findById(Id).get();
        permissaoRepository.delete(permissao);
    }

}
