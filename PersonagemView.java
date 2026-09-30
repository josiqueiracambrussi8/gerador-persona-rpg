package view;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class PersonagemView extends JFrame {
    //atributos interface
    private JTextField nome;
    private JComboBox classe;
    private JRadioButton rbFacil, rbMedio, rbDificil;
    private ButtonGroup selecaoDif;// só permite selecionar um
    private JCheckBox ckbMagia, ckbCura, ckbFutividade, ckbForca;
    private JSlider nivelInicial;
    private JTextArea resumo;
    private JButton btnCriar, btnApagar;

    public PersonagemView(){
        setTitle("Gerador de Personagem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750,480);
        setLocationRelativeTo(null);// deixa no centro
        setLayout(new GridLayout(1, 2, 10, 10));// 1 linha, duas colunas, 10 espaços em branco na horizontal, 10 espaços em branco na vertical

        //painel esquerdo
        JPanel painelEsquerdo = new JPanel();
                        //seta bordas           cria uma borda com titulo
        painelEsquerdo.setBorder(BorderFactory.createTitledBorder("Crie seu personagem"));
        painelEsquerdo.setLayout(null);

        //nome
        JLabel jlNome = new JLabel("Nome:");
        jlNome.setBounds(15, 25, 140, 25);//seta tamanho, x y largura altura
        painelEsquerdo.add(jlNome);

        nome = new JTextField();
        nome.setBounds(155, 25, 190, 25);//seta tamanho, x y largura altura
        painelEsquerdo.add(nome);

        //classe
        JLabel jlClasse = new JLabel("Classes:");
        jlClasse.setBounds(15, 60, 100, 25);//seta tamanho, x y largura altura
        painelEsquerdo.add(jlClasse);

        String[] classes = {"Mago", "Guerreiro", "Ladino", "Bardo"};
        classe = new JComboBox<>(classes);
        classe.setBounds(155, 60, 190, 25);//seta tamanho, x y largura altura
        painelEsquerdo.add(classe);

        //dificuldade
        JPanel painelDificuldade = new JPanel();//seta borda e cria borda com nome
        painelDificuldade.setBorder(BorderFactory.createTitledBorder("Dificuldade:"));
        painelDificuldade.setLayout(new GridLayout(3, 1));//3 linhas, 1 coluna
        painelDificuldade.setBounds(15, 95, 150, 100);//seta tamanho, x y largura altura

        rbFacil = new JRadioButton("Fácil");
        rbMedio = new JRadioButton("Médio");
        rbDificil = new JRadioButton("Difícil");
        selecaoDif = new ButtonGroup();//faz com q só um possa ser selecionado
        selecaoDif.add(rbFacil);
        selecaoDif.add(rbMedio);
        selecaoDif.add(rbDificil);
        painelDificuldade.add(rbFacil);
        painelDificuldade.add(rbMedio);
        painelDificuldade.add(rbDificil);
        painelEsquerdo.add(painelDificuldade);

        //habilidade
        JPanel painelHabilidades = new JPanel();//seta borda cria borda com titulo
        painelHabilidades.setBorder(BorderFactory.createTitledBorder("Habilidades:"));
        painelHabilidades.setLayout(new GridLayout(4, 1));//4 linhas, 1 coluna
        painelHabilidades.setBounds(180, 95, 165, 115);//seta tamanho, x y largura altura

        ckbMagia = new JCheckBox("Magia");
        ckbCura = new JCheckBox("Cura");
        ckbFutividade = new JCheckBox("Furtividade");
        ckbForca = new JCheckBox("Força");
        painelHabilidades.add(ckbMagia);
        painelHabilidades.add(ckbCura);
        painelHabilidades.add(ckbFutividade);
        painelHabilidades.add(ckbForca);
        painelEsquerdo.add(painelHabilidades);

        //nivel inicial
        JLabel jlNvInicial = new JLabel("Nível Inicial:");
        jlNvInicial.setBounds(15, 215, 100, 20);//seta tamanho, x y largura altura
        painelEsquerdo.add(jlNvInicial);

                                //valor mínimo, máximo e inicial
        nivelInicial = new JSlider(1, 10, 1);
                                //espaçamento de 1 em 1
        nivelInicial.setMajorTickSpacing(1);
                                //mostrar os tracinhos acima dos números
        nivelInicial.setPaintTicks(true);
                                // mostrar os números 1-10
        nivelInicial.setPaintLabels(true);
        nivelInicial.setBounds(15, 235, 260, 45);
        painelEsquerdo.add(nivelInicial);

        //botões
        btnCriar = new JButton("Criar Personagem ;)");
        btnCriar.setBounds(25, 310, 150, 35);//seta tamanho, cansei d digitar a mesma coisa 
        painelEsquerdo.add(btnCriar);

        btnApagar = new JButton("Apagar Personagem :(");
        btnApagar.setBounds(185, 310, 130, 35);//seta tamanho
        painelEsquerdo.add(btnApagar);
        //fim painel esquerdo

        //painel direito
        JPanel painelDireito = new JPanel();// ja sabe 
        painelDireito.setBorder(BorderFactory.createTitledBorder("Resumo do Personagem"));
        painelDireito.setLayout(new BorderLayout());//organiza as regiões da tela em norte, sul, leste, oeste e centro

        resumo = new JTextArea();
        resumo.setFont(new Font("Monospaced", Font.PLAIN, 13));//fonte da letra, nome. tipo e tamanho
        resumo.setEditable(false);//não da pra editar
                                            //A região CENTER é especial:
                //ela expande-se automaticamente para preencher todo o espaço disponível que sobrou na janela
        painelDireito.add(resumo, BorderLayout.CENTER);

        add(painelEsquerdo);
        add(painelDireito);
    }

    public String getNome(){
        return nome.getText();
    }
    public String getClasse(){
        return classe.getSelectedItem().toString();//converte para string
    }
    
    public String getDificuldade(){
        if(rbFacil.isSelected()){
            return "Fácil";
        }else if(rbMedio.isSelected()){
            return "Médio";
        }else if(rbDificil.isSelected()){
            return "Difícil";
        }else {
            return "Não infromado";
        }
    }

    public ArrayList<String> getHabilidades(){
        ArrayList<String> listaHabilid = new ArrayList<>();
        if(ckbMagia.isSelected()){
            listaHabilid.add("Magia");
        }if(ckbCura.isSelected()){
            listaHabilid.add("Cura");
        }if(ckbFutividade.isSelected()){
            listaHabilid.add("Futividade");
        }if(ckbForca.isSelected()){
            listaHabilid.add("Força");
        }
        return listaHabilid;
    }

    public int getNivel(){
        return nivelInicial.getValue();
    }

    public JButton getBtnCriar(){
        return btnCriar;
    }
    public JButton getBtnApagar(){
        return btnApagar;
    }

    public void attResumo(String texto){
        resumo.setText(texto);
    }

    public void limparAreas(){
        nome.setText("");
        classe.setSelectedIndex(0);
        selecaoDif.clearSelection();
        ckbMagia.setSelected(false);
        ckbCura.setSelected(false);
        ckbFutividade.setSelected(false);
        ckbForca.setSelected(false);
        nivelInicial.setValue(1);
        resumo.setText("");

    }
}