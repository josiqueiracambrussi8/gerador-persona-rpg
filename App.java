import javax.swing.*;

import controller.PersonagemController;
import view.PersonagemView;


public class App {
    public static void main(String[] args) throws Exception {
        //SwingUtilities.invokeLater: "Agendador" de tarefas do Swing. ele diz ao java "Não execute isso agora na thread main.
        //  Coloca este código e executa-o dentro da thread da interface gráfica assim que ela estiver livre"

        //Runnable: Bloco de código que pode ser executado. O pacote enviado para a thread
        //Run: Todo código Run será executado. O conteúdo do pacote
        SwingUtilities.invokeLater(new Runnable() {
            @Override 
            public void run(){
                PersonagemView view = new PersonagemView();

                PersonagemController controller = new PersonagemController(view);

                view.setVisible(true);//torna visivel
            }
        });
    }
}
