package br.com.projeto.avaliadorfilmes.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.avaliadorfilmes.modelo.Filme;
import br.com.projeto.avaliadorfilmes.modelo.Mensagem;
import br.com.projeto.avaliadorfilmes.repositorio.Repositorio;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    public ResponseEntity<?> selecionarPeloId(int id){
        if(acao.countById(id) == 0 ){
            mensagem.setMensagem("Não foi encontrado nenhum filme.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findById(id), HttpStatus.OK);
        }
    }

  public ResponseEntity<?> remover(int id){
   
    Filme filme = acao.findById(id);
    acao.delete(filme);
    mensagem.setMensagem("Filme removido com sucesso.");
    return new ResponseEntity<>(mensagem, HttpStatus.OK);
  }

    public ResponseEntity<?> avaliarFilme(Filme filme){

        //if(acao.countByCodigo(filme.getId()));

       return null;
    }
    
}
