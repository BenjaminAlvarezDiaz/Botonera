package boton_y_etiqueta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BotonYEtiqueta extends JFrame{

    private JButton botonP;
    private JButton botonG;
    private JPanel panelImagen;
    private JPanel panelBotones;
    private JLabel etiqueta;

    public BotonYEtiqueta(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLayout(new BorderLayout());

        armarPanelImagen();
        armarPanelBotones();

        panelImagen.add(etiqueta);
        panelBotones.add(botonP);
        panelBotones.add(botonG);

        getContentPane().add(panelImagen, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
        
    }

    private void armarPanelImagen(){
        etiqueta = new JLabel();
        panelImagen = new JPanel();
        etiqueta.setIcon(new ImageIcon("imagenes/Perro.jpg"));
        panelImagen.add(etiqueta);
        
    }

    private void armarPanelBotones(){
        Oyente oyente = new Oyente();

        panelBotones = new JPanel();
        botonP = new JButton("Perro");
        botonG = new JButton("Gato");
        
        botonP.addActionListener(oyente);
        botonG.addActionListener(oyente);

        panelBotones.add(botonP);
        panelBotones.add(botonG);
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
