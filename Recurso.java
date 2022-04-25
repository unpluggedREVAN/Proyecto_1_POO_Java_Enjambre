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
        vida = 2;
        modo = true;
    }

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

    public void bajarVida(){
        for (int i=0;i<listaRecursos1.size();i++){
            listaRecursos1.get(i).vida -= 1;
        }
        
    }

    public void reacciona(){
        if (modo == false){ // if (vida <= 0){
            respawnObjeto();
            vida = 2;
            modo = true;
        }
    }

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

    /*public boolean pruebaColision(int dir, int xA, int yA){
        if (dir == 1){
            for (int i=0;i<listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
                if (listaRecursos1.get(i).coorX == xA){
                    if (listaRecursos1.get(i).coorY == yA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 2){
            for (int i=0;i<listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
                if (listaRecursos1.get(i).coorY == yA){
                    if (listaRecursos1.get(i).coorX == xA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 3){
            for (int i=0;i<listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
                if (listaRecursos1.get(i).coorX == xA){
                    if (listaRecursos1.get(i).coorY == yA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 4){
            for (int i=0;i<listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
                if (listaRecursos1.get(i).coorY == yA){
                    if (listaRecursos1.get(i).coorX == xA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }*/
}