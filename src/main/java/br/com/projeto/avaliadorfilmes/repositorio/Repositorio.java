package br.com.projeto.avaliadorfilmes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.avaliadorfilmes.modelo.Filme;

@Repository
public interface Repositorio extends CrudRepository<Filme, Integer>{
    
    List<Filme> findAll();

    Filme findById(int id);

    List<Filme> findByAvaliacao(double nota);
    
    int countById(int id);
}