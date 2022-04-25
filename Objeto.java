// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Super clase Objeto

import java.awt.Graphics;

public abstract class Objeto {
    boolean modo; 
    int vida;
    int coorX;
    int coorY;

    public Objeto (){ 
        modo = true;
        coorX = 1;
        coorY = 1;
    }

    // Se van a usar con polimorfismo
    public abstract void verificaEstado();
    public abstract void reacciona();
    public abstract void bajarVida();
    public abstract void respawnObjeto();
    public abstract void paintObjeto(Graphics g);
    public abstract boolean pruebaColision(int direccion, int posX, int posY);
}