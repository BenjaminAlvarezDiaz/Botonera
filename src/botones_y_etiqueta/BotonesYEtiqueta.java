package botones_y_etiqueta;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BotonesYEtiqueta extends JFrame{

    private JLabel etiqueta;
    private JButton[] botones;
    private JPanel panelEtiqueta;
    private JPanel panelBotones;

    public BotonesYEtiqueta(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,400);
        setLayout(new BorderLayout());

        armarPanelEtiqueta();
        armarPanelBotones();

        getContentPane().add(panelEtiqueta, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    private void armarPanelEtiqueta(){
        etiqueta = new JLabel();
        panelEtiqueta = new JPanel();
        etiqueta.setIcon(new ImageIcon("imagenes/perro.jpg"));
        panelEtiqueta.add(etiqueta);
    }

    private void armarPanelBotones(){
        String[] mascota = {"Perro", "Gato", "Conejo", "Pato", "Cerdo"};
        botones = new JButton[5];
        panelBotones = new JPanel();
        Oyente oyente = new Oyente();

        for(int i=0; i<botones.length; i++){
            botones[i] = new JButton(mascota[i]);
            botones[i].setPreferredSize(new Dimension(100, 30));
            botones[i].setBorder(
                new TitledBorder(
                    new LineBorder(
                        Color.BLACK,
                        4, 
                        true
                        ),
                        ""
                    )
                );

            botones[i].addActionListener(oyente);
            panelBotones.add(botones[i]);

        }

    }

    public class Oyente implements ActionListener{

        public Oyente(){

        }

        public void actionPerformed(ActionEvent evento){
            String valor = (String) evento.getActionCommand();
            etiqueta.setIcon(new ImageIcon("imagenes/" + valor + ".jpg"));
        }
    }

    
}
