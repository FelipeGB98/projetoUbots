package br.com.projeto.avaliadorfilmes.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.avaliadorfilmes.modelo.Filme;
import br.com.projeto.avaliadorfilmes.repositorio.Repositorio;
import br.com.projeto.avaliadorfilmes.servico.Servico;

@RestController
public class Controle {

  @Autowired
  private Repositorio filmeRepository; //filmeRepository eh responsavel por selecionar, cadastrar, alterar e excluir

  @Autowired
  private Servico servico;  

  @PostMapping("/cadastrarfilme")
  public Filme criarFilme(@RequestBody Filme filme) {
  return filmeRepository.save(filme); // INSERT
  }

  @PutMapping("/{id}")
  public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
      filme.setId(id);
      return filmeRepository.save(filme);
  }

  @GetMapping("/filmes")
  public List<Filme> pesquisar(){
    return filmeRepository.findAll();
  }

  @GetMapping("/filmessemnota")
  public List<Filme> pesquisarSemNota(){
    return filmeRepository.findByAvaliacao(0);
  }

  @GetMapping("/filmes/{id}")
  public ResponseEntity<?> seleicionarPeloId(@PathVariable int id){
    return servico.selecionarPeloId(id);
  } 

  @PutMapping("/filmes")
  public Filme editar(@RequestBody Filme filme){
    return filmeRepository.save(filme);
  }

  @DeleteMapping("/filmes/{id}")
  public ResponseEntity<?> remover(@PathVariable int id){
    return servico.remover(id);
  }

  @PostMapping("/avaliarfilme")
  public Filme avaliarFilme(@RequestBody Filme filme) {
    return filmeRepository.save(filme);
}




}
