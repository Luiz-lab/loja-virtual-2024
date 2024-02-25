    package com.dev.backend.service;

    import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PermissaoRepository;
import com.dev.backend.repository.PessoaClienteRepository;

    @Service
    public class PessoaClienteService {
        
        @Autowired
        private PessoaClienteRepository pessoaClienteRepository;

        @Autowired
        private PermissaoRepository permissaoRepository;

        @Autowired
        private PermissaoPessoaService permissaoPessoaService;



        public Pessoa registrarCliente(PessoaClienteRequestDTO pessoaClienteRequestDTO){
            Pessoa pessoa = new PessoaClienteRequestDTO().convert(pessoaClienteRequestDTO);
            pessoa.setDataCriacao(new Date());
            Pessoa newPessoa = pessoaClienteRepository.saveAndFlush(pessoa);
            permissaoPessoaService.vincularPessoaPermissaoCliente(newPessoa);
            return newPessoa;
        }



}
