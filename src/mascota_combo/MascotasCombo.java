package mascota_combo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MascotasCombo extends JFrame{

    private JLabel etiqueta;
    private JComboBox comboMascotas;
    private JPanel panelImagen;
    private JPanel panelCombo;

    public MascotasCombo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new FlowLayout());
        //setLayout(new BorderLayout());

        armarPanelImagen();
        armarPanelCombo();

        getContentPane().add(panelImagen);
        getContentPane().add(panelCombo);

    }

    private void armarPanelImagen(){
        panelImagen = new JPanel();
        etiqueta = new JLabel();
        etiqueta.setIcon(new ImageIcon("imagenes/perro.jpg"));
        panelImagen.add(etiqueta);
    }

    private void armarPanelCombo(){
        String[] mascotas = {"Perro", "Gato", "Conejo", "Pato", "Cerdo"};
        comboMascotas = new JComboBox(mascotas);
        comboMascotas.setSelectedIndex(0);
        Oyente oyente = new Oyente();
        comboMascotas.addItemListener(oyente);
        panelCombo = new JPanel();
        panelCombo.add(comboMascotas);
    }

    public class Oyente implements ItemListener{
        public void itemStateChanged(ItemEvent evento){
            JComboBox item = (JComboBox)evento.getSource();
            String valor = item.getSelectedItem().toString();
            etiqueta.setIcon(new ImageIcon("imagenes/" + valor + ".jpg"));
        }
    }

    
}
