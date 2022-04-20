// Proyecto enjambre - POO
// Diana Sanabria (-) / Jose Pablo Agüero Mora (2021126372) 
// Clase Hormiguero

import java.awt.Graphics;
import java.awt.Color;

public class Hormiguero {
    int identificador;
    static int X;
    static int Y;
    boolean activo;
    //int direccion;

    //static ArrayList<Recolector> recolectores = new ArrayList<Recolector>();

    public Hormiguero (){ 
        identificador = 0;
        X = 1;
        Y = 1;
    }

    public void dibujar(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(X, Y, 14, 14);
    }
}