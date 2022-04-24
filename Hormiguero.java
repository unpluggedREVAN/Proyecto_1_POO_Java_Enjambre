// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Hormiguero

import java.awt.Graphics;
import java.awt.Color;

public class Hormiguero {
    static int settingFila;
    static int settingCol;
    boolean activo;

    public Hormiguero (){ 
        settingFila = 1;
        settingCol = 1;
    }

    public void paintHormiguero(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(settingFila, settingCol, 14, 14);
    }
}