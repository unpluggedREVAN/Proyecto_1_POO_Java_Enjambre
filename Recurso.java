// Proyecto enjambre - POO
// Diana Sanabria (-) / Jose Pablo Agüero Mora (2021126372) 
// Clase obstaculo

import java.util.*;
import java.awt.Graphics;
import java.awt.Color;


public class Recurso {
    int identificador;
    int X;
    int Y;
    boolean activo;
    //int direccion;
    static ArrayList<Recurso> recursos = new ArrayList<Recurso>();

    //static ArrayList<Recolector> recolectores = new ArrayList<Recolector>();

    public Recurso (){ 
        identificador = 0;
        X = 1;
        Y = 1;
    }

    public void dibujar(Graphics g){
        g.setColor(Color.green);
        g.fillRect(X, Y, 14, 14);
    }

    static public boolean CoorRecu(int dir, int xA, int yA){
        if (dir == 1){
            for (int i=0;i<recursos.size();i++) { // Ciclo que recorre la lista fichas
                if (recursos.get(i).X == xA){
                    if (recursos.get(i).Y == yA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 2){
            for (int i=0;i<recursos.size();i++) { // Ciclo que recorre la lista fichas
                if (recursos.get(i).Y == yA){
                    if (recursos.get(i).X == xA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 3){
            for (int i=0;i<recursos.size();i++) { // Ciclo que recorre la lista fichas
                if (recursos.get(i).X == xA){
                    if (recursos.get(i).Y == yA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 4){
            for (int i=0;i<recursos.size();i++) { // Ciclo que recorre la lista fichas
                if (recursos.get(i).Y == yA){
                    if (recursos.get(i).X == xA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

    

    //public abstract void moverAgente();
    //public abstract void accionAgente();
}