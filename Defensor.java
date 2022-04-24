// Tarea jerarquía de clases - Herencia
// Jose Pablo Agüero Mora (2021126372) - Grupo 2
// SubClase Circulo

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.*;

public class Defensor extends Agente{
    public boolean carry;
    public boolean rangoBusca;
    public boolean rangoAtaca; // Propio de defensores
    static public int auxX;
    static public int auxY;

    //static public int encuentraX;
    //static public int encuentraY;

    static ArrayList<Defensor> defensores = new ArrayList<Defensor>();

    Random random = new Random();
    int rnd = random.nextInt(42);

    public Defensor(){
        carry = false;
        rangoBusca = false;
        rangoAtaca = false;
    }

    static public boolean VerificaCoor2(int dir, int xA, int yA){
        if (dir == 1){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).X == xA){
                    if (defensores.get(i).Y == yA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 2){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).Y == yA){
                    if (defensores.get(i).X == xA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 3){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).X == xA){
                    if (defensores.get(i).Y == yA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 4){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).Y == yA){
                    if (defensores.get(i).X == xA - 15) {
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

    public boolean calcularAreaAtaque(int xA, int yA){ // Cambiar el tipo de función a void
        
        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { // Potencial
            if (Amenaza.listaAmenazas.get(i).coorX == xA){
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) { // Originalmente era 15, luego se probó con 45
                    rangoAtaca = true;
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
                    rangoAtaca = true;
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
                    rangoAtaca = true;
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
                    rangoAtaca = true;
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
                    rangoAtaca = true;
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
                    rangoAtaca = true;
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
                    rangoAtaca = true;
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
                    rangoAtaca = true;
                    //mov = 4;
                    //auxX = Amenaza.amenazas.get(i).X;
                    //auxY = Amenaza.amenazas.get(i).Y;
                    return true;
                }
            }
        }
        rangoAtaca = false;
        return false;
        
    }


    //implementacion del metodo abstracto
    public void moverAgente(){
        int numRand = (int)Math.floor(Math.random()*(4-1+1)+1);
        this.direccion = numRand;

        if (mov == 1){
            Recurso actual = new Recurso();
            Obstaculo obsActual = new Obstaculo();
            Amenaza ameActual = new Amenaza();
            if (direccion == 1){
                if (Y-15 > 0){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida(); // Antes era Amenaza.bajarVida()
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(1, X, Y) == true) && (obsActual.pruebaColision(1, X, Y) == true)){
                            if (actual.pruebaColision(1, X, Y) == true){
                                if (Recolector.VerificaCoor(1, X, Y) == true){
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

                        actual.bajarVida(); // Antes era Recurso.bajarVida()
                    }
                    
                }
            }
            if (direccion == 2){
                if (X + 15 <= 736){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida();
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(2, X, Y) == true) && (obsActual.pruebaColision(2, X, Y) == true)){
                            if (actual.pruebaColision(2, X, Y) == true){
                                if (Recolector.VerificaCoor(2, X, Y) == true){
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
                        
                        actual.bajarVida();
                    }
                    
                }
            }
            if (direccion == 3){
                if (Y+15 <= 736){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida();
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(3, X, Y) == true) && (obsActual.pruebaColision(3, X, Y) == true)){
                            if (actual.pruebaColision(3, X, Y) == true){
                                if (Recolector.VerificaCoor(3, X, Y) == true){
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

                        actual.bajarVida();
                    }
                    
                }
            }
            if (direccion == 4){
                if (X-15 > 0){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida();
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(4, X, Y) == true) && (obsActual.pruebaColision(4, X, Y) == true)){
                            if (actual.pruebaColision(4, X, Y) == true){
                                if (Recolector.VerificaCoor(4, X, Y) == true){
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

                        actual.bajarVida();
                    }
                }
            }
        }
        if (mov == 2){
            Recurso actual = new Recurso();
            Obstaculo obsActual = new Obstaculo();
            // incluir amenazas
            if (X != 1){
                if (VerificaCoor2(4, X, Y) == true){
                    if (obsActual.pruebaColision(4, X, Y) == true){
                        if (actual.pruebaColision(4, X, Y) == true){
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
                    if (VerificaCoor2(1, X, Y) == true){
                        if (obsActual.pruebaColision(4, X, Y) == true){
                            if (actual.pruebaColision(4, X, Y) == true){
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
            System.out.println("Se encontró amenaza2");
            /*if (rangoAtaca == true){
                System.out.println("Se encontró amenaza");
            }*/
        }
        
    }

    public void accionAgente(){
        carry = false;
    }

    public void paintDef(Graphics g){
        if (mov == 1){
            g.setColor(Color.red);
            g.fillRect(X, Y, 14, 14);
        }
        if (mov == 2){
            g.setColor(Color.red);
            g.fillRect(X, Y, 14, 14);

            g.setColor(Color.GREEN);
            g.fillRect(X+3, Y+3, 7, 7);
        }
        
    }
}