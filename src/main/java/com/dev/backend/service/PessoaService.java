    package com.dev.backend.service;

    import java.util.Date;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import com.dev.backend.entity.Pessoa;
    import com.dev.backend.repository.PessoaRepository;

    @Service
    public class PessoaService {
        
        @Autowired
        private PessoaRepository pessoaRepository;

        /*
         * Name Services
         */
        @SuppressWarnings("null")
        public Pessoa insertName(Pessoa obj){
            if (obj == null) {
                System.err.println("O espaço nome está vazio.");
            }
            try {
                obj.setDataCriacao(new Date());
                return pessoaRepository.saveAndFlush(obj); 
                }
            catch (Exception e) {
                System.err.println("Erro ao inserir nome:"+ e.getMessage());
            }
            return null;
        }

        @SuppressWarnings("null")
        public Pessoa updateName(Pessoa obj){
            if (obj == null) {
                System.err.println("O espaço nome está vazio.");
            }
            try {
                obj.setDataUpDate(new Date());
                return pessoaRepository.saveAndFlush(obj);
            } catch (Exception e) {
                System.err.println("Erro ao atualizar nome:" + e.getMessage());
            }
            return null;
        }

        public List <Pessoa> findAll(){
            try {
                return pessoaRepository.findAll();
            } catch (Exception e) {
                System.err.println("Erro ao buscar usuários");
            }
            return null;
        }

        @SuppressWarnings("null")
        public void deleteName(Long id){
            Pessoa pessoa = pessoaRepository.findById(id).get();
            pessoaRepository.delete(pessoa);
        }

}
