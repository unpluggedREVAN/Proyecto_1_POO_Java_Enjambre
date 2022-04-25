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

    public abstract void moverAgente();
    public abstract boolean accionAgente(int xA, int yA);
    public abstract void paintAgente(Graphics g);
    public abstract boolean verificaBusqueda(int dir, int xA, int yA);

    public boolean calcularArea(int xA, int yA){
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA){
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) { // Originalmente era 15, luego se probó con 45
                    rangoBusca = true;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA - 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) {
                    rangoBusca = true;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA + 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) {
                    rangoBusca = true;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
            if (Recurso.listaRecursos1.get(i).coorY == yA){
                if (Recurso.listaRecursos1.get(i).coorX == xA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA){
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA - 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA + 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
            if (Recurso.listaRecursos1.get(i).coorY == yA){
                if (Recurso.listaRecursos1.get(i).coorX == xA - 15) {
                    rangoBusca = true;
                    return true;
                }
            }
        }
        rangoBusca = false;
        return false;
    }
}