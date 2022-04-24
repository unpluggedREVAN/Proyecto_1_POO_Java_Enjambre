// Proyecto enjambre - POO
// Diana Sanabria (-) / Jose Pablo Agüero Mora (2021126372) 
// Clase obstaculo

import java.util.*;
import java.awt.Graphics;
import java.awt.Color;


public class Obstaculo extends Objeto{

    static ArrayList<Obstaculo> listaObstaculos = new ArrayList<Obstaculo>();
    static int[] posObsX = new int[]{271,286,271,286, 166,181,166,181, 526,541,526,541, 496,511,496,511};
    static int[] posObsY = new int[]{616,616,631,631, 301,301,316,316, 151,151,166,166, 481,481,496,496}; 

    public Obstaculo (){ 
        modo = true;
        coorX = 1;
        coorY = 1;
    }

    public void paintObjeto(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(coorX, coorY, 14, 14);
    }

    public boolean pruebaColision(int dir, int xA, int yA){
        for (int i=0;i<listaObstaculos.size();i++){
            if (dir == 1){
                if (listaObstaculos.get(i).coorX == xA){
                    if (listaObstaculos.get(i).coorY == yA - 15) {
                        return false;
                    }
                }
            }
            if (dir == 2){
                if (listaObstaculos.get(i).coorY == yA){
                    if (listaObstaculos.get(i).coorX == xA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 3){
                if (listaObstaculos.get(i).coorX == xA){
                    if (listaObstaculos.get(i).coorY == yA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 4){
                if (listaObstaculos.get(i).coorY == yA){
                    if (listaObstaculos.get(i).coorX == xA - 15) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void verificaEstado(){
        modo = true;
    }
    public void reacciona(){
        modo = true;
    }
    public void respawnObjeto(){
        modo = true;
    }
    public void bajarVida(){
        modo = true;
    }
}