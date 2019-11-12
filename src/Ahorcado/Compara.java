package Ahorcado;

import java.awt.List;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Compara {

    private String[] otras, arte, ciencia, deportes, musica, personajes, tecnologia, programacion;
    private String palabra;
    private Character[] posiciones;
    private int ganar = 0;
    private boolean gana;

    public Compara() {
        arte = LeerPalabras("/recursos/palabras_arte.txt");
        ciencia = LeerPalabras("/recursos/palabras_ciencia.txt");
        deportes = LeerPalabras("/recursos/palabras_deportes.txt");
        musica = LeerPalabras("/recursos/palabras_musica.txt");
        personajes = LeerPalabras("/recursos/palabras_personajes.txt");
        tecnologia = LeerPalabras("/recursos/palabras_tecnologia.txt");
        programacion = LeerPalabras("/recursos/palabras_programacion.txt");
        otras = LeerPalabras("/recursos/palabras_otras.txt");
        palabra = otras[Aleatorio(otras)];
        posiciones = new Character[palabra.length()];
    }

    public Compara(String buscaEnArray) {
        int aleatorio = 0;
        if (buscaEnArray == "Arte") {
            aleatorio = Aleatorio(arte);
            palabra = arte[aleatorio];
        } else if (buscaEnArray == "Ciencia") {
            aleatorio = Aleatorio(ciencia);
            palabra = ciencia[aleatorio];
        } else if (buscaEnArray == "Deportes") {
            aleatorio = Aleatorio(deportes);
            palabra = deportes[aleatorio];
        } else if (buscaEnArray == "Musica") {
            aleatorio = Aleatorio(musica);
            palabra = musica[aleatorio];
        } else if (buscaEnArray == "Personajes") {
            aleatorio = Aleatorio(personajes);
            palabra = personajes[aleatorio];
        } else if (buscaEnArray == "Tecnologia") {
            aleatorio = Aleatorio(tecnologia);
            palabra = tecnologia[aleatorio];
        } else if (buscaEnArray == "Programacion") {
            aleatorio = Aleatorio(programacion);
            palabra = programacion[aleatorio];
        } else {
            aleatorio = Aleatorio(otras);
            palabra = otras[aleatorio];
        }
        posiciones = new Character[palabra.length()];

    }

    public void NuevaPalabra(String buscaEnArray) {
        int aleatorio = 0;
        if (buscaEnArray == "Arte") {
            aleatorio = Aleatorio(arte);
            palabra = arte[aleatorio];
        } else if (buscaEnArray == "Ciencia") {
            aleatorio = Aleatorio(ciencia);
            palabra = ciencia[aleatorio];
        } else if (buscaEnArray == "Deportes") {
            aleatorio = Aleatorio(deportes);
            palabra = deportes[aleatorio];
        } else if (buscaEnArray == "Musica") {
            aleatorio = Aleatorio(musica);
            palabra = musica[aleatorio];
        } else if (buscaEnArray == "Personajes") {
            aleatorio = Aleatorio(personajes);
            palabra = personajes[aleatorio];
        } else if (buscaEnArray == "Tecnologia") {
            aleatorio = Aleatorio(tecnologia);
            palabra = tecnologia[aleatorio];
        } else if (buscaEnArray == "Programacion") {
            aleatorio = Aleatorio(programacion);
            palabra = programacion[aleatorio];
        } else {
            aleatorio = Aleatorio(otras);
            palabra = otras[aleatorio];
        }
        posiciones = new Character[palabra.length()];
    }

    public void Dificultad(String dificultad, String buscaEnArray) {
        NuevaPalabra(buscaEnArray);
        if (dificultad == "Facil") {
            if (palabra.length() >= 5) {
                do {
                    System.out.println(palabra.length());
                    NuevaPalabra(buscaEnArray);
                    System.out.println(palabra.length() >= 5);
                } while (palabra.length() >= 5);
            }
        }
        if (dificultad == "Normal") {
            if ((palabra.length() <= 5) || (palabra.length() >= 7)) {
                do {
                    System.out.println(palabra.length());
                    NuevaPalabra(buscaEnArray);
                } while ((palabra.length() <= 5) || (palabra.length() >= 7));
            }
        }
        if (dificultad == "Dificil") {
            if ((palabra.length() <= 7) || (palabra.length() >= 10)) {
                do {
                    System.out.println(palabra.length());
                    NuevaPalabra(buscaEnArray);
                } while ((palabra.length() <= 7) || (palabra.length() >= 10));
            }
        }
        if (dificultad == "Muy Dificil") {
            if (palabra.length() <= 10) {
                do {
                    System.out.println(palabra.length());
                    NuevaPalabra(buscaEnArray);
                } while (palabra.length() <= 10);
            }
        }
    }

    public void ResetGana() {
        ganar = 0;
        gana = false;
        for (int i = 0; i < palabra.length(); i++) {
            posiciones[i] = null;
        }
    }

    public boolean GanarPartida() {
        if (ganar == 1) {
            gana = true;
        } else {
            gana = false;
        }
        return gana;
    }

    public String getPalabra() {
        return palabra;
    }

    public Character[] getPosiciones() {
        return posiciones;
    }

    public String Rellena() {
        String modifica = "";
        for (int i = 0; i < palabra.length(); i++) {
            modifica += modifica.valueOf('*');
        }
        return modifica;
    }

    public boolean Iguales(char letra) {
        boolean afir = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                afir = true;
                break;
            } else {
                afir = false;
            }
        }
        return afir;
    }

    public Character[] Busca(char caracter) {
        Character[] coincide = new Character[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            if (caracter == palabra.charAt(i)) {
                coincide[i] = '*';
            } else {
                coincide[i] = null;
            }
        }
        return coincide;
    }

    public String Oculta(Character[] coincide) {
        String temp = "";
        char[] pos = new char[coincide.length];
        if (coincide.length == palabra.length()) {
            for (int i = 0; i < palabra.length(); i++) {
                if ((coincide[i] != null) && (posiciones[i] == null)) {
                    posiciones[i] = coincide[i];
                }
            }
            for (int i = 0; i < palabra.length(); i++) {
                if (posiciones[i] == null) {
                    pos[i] = '*';
                } else {
                    pos[i] = palabra.charAt(i);
                }
            }
            temp = temp.valueOf(pos);
            if (temp.compareTo(palabra) == 0) {
                ganar = 1;
            }
        } else {
            temp = "Error en la comparacion";
        }
        return temp;
    }

    public int Aleatorio(String[] palabras) {
        return (int) ((Math.random()) * (palabras.length));
    }

    private String[] LeerPalabras(String nombreArchivo) {
        String[] resultado;
        ArrayList<String> arreglo = new ArrayList<String>();
        Scanner archivo = null;
        URL url = getClass().getResource(nombreArchivo);
        try {
            archivo = new Scanner(new File(url.getFile().substring(1)));
            archivo.useDelimiter(",");
            while (archivo.hasNext()) {
                arreglo.add(archivo.next());
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            archivo.close();
        }
        resultado = new String[arreglo.size()];
        for (int i = 0; i < arreglo.size(); i++) {
            resultado[i] = arreglo.get(i);
        }
        return resultado;
    }
}
