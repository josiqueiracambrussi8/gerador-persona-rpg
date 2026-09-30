package controller;

import java.awt.event.*;
import java.util.*;

import model.PersonagemModel;
import view.PersonagemView;

public class PersonagemController {
    private PersonagemView view;

    public PersonagemController(PersonagemView view){
        this.view = view;
                            //actionListener: Espera uma ação acontecer, quando acontece declara o q deve ser feito
    this.view.getBtnCriar().addActionListener(new ActionListener(){
        //Override:classe resecreve metodo de classe :)
        @Override         //actionPerformed: metodo do ActionListener q é chamado quando a ação acontece
                            //ActionEvent: Representa o evento em si. Carrega inofs da ação que foi realizada.
            public void actionPerformed(ActionEvent e){
        criarPersonagem();
}
    });

    this.view.getBtnApagar().addActionListener(new ActionListener() {
         //Override:classe resecreve metodo de classe 
        @Override         //actionPerformed: metodo do ActionListener q é chamado quando a ação acontece
                            //ActionEvent: Representa o evento em si. Carrega inofs da ação que foi realizada.
            public void actionPerformed(ActionEvent e){
        view.limparAreas();        
    }
    });
    }

    //PRIVATE pois é um método de uso exclusivo dessa classe, as outras classes não precisam ou devem chamar esse método diretamente :)
    private void criarPersonagem(){
        String nome = view.getNome();
        String classe = view.getClasse();
        String dificuldade = view.getDificuldade();
        ArrayList<String> habilidade = view.getHabilidades();
        int nivel = view.getNivel();

        //instancia do model com os dados recolhidos
        PersonagemModel model = new PersonagemModel(nome, classe, dificuldade, habilidade, nivel);

        //O Model devolve uma lista de textos (por exemplo: ["Ataque Forte", "Esquiva"]). O método String.join junta todos os elementos
        //dessa lista numa única String, colocando ", " entre cada item.
        String listaHabilidades = String.join(", ", model.getHabilidade());

        StringBuilder resumo = new StringBuilder();
        resumo.append("SEU PERSONAGEM\n");
        resumo.append("----------------------------------\n");
        //nome
        resumo.append("Nome: ");
        resumo.append(model.getNome());
        resumo.append("\n");
        //classe
        resumo.append("Classe: ");
        resumo.append(model.getClasse());
        resumo.append("\n");
        //dificuldade
        resumo.append("Dificuldade: ");
        resumo.append(model.getDificuldade());
        resumo.append("\n");
        //habilidade
        resumo.append("Habilidade: ");
        resumo.append(listaHabilidades);
        resumo.append("\n");
        //nivel
        resumo.append("Nivel: ");
        resumo.append(model.getNivelInicial());
        resumo.append("\n");

        //transforma o StringBuilder em String para o attResumo que é String
        view.attResumo(resumo.toString());
    }



}
