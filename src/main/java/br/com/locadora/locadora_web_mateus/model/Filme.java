package br.com.locadora.locadora_web_mateus.model;

//Representa um filme cadastrado na locadora
public class Filme {


    private int codigo;
    private String nome;
    private String genero;
    private boolean alugado;

    public Filme(){
        this.alugado = false;
    }

    public Filme(int codigo, String nome, String genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.alugado = false;
    }

    public int getCodigo() {
        return codigo;
    }
    //Permite Definer o código altomático no services
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    //Permite ler e alterar o nome
    public String getNome(){
        return nome;
    }
    //Faria a alteração do nome
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getGenero(String genero){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public boolean isAlugado(){
        return alugado;
    }
    //Vai alterar o estado do filme
    public void alugar(){
        if(alugado){
            throw new IllegalAccessException("Filme já alugado");
        }
        alugado = true;
    }
    public void devolver(){
        alugado = false;
    }
    @Override
    public String toString(){
        String status = alugado ? "Alugado": "Disponivél";
        return "Código: " + codigo
                + "|Nome: " + nome
                + "|Gênero: " + genero
                + "|Status: " + status;
    }
}
