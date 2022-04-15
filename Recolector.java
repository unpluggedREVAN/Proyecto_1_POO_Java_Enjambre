// Tarea jerarquía de clases - Herencia
// Jose Pablo Agüero Mora (2021126372) - Grupo 2
// SubClase Circulo

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.*;

public class Recolector extends Agente{
    private boolean carry;
    private boolean rangoBusca;
    static ArrayList<Recolector> recolectores = new ArrayList<Recolector>();

    Random random = new Random();
    int rnd = random.nextInt(42);

    public Recolector(){
        carry = false;
        rangoBusca = false;
    }

    public boolean VerificaCoor(int dir, int xA, int yA){
        if (dir == 1){
            for (int i=0;i<recolectores.size();i++) { // Ciclo que recorre la lista fichas
                if (recolectores.get(i).X == xA){
                    if (recolectores.get(i).Y == yA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 2){
            for (int i=0;i<recolectores.size();i++) { // Ciclo que recorre la lista fichas
                if (recolectores.get(i).Y == yA){
                    if (recolectores.get(i).X == xA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 3){
            for (int i=0;i<recolectores.size();i++) { // Ciclo que recorre la lista fichas
                if (recolectores.get(i).X == xA){
                    if (recolectores.get(i).Y == yA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 4){
            for (int i=0;i<recolectores.size();i++) { // Ciclo que recorre la lista fichas
                if (recolectores.get(i).Y == yA){
                    if (recolectores.get(i).X == xA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }

    //implementacion del metodo abstracto
    public void moverAgente(){
        int numRand = (int)Math.floor(Math.random()*(4-1+1)+1);
        this.direccion = numRand;

        if (direccion == 1){
            if (Y-15 > 0){
                if ((VerificaCoor(1, X, Y) == true) && (Obstaculo.CoorObs(1, X, Y) == true)){
                    Y -= 15;
                }
            }
        }
        if (direccion == 2){
            if (X + 15 <= 736){
                if ((VerificaCoor(2, X, Y) == true) && (Obstaculo.CoorObs(2, X, Y) == true)){
                    X += 15;
                }
            }
        }
        if (direccion == 3){
            if (Y+15 <= 736){
                if ((VerificaCoor(3, X, Y) == true) && (Obstaculo.CoorObs(3, X, Y) == true)){
                    Y += 15;
                }
            }
        }
        if (direccion == 4){
            if (X-15 > 0){
                if ((VerificaCoor(4, X, Y) == true) && (Obstaculo.CoorObs(4, X, Y) == true)){
                    X -= 15;
                }
            }
        }
    }

    public void accionAgente(){
        carry = false;
    }

    public void paintRec(Graphics g){
        g.setColor(Color.red);
        g.fillRect(X, Y, 14, 14);
    }
}