package botonera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Botonera extends JFrame{
    private JPanel panelBotones;
    private JButton[] botones;
    private Oyente oyente;

    public Botonera(){
        this.botones = new JButton[5];
        this.panelBotones = new JPanel();
        this.oyente = new Oyente();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400,200);

        armarBotonera();
        getContentPane().add(panelBotones);
    }

    public void armarBotonera(){
        for(int i = 0; i<botones.length; i++){
            botones[i] = new JButton();
            botones[i].setText("" + i);
            botones[i].setBackground(Color.WHITE);
            botones[i].addActionListener(oyente);
            panelBotones.add(botones[i]);
        }
    }

    public class Oyente implements ActionListener{

        public Oyente(){

        }

        public void actionPerformed(ActionEvent evento){
            JButton b = (JButton)evento.getSource();
            b.setBackground(Color.RED);
            b.setText("OK");

        }

    }
}
