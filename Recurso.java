// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Recurso

import java.util.*;
import java.awt.Graphics;
import java.awt.Color;

public class Recurso extends Objeto {
    static ArrayList<Recurso> listaRecursos1 = new ArrayList<Recurso>();
    static int[] posRecuX = new int[]{376,391,376,391};
    static int[] posRecuY = new int[]{151,151,166,166};

    public Recurso (){ 
        coorX = 1;
        coorY = 1;
        vida = 10;
        modo = true;
    }

    // Pinta el cuerpo en pantalla
    public void paintObjeto(Graphics g){
        if (vida > 0){
            g.setColor(Color.green);
            g.fillRect(coorX, coorY, 14, 14);
        }
        else{
            g.setColor(Color.PINK);
            g.fillRect(coorX, coorY, 14, 14);
        }
    }

    // Comprueba si el recurso sigue activo
    public void verificaEstado(){
        for (int i=0;i<Recurso.listaRecursos1.size();i++){
            if (listaRecursos1.get(i).vida <= 0){
                listaRecursos1.get(i).modo = false;
            }
            else{
                listaRecursos1.get(i).modo = true;
            }
        }
    }

    // Baja la vida cuando se le quita una unidad de recurso
    public void bajarVida(){
        for (int i=0;i<listaRecursos1.size();i++){
            listaRecursos1.get(i).vida -= 1;
        }
        
    }

    // Verifica si ha muerto para hacerlo reaparecer
    public void reacciona(){
        if (modo == false){ 
            respawnObjeto();
            vida = 10;
            modo = true;
        }
    }

    // Hace reaparecer los cuerpos en coordenadas aleatorias
    public void respawnObjeto(){
        int numRandom = (int)Math.floor(Math.random()*(49-1)+1);
        int multiplo = (numRandom * 15) + 1;

        for (int i = 0; i < listaRecursos1.size(); i++){
            if (i == 0 || i == 3){
                listaRecursos1.get(i).coorX = multiplo;
            }
            else{
                listaRecursos1.get(i).coorX = multiplo + 15;
            }
        }

        numRandom = (int)Math.floor(Math.random()*(49-1)+1);
        multiplo = (numRandom * 15) + 1;

        for (int i = 0; i < listaRecursos1.size(); i++){
            if (i == 0 || i == 1){
                listaRecursos1.get(i).coorY = multiplo;
            }
            else{
                listaRecursos1.get(i).coorY = multiplo + 15;
            }
        }
    }

    // Verifica que no se colisione con un recurso
    public boolean pruebaColision(int dir, int xA, int yA){
        for (int i=0;i<listaRecursos1.size();i++){
            if (dir == 1){
                if (listaRecursos1.get(i).coorX == xA){
                    if (listaRecursos1.get(i).coorY == yA - 15) {
                        return false;
                    }
                }
            }
            if (dir == 2){
                if (listaRecursos1.get(i).coorY == yA){
                    if (listaRecursos1.get(i).coorX == xA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 3){
                if (listaRecursos1.get(i).coorX == xA){
                    if (listaRecursos1.get(i).coorY == yA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 4){
                if (listaRecursos1.get(i).coorY == yA){
                    if (listaRecursos1.get(i).coorX == xA - 15) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}