package radio_buttons_e_imagen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImagenYRadioButn extends JFrame{

    private JPanel panelImagen;
    private JPanel panelBotones;
    
    private ButtonGroup grupoBotones;
    private JRadioButton[] botones;
    private JLabel etiqueta;

    public ImagenYRadioButn(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        armarPanelImagen();
        armarPanelBotones();
        
        getContentPane().add(panelImagen, BorderLayout.WEST);
        getContentPane().add(panelBotones, BorderLayout.EAST);
    }

    private void armarPanelImagen(){
        etiqueta = new JLabel();
        panelImagen = new JPanel();
        etiqueta.setIcon(new ImageIcon("imagenes/perro.jpg"));
        panelImagen.add(etiqueta);
    }

    private void armarPanelBotones(){
        Oyente oyente = new Oyente();
        String[] mascotas = {"Perro", "Gato", "Conejo", "Pato", "Cerdo"};
        grupoBotones = new ButtonGroup();
        botones = new JRadioButton[5];
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5,1));
        for(int i=0; i<botones.length; i++){
            botones[i] = new JRadioButton(mascotas[i]);
            botones[i].setPreferredSize(new Dimension(100, 30));
            botones[i].addItemListener(oyente);
            grupoBotones.add(botones[i]);
            panelBotones.add(botones[i]);
        }

    }

    public class Oyente implements ItemListener{

        public Oyente(){

        }

        public void itemStateChanged(ItemEvent evento){
            JRadioButton radio = (JRadioButton)evento.getSource();
            String valor = radio.getText();
            System.out.println(valor);
            etiqueta.setIcon(new ImageIcon("imagenes/" + valor + ".jpg"));
        }
    }

}
