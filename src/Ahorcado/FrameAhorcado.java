package Ahorcado;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

public class FrameAhorcado extends JFrame implements ActionListener {

    private Compara palabras;
    private String recoge, evento;
    private JPanel muestra;
    private JPanel principal;
    private JTextField palabra;
    private JTextField solucion;
    private JPanel contenedorDibujo;
    private JPanel dibujoInicial;
    private JPanel opcionInicial;
    private JLabel dibujo;
    private JButton[] botones;
    private int oportunidades = 0;
    private char iguales = '$';
    private JFrame aux;
    private JButton iniciar;
    private JButton opciones;
    private JButton instrucciones;
    private JButton creditos;
    private boolean bloquea = false;
    private Configuracion op;
    private Instrucciones ins;
    private Creditos cre;
    private String[] configuracion;
    private JButton menuPrincipal;

    public FrameAhorcado() {
        palabras = new Compara();
        iniciar = new JButton("INICIAR AHORCADO");
        opciones = new JButton("OPCIONES");
        instrucciones = new JButton("INSTRUCCIONES");
        creditos = new JButton("CREDITOS");
        iniciar.setForeground(Color.WHITE);
        opciones.setForeground(Color.WHITE);
        instrucciones.setForeground(Color.WHITE);
        creditos.setForeground(Color.WHITE);
        iniciar.setBackground(Color.BLACK);
        opciones.setBackground(Color.BLACK);
        instrucciones.setBackground(Color.BLACK);
        creditos.setBackground(Color.BLACK);
        iniciar.setFocusPainted(false);
        opciones.setFocusPainted(false);
        instrucciones.setFocusPainted(false);
        creditos.setFocusPainted(false);
        iniciar.addActionListener(this);
        opciones.addActionListener(this);
        instrucciones.addActionListener(this);
        creditos.addActionListener(this);
        opcionInicial = new JPanel();
        opcionInicial.setLayout(new GridLayout(2, 2));
        opcionInicial.add(iniciar);
        opcionInicial.add(opciones);
        opcionInicial.add(instrucciones);
        opcionInicial.add(creditos);
        JLabel imagenInicio = new JLabel(new ImageIcon(getClass().getResource("/recursos/simpson.jpg")));
        dibujoInicial = new JPanel();
        dibujoInicial.setBackground(Color.BLACK);
        dibujoInicial.add(imagenInicio);
        op = new Configuracion();
        op.ValoresDefecto();
        principal = (JPanel) super.getContentPane();
        principal.add(opcionInicial, BorderLayout.NORTH);
        principal.add(dibujoInicial, BorderLayout.CENTER);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("Juego del ahorcado");
        super.setSize(470, 700);
        super.setResizable(false);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
    }

    public void Panel() {
        palabras.ResetGana();
        oportunidades = 0;
        Limpia();
        palabras.NuevaPalabra(configuracion[0]);
        principal = (JPanel) super.getContentPane();
        principal.setBackground(Color.BLACK);
        principal.setOpaque(true);
        principal.setBorder(new PanelBorder(Color.BLACK, Color.WHITE, ""));
        principal.setLayout(new GridLayout(2, 0));
        principal.add(ZonaJuego());
        principal.add(Teclado());
    }

    public void MenuPrincipal() {
        Limpia();
        principal = (JPanel) super.getContentPane();
        opcionInicial.setLayout(new GridLayout(2, 2));
        opcionInicial.add(iniciar);
        opcionInicial.add(opciones);
        opcionInicial.add(instrucciones);
        opcionInicial.add(creditos);
        JLabel imagenInicio = new JLabel(new ImageIcon(getClass().getResource("/recursos/simpson.jpg")));
        dibujoInicial.add(imagenInicio);
        principal.add(opcionInicial);
        principal.add(dibujoInicial);
        super.setVisible(true);
    }

    public void NuevaPartida() {
        Panel();
        System.out.println("NUEVA PARTIDA");
    }

