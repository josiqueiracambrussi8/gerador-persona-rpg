package view;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class PersonagemView extends JFrame {
    
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
        setLayout(null);

        //painel esquerdo
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setBorder(BorderFactory.createTitledBorder("Crie seu personagem"));
        painelEsquerdo.setLayout(null);

        //nome
        JLabel jlNome = new JLabel("Nome:");
        jlNome.setBounds(15, 25, 140, 25);
        painelEsquerdo.add(jlNome);

        nome = new JTextField();
        nome.setBounds(155, 25, 190, 25);
        painelEsquerdo.add(nome);

        //classe
        JLabel jlClasse = new JLabel("Classes:");
        jlClasse.setBounds(15, 60, 100, 25);
        painelEsquerdo.add(jlClasse);

        String[] classes = {"Mago", "Guerreiro", "Ladino", "Bardo"};
        classe = new JComboBox<>();
        classe.setBounds(155, 60, 190, 25);
        painelEsquerdo.add(classe);

        //dificuldade
        JPanel painelDificuldade = new JPanel();
        painelDificuldade.setBorder(BorderFactory.createTitledBorder("Dificuldade:"));
        painelDificuldade.setLayout(null);
        painelDificuldade.setBounds(15, 95, 150, 100);

        rbFacil = new JRadioButton("Fácil");
        rbMedio = new JRadioButton("Médio");
        rbDificil = new JRadioButton("Difícil");
        selecaoDif = new ButtonGroup();
        selecaoDif.add(rbFacil);
        selecaoDif.add(rbMedio);
        selecaoDif.add(rbDificil);
        painelDificuldade.add(rbFacil);
        painelDificuldade.add(rbMedio);
        painelDificuldade.add(rbDificil);
        painelEsquerdo.add(painelDificuldade);

        //habilidade
        JPanel painelHabilidades = new JPanel();
        painelHabilidades.setBorder(BorderFactory.createTitledBorder("Habilidades:"));
        painelDificuldade.setLayout(null);
        painelDificuldade.setBounds(180, 95, 165, 115);

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
        jlNvInicial.setBounds(15, 215, 100, 20);
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
        btnCriar.setBounds(25, 310, 150, 35);
        painelEsquerdo.add(btnCriar);

        btnApagar = new JButton("Apagar Personagem :(");
        btnApagar.setBounds(185, 310, 130, 35);
        painelEsquerdo.add(btnApagar);
        //fim painel esquerdo

        //painel direito
        JPanel painelDireito = new JPanel();
        painelDireito.setBorder(BorderFactory.createTitledBorder("Resumo do Personagem"));
        painelDireito.setLayout(null);

        resumo = new JTextArea();
        resumo.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resumo.setEditable(false);
                                            //A região CENTER é especial:
                //ela expande-se automaticamente para preencher todo o espaço disponível que sobrou na janela
        painelDireito.add(resumo, BorderLayout.CENTER);

        add(painelEsquerdo);
        add(painelDireito);
    }

    
    
}
