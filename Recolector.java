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
    public boolean rangoHuida;
    static public int auxX;
    static public int auxY;
    private int limite = 0;
    private int dir2;

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
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA){
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) { // Originalmente era 15, luego se probó con 45
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA - 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) {
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA + 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) {
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
            if (Recurso.listaRecursos1.get(i).coorY == yA){
                if (Recurso.listaRecursos1.get(i).coorX == xA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA){
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA - 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }

        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Potencial
            if (Recurso.listaRecursos1.get(i).coorX == xA + 15){
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { // Ciclo que recorre la lista fichas
            if (Recurso.listaRecursos1.get(i).coorY == yA){
                if (Recurso.listaRecursos1.get(i).coorX == xA - 15) {
                    rangoBusca = true;
                    auxX = Recurso.listaRecursos1.get(i).coorX;
                    auxY = Recurso.listaRecursos1.get(i).coorY;
                    return true;
                }
            }
        }
        rangoBusca = false;
        return false;
        
    }

    public boolean calcularHuida(int xA, int yA){ // Cambiar el tipo de función a void
        
        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Potencial
            if (Amenaza.listaAmenazas.get(i).coorX == xA){
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) { // Originalmente era 15, luego se probó con 45
                    rangoHuida = true;
                    dir2 = 1;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Potencial
            if (Amenaza.listaAmenazas.get(i).coorX == xA - 15){
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) {
                    rangoHuida = true;
                    dir2 = 1;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Potencial
            if (Amenaza.listaAmenazas.get(i).coorX == xA + 15){
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) {
                    rangoHuida = true;
                    dir2 = 1;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Ciclo que recorre la lista fichas
            if (Amenaza.listaAmenazas.get(i).coorY == yA){
                if (Amenaza.listaAmenazas.get(i).coorX == xA + 15) {
                    rangoHuida = true;
                    dir2 = 0;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Potencial
            if (Amenaza.listaAmenazas.get(i).coorX == xA){
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoHuida = true;
                    dir2 = 0;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Potencial
            if (Amenaza.listaAmenazas.get(i).coorX == xA - 15){
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoHuida = true;
                    dir2 = 0;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }

        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Potencial
            if (Amenaza.listaAmenazas.get(i).coorX == xA + 15){
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoHuida = true;
                    dir2 = 0;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }
        
        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Ciclo que recorre la lista fichas
            if (Amenaza.listaAmenazas.get(i).coorY == yA){
                if (Amenaza.listaAmenazas.get(i).coorX == xA - 15) {
                    rangoHuida = true;
                    dir2 = 0;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }
        return false;
        
    }


    //implementacion del metodo abstracto
    public void moverAgente(){
        int numRand = (int)Math.floor(Math.random()*(4-1+1)+1);
        this.direccion = numRand;

        if (mov == 1){
            Recurso actual2 = new Recurso();
            Obstaculo obsActual2 = new Obstaculo();
            if (direccion == 1){
                if (Y-15 > 0){
                    if (rangoHuida == true && rangoBusca == false){
                        System.out.println("rangoHuida = true");
                        if (limite == 4){
                            rangoHuida = false;
                            limite = 0;
                        }
                        else{
                            if (dir2 == 0){
                                Y -= 15;
                            }
                            else{
                                Y += 15;
                            }
                            limite += 1;
                        }
                    }
                    if (rangoBusca == false && rangoHuida == false){
                        if ((VerificaCoor(1, X, Y) == true) && (obsActual2.pruebaColision(1, X, Y) == true)){
                            if (actual2.pruebaColision(1, X, Y) == true){
                                if (Defensor.VerificaCoor2(1, X, Y) == true){
                                    Y -= 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        mov = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        actual2.bajarVida(); // Antes era Recurso.bajarVida()
                    }
                    
                }
            }
            if (direccion == 2){
                if (X + 15 <= 736){
                    if (rangoHuida == true && rangoBusca == false){
                        System.out.println("rangoHuida = true");
                        if (limite == 4){
                            rangoHuida = false;
                            limite = 0;
                        }
                        else{
                            if (dir2 == 0){
                                Y -= 15;
                            }
                            else{
                                Y += 15;
                            }
                            limite += 1;
                        }
                    }
                    if (rangoBusca == false && rangoHuida == false){
                        if ((VerificaCoor(2, X, Y) == true) && (obsActual2.pruebaColision(2, X, Y) == true)){
                            if (actual2.pruebaColision(2, X, Y) == true){
                                if (Defensor.VerificaCoor2(2, X, Y) == true){
                                    X += 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        System.out.println("Se encontró recurso");
                        mov = 2;
                        System.out.println("Se va a devolver");

                        actual2.bajarVida();
                    }
                    
                }
            }
            if (direccion == 3){
                if (Y+15 <= 736){
                    if (rangoHuida == true && rangoBusca == false){
                        System.out.println("rangoHuida = true");
                        if (limite == 4){
                            rangoHuida = false;
                            limite = 0;
                        }
                        else{
                            if (dir2 == 0){
                                Y -= 15;
                            }
                            else{
                                Y += 15;
                            }
                            limite += 1;
                        }
                    }
                    if (rangoBusca == false && rangoHuida == false){
                        if ((VerificaCoor(3, X, Y) == true) && (obsActual2.pruebaColision(3, X, Y) == true)){
                            if (actual2.pruebaColision(2, X, Y) == true){
                                if (Defensor.VerificaCoor2(3, X, Y) == true){
                                    Y += 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        mov = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 
                        rangoBusca = false;

                        actual2.bajarVida();
                    }
                    
                }
            }
            if (direccion == 4){
                if (X-15 > 0){
                    if (rangoHuida == true && rangoBusca == false){
                        System.out.println("rangoHuida = true");
                        if (limite == 4){
                            rangoHuida = false;
                            limite = 0;
                        }
                        else{
                            if (dir2 == 0){
                                Y -= 15;
                            }
                            else{
                                Y += 15;
                            }
                            limite += 1;
                        }
                    }
                    if (rangoBusca == false && rangoHuida == false){
                        if ((VerificaCoor(4, X, Y) == true) && (obsActual2.pruebaColision(4, X, Y) == true)){
                            if (actual2.pruebaColision(2, X, Y) == true){
                                if (Defensor.VerificaCoor2(4, X, Y) == true){
                                    X -= 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        mov = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        actual2.bajarVida();
                    }
                }
            }
        }
        if (mov == 2){
            Recurso actual2 = new Recurso();
            Obstaculo obsActual2 = new Obstaculo();
            if (X != 1){
                if (VerificaCoor(4, X, Y) == true){
                    if (obsActual2.pruebaColision(4, X, Y) == true){
                        if (actual2.pruebaColision(4, X, Y) == true){
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
                        if (obsActual2.pruebaColision(4, X, Y) == true){
                            if (actual2.pruebaColision(4, X, Y) == true){
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
        if (mov == 4){
            Y += 15;
            System.out.println("A");
        }
        
    }

    public void accionAgente(){
        carry = false;
    }

    public void paintRec(Graphics g){
        if (mov == 1){
            g.setColor(Color.black);
            g.fillRect(X, Y, 14, 14);
        }
        if (mov == 2){
            g.setColor(Color.black);
            g.fillRect(X, Y, 14, 14);

            g.setColor(Color.green);
            g.fillRect(X+3, Y+3, 7, 7);
        }
        
    }
}