// Tarea jerarquía de clases - Herencia
// Jose Pablo Agüero Mora (2021126372) - Grupo 2
// SubClase Circulo

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.*;

public class Recolector extends Agente{
    public boolean carry;
    public boolean rangoBusca;
    static public int auxX;
    static public int auxY;

    //static public int encuentraX;
    //static public int encuentraY;

    static ArrayList<Recolector> recolectores = new ArrayList<Recolector>();

    Random random = new Random();
    int rnd = random.nextInt(42);

    public Recolector(){
        carry = false;
        rangoBusca = false;
    }

    static public boolean VerificaCoor(int dir, int xA, int yA){
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

    public boolean calcularArea(int xA, int yA){
        
        for (int i=0;i<Recurso.recursos.size();i++) { // Potencial
            if (Recurso.recursos.get(i).X == xA){
                if (Recurso.recursos.get(i).Y == yA - 15) { // Originalmente era 15, luego se probó con 45
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.recursos.size();i++) { // Potencial
            if (Recurso.recursos.get(i).X == xA - 15){
                if (Recurso.recursos.get(i).Y == yA - 15) {
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.recursos.size();i++) { // Potencial
            if (Recurso.recursos.get(i).X == xA + 15){
                if (Recurso.recursos.get(i).Y == yA - 15) {
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.recursos.size();i++) { // Ciclo que recorre la lista fichas
            if (Recurso.recursos.get(i).Y == yA){
                if (Recurso.recursos.get(i).X == xA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.recursos.size();i++) { // Potencial
            if (Recurso.recursos.get(i).X == xA){
                if (Recurso.recursos.get(i).Y == yA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.recursos.size();i++) { // Potencial
            if (Recurso.recursos.get(i).X == xA - 15){
                if (Recurso.recursos.get(i).Y == yA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.recursos.size();i++) { // Potencial
            if (Recurso.recursos.get(i).X == xA + 15){
                if (Recurso.recursos.get(i).Y == yA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.recursos.size();i++) { // Ciclo que recorre la lista fichas
            if (Recurso.recursos.get(i).Y == yA){
                if (Recurso.recursos.get(i).X == xA - 15) {
                    rangoBusca = true;
                    auxX = Recurso.recursos.get(i).X;
                    auxY = Recurso.recursos.get(i).Y;
                    return true;
                }
            }
        }
        rangoBusca = false;
        return false;
        
    }


    //implementacion del metodo abstracto
    public void moverAgente(){
        int numRand = (int)Math.floor(Math.random()*(4-1+1)+1);
        this.direccion = numRand;

        if (mov == 1){
            if (direccion == 1){
                if (Y-15 > 0){
                    if (rangoBusca == false){
                        if ((VerificaCoor(1, X, Y) == true) && (Obstaculo.CoorObs(1, X, Y) == true)){
                            if (Recurso.CoorRecu(1, X, Y) == true){
                                if (Defensor.VerificaCoor2(1, X, Y) == true){
                                    Y -= 15;
                                }
                            }
                        }
                    }
                    else{
                        //mov = 3;
                        mov = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        Recurso.bajarVida();
                    }
                    
                }
            }
            if (direccion == 2){
                if (X + 15 <= 736){
                    if (rangoBusca == false){
                        if ((VerificaCoor(2, X, Y) == true) && (Obstaculo.CoorObs(2, X, Y) == true)){
                            if (Recurso.CoorRecu(2, X, Y) == true){
                                if (Defensor.VerificaCoor2(2, X, Y) == true){
                                    X += 15;
                                }
                            }
                        }
                    }
                    else{
                        //mov = 3;
                        System.out.println("Se encontró recurso");
                        mov = 2;
                        System.out.println("Se va a devolver");

                        Recurso.bajarVida();
                    }
                    
                }
            }
            if (direccion == 3){
                if (Y+15 <= 736){
                    if (rangoBusca == false){
                        if ((VerificaCoor(3, X, Y) == true) && (Obstaculo.CoorObs(3, X, Y) == true)){
                            if (Recurso.CoorRecu(2, X, Y) == true){
                                if (Defensor.VerificaCoor2(3, X, Y) == true){
                                    Y += 15;
                                }
                            }
                        }
                    }
                    else{
                        //mov = 3;
                        mov = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        Recurso.bajarVida();
                    }
                    
                }
            }
            if (direccion == 4){
                if (X-15 > 0){
                    if (rangoBusca == false){
                        if ((VerificaCoor(4, X, Y) == true) && (Obstaculo.CoorObs(4, X, Y) == true)){
                            if (Recurso.CoorRecu(2, X, Y) == true){
                                if (Defensor.VerificaCoor2(4, X, Y) == true){
                                    X -= 15;
                                }
                            }
                        }
                    }
                    else{
                        //mov = 3;
                        mov = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        Recurso.bajarVida();
                    }
                }
            }
        }
        if (mov == 2){
            if (X != 1){
                if (VerificaCoor(4, X, Y) == true){
                    if (Obstaculo.CoorObs(4, X, Y) == true){
                        if (Recurso.CoorRecu(4, X, Y) == true){
                            X -= 15;
                        }
                        else{
                            Y -= 15;
                        }
                    }
                    else{
                        Y -= 15;
                    }
                }
                else{
                    Y -= 15;
                }
            }
            else{
                if (Y != 1){
                    if (VerificaCoor(1, X, Y) == true){
                        if (Obstaculo.CoorObs(4, X, Y) == true){
                            if (Recurso.CoorRecu(4, X, Y) == true){
                                Y -= 15;
                            }
                            else{
                                X -= 15;
                            }
                        }
                        else{
                            X -= 15;
                        }
                    }
                    else{
                        X -= 15;
                    }
                }
                else{ // Cuando llega al hormiguero
                    mov = 1;
                }
            }
        }
        if (mov == 3){
            if (X != auxX-15){
                X -= 15;
            }
            else{
                if (Y != auxY){
                    Y -= 15;
                }
                else{ // Cuando llega al recurso
                    mov = 2;
                }
            }
        }
        
    }

    public void accionAgente(){
        carry = false;
    }

    public void paintRec(Graphics g){
        if (mov == 1){
            g.setColor(Color.red);
            g.fillRect(X, Y, 14, 14);
        }
        if (mov == 2){
            g.setColor(Color.red);
            g.fillRect(X, Y, 14, 14);

            g.setColor(Color.green);
            g.fillRect(X+3, Y+3, 7, 7);
        }
        
    }
}