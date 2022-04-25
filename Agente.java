// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Super clase Agente

import java.awt.Graphics;

public abstract class Agente {
    int posX;
    int posY;
    int direccion;
    int movimiento;
    boolean rangoBusca;

    public Agente (){
        posX = 1;
        posY = 1;
        direccion = 0;
    }

    // Se van a usar con polimorfismo
    public abstract void moverAgente();
    public abstract boolean accionAgente(int xA, int yA);
    public abstract void paintAgente(Graphics g);
    public abstract boolean verificaBusqueda(int dir, int xA, int yA);
    public abstract boolean calcularArea(int xA, int yA);
}