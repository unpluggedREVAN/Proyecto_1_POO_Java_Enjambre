// Proyecto enjambre - POO
// Diana Sanabria (-) / Jose Pablo Agüero Mora (2021126372) 
// Super clase agente

import java.util.*;

public abstract class Agente {
    int identificador;
    int X;
    int Y;
    int direccion;
    int mov;

    static ArrayList<Agente> agentes = new ArrayList<Agente>();

    //static ArrayList<Recolector> recolectores = new ArrayList<Recolector>();

    public Agente (){ 
        identificador = 0;
        X = 1;
        Y = 1;
        direccion = 0;
    }

    public abstract void moverAgente();
    public abstract void accionAgente();
}