    public JPanel ZonaJuego() {
        JPanel juego = new JPanel();
        menuPrincipal = new JButton("VOLVER AL MENU");
        menuPrincipal.setFocusPainted(false);
        menuPrincipal.setBackground(Color.BLACK);
        menuPrincipal.setForeground(Color.WHITE);
        menuPrincipal.addActionListener(this);
        juego.setBackground(Color.BLACK);
        juego.setOpaque(true);
        juego.setBorder(new PanelBorder(Color.BLACK, Color.WHITE, 2, TitledBorder.CENTER, ""));
        juego.setLayout(new BoxLayout(juego, BoxLayout.Y_AXIS));
        juego.add(menuPrincipal);
        juego.add(Dibujo());
        juego.add(Interactua());
        return juego;
    }

    public JPanel Interactua() {
        muestra = new JPanel();
        palabra = new JTextField(palabras.Rellena(), 10);
        palabra.setFont(new Font("", Font.PLAIN, 30));
        palabra.setHorizontalAlignment(JTextField.CENTER);
        palabra.setEditable(false);
        palabra.setForeground(Color.WHITE);
        palabra.setBackground(Color.BLACK);
        palabra.setOpaque(true);
        solucion = new JTextField(configuracion[0]);
        solucion.setEditable(false);
        solucion.setForeground(Color.YELLOW);
        solucion.setBackground(Color.BLACK);
        solucion.setHorizontalAlignment(JTextField.CENTER);
        solucion.addActionListener(this);
        muestra.setLayout(new BoxLayout(muestra, BoxLayout.Y_AXIS));
        muestra.setBorder(new PanelBorder(Color.BLACK, 3, TitledBorder.CENTER, ""));
        muestra.setForeground(Color.YELLOW);
        muestra.setBackground(Color.BLACK);
        muestra.setOpaque(true);
        muestra.add(palabra);
        muestra.add(solucion);
        return muestra;
    }

    public JPanel Dibujo() {
        contenedorDibujo = new JPanel();
        dibujo = new JLabel(new ImageIcon(getClass().getResource("/recursos/Aho0.gif")));
        contenedorDibujo.setBorder(new PanelBorder(Color.BLACK, 2, TitledBorder.CENTER, ""));
        contenedorDibujo.setBackground(Color.WHITE);
        contenedorDibujo.setOpaque(true);
        contenedorDibujo.add(dibujo);
        return contenedorDibujo;

    }

