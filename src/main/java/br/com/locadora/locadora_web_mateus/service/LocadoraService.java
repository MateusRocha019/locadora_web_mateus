package br.com.locadora.locadora_web_mateus.service;

import br.com.locadora.locadora_web_mateus.model.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    //Contém as regras de negócio da locadora
@Service //Faz o spring criar e gerenciar o objeto
public class LocadoraService{
    private final List<Filme> filmes; //Declara a lista que guarda os filmes na memória
    private int proximoCodigoFilme; //Ele guarda o próximo código automaticamente.

    public LocadoraService(){
        filmes = new ArrayList<>(); //Cria uma lista vazia
        proximoCodigoFilme = 1;
    }

    public void cadastrarFilme(Filme filme){
        filme.setCodigo(proximoCodigoFilme);
        proximoCodigoFilme++;
        filmes.add(filme);
    }

    public List<Filme>listarFilmes(){
        return new ArrayList<>(filmes); //Cria uma cópia da lista para proteger a lista interna
    }

    public Filme buscaFilmePorCodigo(int codigo){
        for (Filme filme: filmes) {//Percorre cada objeto da lista um por vez
            if (filme.getCodigo() == codigo) {
                return filme;
            }
        }
        return null;
    }
}

