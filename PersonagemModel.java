package model;

import java.util.ArrayList;

public class PersonagemModel {
    private String nome;
    private String classe;
    private String dificuldade;
    private ArrayList<String> habilidade;
    private int nivelInicial;
    
    public PersonagemModel(String nome, String classe, String dificuldade, ArrayList<String> habilidade, int nivelInicial) {
        this.nome = nome;
        this.classe = classe;
        this.dificuldade = dificuldade;
        this.habilidade = habilidade;
        this.nivelInicial = nivelInicial;
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public ArrayList<String> getHabilidade() {
        return habilidade;
    }

    public int getNivelInicial() {
        return nivelInicial;
    }
}
