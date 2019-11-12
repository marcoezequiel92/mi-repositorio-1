
package Ahorcado;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelBorder extends TitledBorder {
    public PanelBorder(Color color, String nombre){super(new LineBorder(color),nombre);}
    public PanelBorder(Color color, Color letra, String nombre){
        super(new LineBorder(color),nombre);
        super.setTitleColor(letra);
    }
    public PanelBorder(Color color, int ancho, String nombre){
        super(new LineBorder(color,ancho),nombre);
    }
    public PanelBorder(Color color, Color letra, int ancho, String nombre){
        super(new LineBorder(color, ancho),nombre);
        super.setTitleColor(letra);
    }
    public PanelBorder(Color color, int ancho, int posicion, String nombre){
        super(new LineBorder(color,ancho),nombre);
        super.setTitleJustification(posicion);
    }
    public PanelBorder(Color color, Color letra, int ancho, int posicion, String nombre){
        super(new LineBorder(color,ancho),nombre);
        super.setTitleColor(letra);
        super.setTitleJustification(posicion);
    }
    public static void main(String[]args){
        JPanel generico = new JPanel();
        JFrame principal = new JFrame("VENTANA");
        generico.setBorder(new PanelBorder(Color.GREEN,6,TitledBorder.CENTER,"panel"));
        principal.setContentPane(generico);
        principal.pack();
        principal.setVisible(true);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