    public JPanel Teclado() {
        JPanel contenedorTeclado = new JPanel();
        contenedorTeclado.setBackground(Color.BLACK);
        contenedorTeclado.setOpaque(true);
        contenedorTeclado.setBorder(new PanelBorder(Color.BLACK, Color.WHITE, 2, TitledBorder.CENTER, ""));
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Nuevo", "Solucion", "Salir"};
        botones = new JButton[letras.length];
        contenedorTeclado.setLayout(new GridLayout(6, 3));
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton(letras[i], new ImageIcon(getClass().getResource("/recursos/Boton3.jpeg")));
            botones[i].setForeground(Color.WHITE);
            if (i > 26) {
                botones[i] = new JButton(letras[i], new ImageIcon(getClass().getResource("/recursos/Boton2.jpeg")));
                botones[i].setForeground(Color.WHITE);
            } else {
                botones[i].setFont(new Font("Arial", Font.BOLD, 20));
            }
            botones[i].setHorizontalTextPosition(JButton.CENTER);
            botones[i].addActionListener(this);
            contenedorTeclado.add(botones[i]);
        }
        return contenedorTeclado;
    }

    public void Interactua(String actualiza) {
        if (actualiza == "PERDISTE") {
            solucion.setText(palabras.getPalabra());
        }
        palabra.setText(actualiza);
        muestra.add(palabra);
        muestra.updateUI();
    }

    public void Dibujo(Icon nuevo) {
        dibujo.setIcon(nuevo);
        contenedorDibujo.add(dibujo);
        contenedorDibujo.updateUI();
    }

    public void ActualizaDibujo() {
        switch (oportunidades) {
            case 1: {
                Dibujo(new ImageIcon(getClass().getResource("/recursos/Aho2.gif")));
                break;
            }
            case 2: {
                Dibujo(new ImageIcon(getClass().getResource("/recursos/Aho3.gif")));
                break;
            }
            case 3: {
                Dibujo(new ImageIcon(getClass().getResource("/recursos/Aho4.gif")));
                break;
            }
            case 4: {
                Dibujo(new ImageIcon(getClass().getResource("/recursos/Aho5.gif")));
                break;
            }
            case 5: {
                Dibujo(new ImageIcon(getClass().getResource("/recursos/Aho6.gif")));
                break;
            }
            case 6: {
                Dibujo(new ImageIcon(getClass().getResource("/recursos/Aho7.gif")));
                break;
            }
            default: {
                Dibujo(new ImageIcon(getClass().getResource("/recursos/Aho2.gif")));
                break;
            }
        }
    }

    public void OperaAlPulsar(String ref) {
        if ((oportunidades < 6) && (palabras.GanarPartida() != true)) {
            recoge = palabras.Oculta(palabras.Busca(ref.charAt(0)));
            System.out.println(recoge);
            Interactua(recoge);
            if ((palabras.Iguales(ref.charAt(0)) == false) && (ref.charAt(0) != iguales)) {
                oportunidades++;
                ActualizaDibujo();
                iguales = ref.charAt(0);
            }
            System.out.println(oportunidades);
        }
        if (oportunidades == 6) {
            Interactua("PERDISTE");
        }
        if (palabras.GanarPartida()) {
            Interactua("GANASTE!!!");
            Dibujo(new ImageIcon(getClass().getResource("/recursos/carita.jpg")));
        }
    }

    public void Opciones(String ref) {
        if (ref == "Nuevo") {
            Panel();
        }
        if (ref == "Solucion") {
            Interactua(palabras.getPalabra());
            oportunidades = 6;
        }
        if (ref == "Salir") {
            System.exit(1);
        }
    }

    public void Limpia() {
        aux = new JFrame();
        super.setContentPane((JPanel) aux.getContentPane());
    }

    public void actionPerformed(ActionEvent e) {
        evento = e.getActionCommand();
        System.out.println(evento);
        if (evento.length() == 1) {
            System.out.println("entro en busca de palabra");
            OperaAlPulsar(evento);
        }
        if ((evento == "Nuevo") || (evento == "Solucion") || (evento == "Salir")) {
            System.out.println("entro en opciones");
            Opciones(evento);
        }
        if ((evento == "INICIAR AHORCADO") && (bloquea != true)) {
            Panel();
        }
        if (evento == "OPCIONES") {
            FrameConfigura configura = new FrameConfigura();
        }
        if (evento == "INSTRUCCIONES") {
            ins = new Instrucciones();
            FrameInstrucciones instrucciones = new FrameInstrucciones();
        }
        if (evento == "CREDITOS") {
            cre = new Creditos();
            FrameCreditos creditos = new FrameCreditos();
        }
        if (evento == "VOLVER AL MENU") {
            System.out.println("Voy al menu principal");
            MenuPrincipal();
        }
    }

    public class FrameCreditos extends JDialog {

        public FrameCreditos() {
            super(cre.getFrame());
        }
    }

    public class FrameInstrucciones extends JDialog {

        public FrameInstrucciones() {
            super(ins.getFrame());
        }
    }

    public class FrameConfigura extends JDialog {

        public FrameConfigura() {
            super(op.getFrame());
            configuracion = op.getConfiguracion();
        }
    }

    public class Configuracion implements ActionListener, ItemListener {

        private JFrame frame;
        private JPanel panel;
        private JRadioButton facil;
        private JRadioButton normal;
        private JRadioButton dificil;
        private JRadioButton muyDificil;
        private JComboBox temas;
        private JButton aceptar;
        private EscuchaBoton escucha;
        private String[] opcionTemas = {"Arte", "Ciencia", "Deportes", "Musica", "Personajes", "Tecnologia", "Programacion", "General"};
        private JPanel temp = new JPanel();
        private ButtonGroup dificultad;

        public Configuracion() {
            panel = new JPanel();
            facil = new JRadioButton("Facil");
            normal = new JRadioButton("Normal");
            normal.setSelected(true);
            dificil = new JRadioButton("Dificil");
            muyDificil = new JRadioButton("Muy Dificil");
            facil.setForeground(Color.WHITE);
            normal.setForeground(Color.WHITE);
            dificil.setForeground(Color.WHITE);
            muyDificil.setForeground(Color.WHITE);
            dificultad = new ButtonGroup();
            dificultad.add(facil);
            dificultad.add(normal);
            dificultad.add(dificil);
            dificultad.add(muyDificil);
            aceptar = new JButton("Aceptar");
            aceptar.setForeground(Color.WHITE);
            aceptar.setBackground(Color.BLACK);
            temas = new JComboBox(opcionTemas);
            configuracion = new String[2];
            frame = new JFrame("Opciones");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }

        public JPanel getPanelFrame() {
            return panel;
        }

        public void Opciones() {
            temp.setBackground(Color.BLACK);
            temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
            temp.add(facil);
            temp.add(normal);
            temp.add(dificil);
            temp.add(muyDificil);
            panel.add(temas, BorderLayout.NORTH);
            panel.add(temp, BorderLayout.CENTER);
            panel.add(aceptar, BorderLayout.SOUTH);
        }

        public void Decora() {
            facil.setBackground(Color.BLACK);
            normal.setBackground(Color.BLACK);
            dificil.setBackground(Color.BLACK);
            muyDificil.setBackground(Color.BLACK);
            panel.setBackground(Color.BLACK);
            panel.setBorder(new PanelBorder(Color.BLACK, Color.WHITE, 5, TitledBorder.CENTER, ""));
        }

        public void Escuchadores() {
            ValoresDefecto();
            escucha = new EscuchaBoton();
            aceptar.addActionListener(new EscuchaBoton());
            temas.addActionListener(this);
            facil.addItemListener(this);
            normal.addItemListener(this);
            dificil.addItemListener(this);
            muyDificil.addItemListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            configuracion[0] = (String) cb.getSelectedItem();
            System.out.println(toString());
        }

        public void itemStateChanged(ItemEvent e) {
            Object source = e.getItemSelectable();
            if (source == facil) {
                configuracion[1] = "facil";
                normal.setSelected(false);
                dificil.setSelected(false);
                muyDificil.setSelected(false);
            } else if (source == normal) {
                configuracion[1] = "normal";
                facil.setSelected(false);
                dificil.setSelected(false);
                muyDificil.setSelected(false);
            } else if (source == dificil) {
                configuracion[1] = "dificil";
                facil.setSelected(false);
                normal.setSelected(false);
                muyDificil.setSelected(false);
            } else {
                configuracion[1] = "muy dificil";
                facil.setSelected(false);
                normal.setSelected(false);
                dificil.setSelected(false);
            }
            System.out.println(toString());
        }

        public class EscuchaBoton implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        }

        public String[] getConfiguracion() {
            return configuracion;
        }

        public void ForzarCierre() {
            System.exit(1);
        }

        public String toString() {
            String temp = "";
            for (int i = 0; i < configuracion.length; i++) {
                temp += configuracion[i] + "";
            }
            return temp;
        }

        public void ValoresDefecto() {
            configuracion[0] = "General";
            configuracion[1] = "Normal";
        }

        public JFrame getFrame() {
            JPanel temp = (JPanel) frame.getContentPane();
            temp.add(getPanelFrame());
            frame.setVisible(true);
            frame.setSize(200, 200);
            frame.setLocationRelativeTo(null);
            Decora();
            Opciones();
            Escuchadores();
            return frame;
        }
    }
    public static void main(String[]args){
        FrameAhorcado nuevo = new FrameAhorcado();
    }

}
