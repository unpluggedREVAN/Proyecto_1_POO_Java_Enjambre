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

    public boolean verificaBusqueda(int dir, int xA, int yA){
        return true;
    }

    static public boolean VerificaCoor2(int dir, int xA, int yA){
        if (dir == 1){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).posX == xA){
                    if (defensores.get(i).posY == yA - 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 2){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).posY == yA){
                    if (defensores.get(i).posX == xA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 3){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).posX == xA){
                    if (defensores.get(i).posY == yA + 15) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (dir == 4){
            for (int i=0;i<defensores.size();i++) { // Ciclo que recorre la lista fichas
                if (defensores.get(i).posY == yA){
                    if (defensores.get(i).posX == xA - 15) {
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

        if (movimiento == 1){
            Recurso actual = new Recurso();
            Obstaculo obsActual = new Obstaculo();
            Amenaza ameActual = new Amenaza();
            Recolector recActual = new Recolector();
            if (direccion == 1){
                if (posY-15 > 0){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida(); // Antes era Amenaza.bajarVida()
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(1, posX, posY) == true) && (obsActual.pruebaColision(1, posX, posY) == true)){
                            if (actual.pruebaColision(1, posX, posY) == true){
                                if (recActual.verificaBusqueda(1, posX, posY) == true){
                                    posY -= 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        movimiento = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        actual.bajarVida(); // Antes era Recurso.bajarVida()
                    }
                    
                }
            }
            if (direccion == 2){
                if (posX + 15 <= 736){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida();
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(2, posX, posY) == true) && (obsActual.pruebaColision(2, posX, posY) == true)){
                            if (actual.pruebaColision(2, posX, posY) == true){
                                if (recActual.verificaBusqueda(2, posX, posY) == true){
                                    posX += 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        System.out.println("Se encontró recurso");
                        movimiento = 2;
                        System.out.println("Se va a devolver");
                        
                        actual.bajarVida();
                    }
                    
                }
            }
            if (direccion == 3){
                if (posY+15 <= 736){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida();
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(3, posX, posY) == true) && (obsActual.pruebaColision(3, posX, posY) == true)){
                            if (actual.pruebaColision(3, posX, posY) == true){
                                if (recActual.verificaBusqueda(3, posX, posY) == true){
                                    posY += 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        movimiento = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        actual.bajarVida();
                    }
                    
                }
            }
            if (direccion == 4){
                if (posX-15 > 0){
                    if (rangoAtaca == true && rangoBusca == false){
                        //mov = 4;
                        System.out.println("Se encontró amenaza1");

                        ameActual.bajarVida();
                    }
                    if (rangoBusca == false && rangoAtaca == false){
                        if ((VerificaCoor2(4, posX, posY) == true) && (obsActual.pruebaColision(4, posX, posY) == true)){
                            if (actual.pruebaColision(4, posX, posY) == true){
                                if (recActual.verificaBusqueda(4, posX, posY) == true){
                                    posX -= 15;
                                }
                            }
                        }
                    }
                    if (rangoBusca == true){
                        //mov = 3;
                        movimiento = 2;
                        System.out.println("Se va a devolver");
                        System.out.println("Se encontró recurso"); 

                        actual.bajarVida();
                    }
                }
            }
        }
        if (movimiento == 2){
            Recurso actual = new Recurso();
            Obstaculo obsActual = new Obstaculo();
            // incluir amenazas
            if (posX != 1){
                if (VerificaCoor2(4, posX, posY) == true){
                    if (obsActual.pruebaColision(4, posX, posY) == true){
                        if (actual.pruebaColision(4, posX, posY) == true){
                            posX -= 15;
                        }
                        else{
                            posY -= 15;
                        }
                    }
                    else{
                        posY -= 15;
                    }
                }
                else{
                    posY -= 15;
                }
            }
            else{
                if (posY != 1){
                    if (VerificaCoor2(1, posX, posY) == true){
                        if (obsActual.pruebaColision(4, posX, posY) == true){
                            if (actual.pruebaColision(4, posX, posY) == true){
                                posY -= 15;
                            }
                            else{
                                posX -= 15;
                            }
                        }
                        else{
                            posX -= 15;
                        }
                    }
                    else{
                        posX -= 15;
                    }
                }
                else{ // Cuando llega al hormiguero
                    movimiento = 1;
                }
            }
        }
        if (movimiento == 4){
            System.out.println("Se encontró amenaza2");
            /*if (rangoAtaca == true){
                System.out.println("Se encontró amenaza");
            }*/
        }
        
    }

    public boolean accionAgente(int xA, int yA){
        carry = false;
        return false;
    }

    public void paintAgente(Graphics g){
        if (movimiento == 1){
            g.setColor(Color.red);
            g.fillRect(posX, posY, 14, 14);
        }
        if (movimiento == 2){
            g.setColor(Color.red);
            g.fillRect(posX, posY, 14, 14);

            g.setColor(Color.GREEN);
            g.fillRect(posX+3, posY+3, 7, 7);
        }
        
    }
}