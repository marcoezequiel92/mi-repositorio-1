
package Ahorcado;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;

public class Instrucciones implements ActionListener {
    private JTextArea textArea;
    private JFrame frame;
    private JPanel panel;
    private JButton aceptar;
    public Instrucciones(){
        Inicializa();
        InputStream in = getClass().getResourceAsStream("/recursos/instrucciones.txt");
        try{
            textArea.read(new InputStreamReader(in),null);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void Inicializa(){
        frame = new JFrame("Instrucciones");
        panel = new JPanel();
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("",Font.BOLD,12));
    }
    public void Agrega(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(textArea);
        panel.add(aceptar);
    }
    public void Decora(){
        panel.setBackground(Color.ORANGE);
        panel.setBorder(new PanelBorder(Color.BLACK, Color.WHITE,5,TitledBorder.CENTER,""));       
    }
    public JPanel getPanel(){
        return panel;
    }
    public void actionPerformed(ActionEvent e){
        frame.setVisible(false);
    }
    public JFrame getFrame(){
        JPanel temp = (JPanel)frame.getContentPane();
        temp.add(getPanel());
        frame.setVisible(true);
        frame.setSize(800,350);
        frame.setLocationRelativeTo(null);
        Agrega();
        Decora();
        return frame;
    }
    public static void main(String[]args){
        Instrucciones nuevo = new Instrucciones();
        JDialog prueba = new JDialog(nuevo.getFrame());
    }
    
}
