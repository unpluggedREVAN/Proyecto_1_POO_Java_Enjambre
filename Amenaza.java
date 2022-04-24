// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Amenaza

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Amenaza extends Objeto{

    static ArrayList<Amenaza> listaAmenazas = new ArrayList<Amenaza>();
    static int[] posAmeX = new int[]{391,406,391,406}; 
    static int[] posAmeY = new int[]{241,241,256,256};
    
    
    public Amenaza(){
        coorX = 1;
        coorY = 1;
        vida = 5;
        modo = true;
    }

    public void paintObjeto(Graphics g){
        if (vida > 0){
            g.setColor(Color.yellow);
            g.fillRect(coorX, coorY, 14, 14);
        }
        else{
            g.setColor(Color.PINK);
            g.fillRect(coorX, coorY, 14, 14);
        }
    }

    public void verificaEstado(){
        for (int i=0;i<Recurso.listaRecursos1.size();i++){
            if (listaAmenazas.get(i).vida == 0){
                listaAmenazas.get(i).modo = false;
            }
            else{
                listaAmenazas.get(i).modo = true;
            }
        }
    }

    public void bajarVida(){
        for (int i=0;i<listaAmenazas.size();i++){
            listaAmenazas.get(i).vida -= 1;
        }
    }
    
    public void reacciona(){
        if (modo == false){
            respawnObjeto();
            vida = 5;
            modo = true;
        }
    }

    public void respawnObjeto(){
        int numRandom = (int)Math.floor(Math.random()*(49-1)+1);
        int multiplo = (numRandom * 15) + 1;

        for (int i = 0; i < listaAmenazas.size(); i++){
            if (i == 0 || i == 3){
                listaAmenazas.get(i).coorX = multiplo;
            }
            else{
                listaAmenazas.get(i).coorX = multiplo + 15;
            }
        }

        numRandom = (int)Math.floor(Math.random()*(49-1)+1);
        multiplo = (numRandom * 15) + 1;

        for (int i = 0; i < listaAmenazas.size(); i++){
            if (i == 0 || i == 1){
                listaAmenazas.get(i).coorY = multiplo;
            }
            else{
                listaAmenazas.get(i).coorY = multiplo + 15;
            }
        }
    }

    public boolean pruebaColision(int dir, int X, int Y){
        return true;
    }

    public int getVida(){
        return vida;
    }
}
