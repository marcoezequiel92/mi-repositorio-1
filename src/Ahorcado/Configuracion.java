
package Ahorcado;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Configuracion implements ActionListener, ItemListener {
    private JFrame frame;
    private JPanel panel;
    private JCheckBox facil;
    private JCheckBox normal;
    private JCheckBox dificil;
    private JCheckBox muyDificil;
    private JComboBox temas;
    private JButton aceptar;
    private EscuchaBoton escucha;
    private String[] configuracion;
    private String[] opcionTemas = {"Arte","Ciencia","Deportes","Musica","Personajes","Tecnologia","Programacion","Otros"};
    JPanel temp = new JPanel();
    
    public Configuracion(){
        panel = new JPanel();
        facil = new JCheckBox("Facil");
        normal = new JCheckBox("Normal");
        normal.setSelected(true);
        dificil = new JCheckBox("Dificil");
        muyDificil = new JCheckBox("Muy Dificil");
        aceptar = new JButton("Aceptar");
        temas = new JComboBox(opcionTemas);
        configuracion = new String[2];
        frame = new JFrame("Opciones");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    public JPanel getPanelFrame(){
        return panel;
    }
    public void Opciones(){
        temp.setBackground(Color.BLACK);
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        temp.add(facil);
        temp.add(normal);
        temp.add(dificil);
        temp.add(muyDificil);
        panel.add(temas, BorderLayout.NORTH);
        panel.add(temp,BorderLayout.CENTER);
        panel.add(aceptar,BorderLayout.SOUTH);
    }
    public void Decora(){
        facil.setBackground(Color.BLACK);
        normal.setBackground(Color.BLACK);
        dificil.setBackground(Color.BLACK);
        muyDificil.setBackground(Color.BLACK);
        panel.setBackground(Color.BLACK);
        facil.setForeground(Color.WHITE);
        normal.setForeground(Color.WHITE);
        dificil.setForeground(Color.WHITE);
        muyDificil.setForeground(Color.WHITE);
        panel.setForeground(Color.WHITE);
        panel.setBorder(new PanelBorder(Color.WHITE, Color.BLACK,5,TitledBorder.CENTER,""));
    }
    public void Escuchadores(){
        ValoresDefecto();
        escucha = new EscuchaBoton();
        aceptar.addActionListener(new EscuchaBoton());
        temas.addActionListener(this);
        facil.addItemListener(this);
        normal.addItemListener(this);
        dificil.addItemListener(this);
        muyDificil.addItemListener(this);      
    }
    public void actionPerformed(ActionEvent e){
        JComboBox cb = (JComboBox)e.getSource();
        configuracion[0]=(String)cb.getSelectedItem();
        System.out.println(toString());
    }
    public void itemStateChanged(ItemEvent e){
        Object source = e.getItemSelectable();
        if(source == facil){
            configuracion[1] = "facil";
            normal.setSelected(false);
            dificil.setSelected(false);
            muyDificil.setSelected(false);
        }else if(source == normal){
            configuracion[1] = "normal";
            normal.setSelected(false);
            dificil.setSelected(false);
            muyDificil.setSelected(false);
        }else if(source == dificil){
            configuracion[1] = "dificil";
            normal.setSelected(false);
            dificil.setSelected(false);
            muyDificil.setSelected(false);
        }else{
            configuracion[1] = "muy dificil";
            normal.setSelected(false);
            dificil.setSelected(false);
            muyDificil.setSelected(false);
            
        }
        System.out.println(toString());
    }
    public class EscuchaBoton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
        }
    }
    public String[]getConfiguracion(){
        return configuracion;
    }
    public void ForzarCierre(){
        System.exit(1);
    }
    public String toString(){
        String temp = "";
        for(int i=0;i<configuracion.length;i++){
            temp += configuracion[i]+ "";
        }
        return temp;
    }
    public void ValoresDefecto(){
        configuracion[0] = "Arte";
        configuracion[1] = "Normal";
    }
    public JFrame getFrame(){
        JPanel temp = (JPanel)frame.getContentPane();
        temp.add(getPanelFrame());
        frame.setVisible(true);
        frame.setSize(200,200);
        Decora();
        Opciones();
        Escuchadores();
        frame.setLocationRelativeTo(null);
        return frame;        
    }
    
    
}
