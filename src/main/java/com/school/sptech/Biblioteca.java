package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public String getNome() {
        return nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Biblioteca(String nome, Double multaDiaria){
        this.qtdLivros = 0;
        this.ativa = true;
        this.nome = nome;
        this.multaDiaria = multaDiaria;
    }

    public void registrarLivro(Integer quantidade){
        if(quantidade != null && quantidade > 0 && ativa == true){
            qtdLivros = qtdLivros + quantidade;
        }
    }
    public Integer emprestar(Integer quantidade){
        if (quantidade == null || quantidade <= 0 || !ativa || qtdLivros < quantidade) {
            return null;
        }else {
            qtdLivros -= quantidade;
            return quantidade;
        }
    }

    public Integer devolver(Integer quantidade){
        if (quantidade == null || quantidade <= 0 || !ativa) {
            return null;
        }else{
        qtdLivros += quantidade;
        return quantidade;
        }
    }
    public Integer desativar(){
        if(ativa == false){
            return null;
        }else {
            var quantidade = qtdLivros;
            qtdLivros = 0;
            ativa = false;
            return quantidade;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if(destino.ativa == true && ativa == true && quantidade != null && quantidade > 0  && quantidade <= qtdLivros){
            qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual == null || percentual <= 0){
            return false;
        }else{
            multaDiaria = multaDiaria * (1+percentual);
            return true;
        }
    }
}
