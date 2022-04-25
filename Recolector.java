// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Recolector

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.*;

public class Recolector extends Agente{
    public boolean rangoHuida;
    private int limite;
    private int direccion2;

    static ArrayList<Recolector> recolectores = new ArrayList<Recolector>();

    Random random = new Random();
    int rnd = random.nextInt(42);

    public Recolector(){
        rangoBusca = false;
        limite = 0;
    }

    // Pinta el cuerpo en pantalla
    public void paintAgente(Graphics g){
        if (movimiento == 1){
            g.setColor(Color.black);
            g.fillRect(posX, posY, 14, 14);
        }
        if (movimiento == 2){
            g.setColor(Color.black);
            g.fillRect(posX, posY, 14, 14);

            g.setColor(Color.green);
            g.fillRect(posX+3, posY+3, 7, 7);
        }
        
    }

    // Verifica que no colisione con otro recolector
    public boolean verificaBusqueda(int dir, int xA, int yA){
        for (int i=0;i<recolectores.size();i++) {
            if (dir == 1){
                if (recolectores.get(i).posX == xA){
                    if (recolectores.get(i).posY == yA - 15) {
                        return false;
                    }
                }
            }
            if (dir == 2){
                if (recolectores.get(i).posY == yA){
                    if (recolectores.get(i).posX == xA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 3){
                if (recolectores.get(i).posX == xA){
                    if (recolectores.get(i).posY == yA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 4){
                if (recolectores.get(i).posY == yA){
                    if (recolectores.get(i).posX == xA - 15) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Busca recursos cercanos
    public boolean calcularArea(int xA, int yA){
        for (int i=0;i<Recurso.listaRecursos1.size();i++) { 
            if (Recurso.listaRecursos1.get(i).coorX == xA){ 
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) { 
                    rangoBusca = true;
                    return true;
                }
            }
            if (Recurso.listaRecursos1.get(i).coorX == xA - 15){ 
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) {
                    rangoBusca = true;
                    return true;
                }
            }
            if (Recurso.listaRecursos1.get(i).coorX == xA + 15){ 
                if (Recurso.listaRecursos1.get(i).coorY == yA - 15) {
                    rangoBusca = true;
                    return true;
                }
            }
            if (Recurso.listaRecursos1.get(i).coorY == yA){ 
                if (Recurso.listaRecursos1.get(i).coorX == xA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
            if (Recurso.listaRecursos1.get(i).coorX == xA){ 
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
            if (Recurso.listaRecursos1.get(i).coorX == xA - 15){ 
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
            if (Recurso.listaRecursos1.get(i).coorX == xA + 15){ 
                if (Recurso.listaRecursos1.get(i).coorY == yA + 15) {
                    rangoBusca = true;
                    return true;
                }
            }
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

    // Busca amenazas cercanas para así saber que debe huir
    public boolean accionAgente(int xA, int yA){ 

        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { 
            if (Amenaza.listaAmenazas.get(i).coorX == xA){
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) { 
                    rangoHuida = true;
                    direccion2 = 1;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA - 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) {
                    rangoHuida = true;
                    direccion2 = 1;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA + 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) {
                    rangoHuida = true;
                    direccion2 = 1;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorY == yA){ 
                if (Amenaza.listaAmenazas.get(i).coorX == xA + 15) {
                    rangoHuida = true;
                    direccion2 = 0;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoHuida = true;
                    direccion2 = 0;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA - 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoHuida = true;
                    direccion2 = 0;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA + 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoHuida = true;
                    direccion2 = 0;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorY == yA){ 
                if (Amenaza.listaAmenazas.get(i).coorX == xA - 15) {
                    rangoHuida = true;
                    direccion2 = 0;
                    return true;
                }
            }
        }
        return false; 
    }

    // Desplaza el cuerpo del defensor según el set de movimiento o los objetos que tenga cerca
    public void moverAgente(){
        int numRand = (int)Math.floor(Math.random()*(4-1+1)+1);
        this.direccion = numRand;

        // Primer set de movimiento = Búsqueda de objetivos y reacciones
        if (movimiento == 1){
            Recurso actual2 = new Recurso();
            Obstaculo obsActual2 = new Obstaculo();
            Defensor defActual2 = new Defensor();
            
            if (rangoHuida == true && rangoBusca == false){
                if ((posY-15 > 0) && (posX + 15 <= 736) && (posY+15 <= 736) && (posX-15 > 0)){
                    System.out.println("Huir");
                    if (limite == 4){
                        rangoHuida = false;
                        limite = 0;
                    }
                    else{
                        if (direccion2 == 0){
                            posY -= 15;
                        }
                        else{
                            posY += 15;
                        }
                        limite += 1;
                    }
                }

            }
            if (rangoBusca == false && rangoHuida == false){
                if ((verificaBusqueda(direccion, posX, posY) == true) && (defActual2.verificaBusqueda(direccion, posX, posY) == true)){
                    if (obsActual2.pruebaColision(direccion, posX, posY) == true){
                        if (direccion == 1){
                            if (posY-15 > 0){
                                posY -= 15;
                            }
                        }
                        if (direccion == 2){
                            if (posX + 15 <= 736){
                                posX += 15;
                            }
                        }
                        if (direccion == 3){
                            if (posY+15 <= 736){
                                posY += 15;
                            }
                        }
                        if (direccion == 4){
                            if (posX-15 > 0){
                                posX -= 15;
                            }
                        }
                    }
                }
            }
            if (rangoBusca == true){
                movimiento = 2;
                rangoBusca = false;
                actual2.bajarVida();
            }
        }

        // Segundo set de movimiento = Ruta de vuelta al hormiguero
        if (movimiento == 2){
            Recurso actual2 = new Recurso();
            Obstaculo obsActual2 = new Obstaculo();
            Amenaza ameActual2 = new Amenaza();
            Defensor defActual2 = new Defensor();
            if (posX != 1){
                if ((verificaBusqueda(4, posX, posY) == true) && (defActual2.verificaBusqueda(4, posX, posY) == true)){
                    if ((ameActual2.pruebaColision(4, posX, posY) == true) && (actual2.pruebaColision(4, posX, posY) == true)){
                        if (obsActual2.pruebaColision(4, posX, posY) == true){
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
                    if ((verificaBusqueda(1, posX, posY) == true) && (defActual2.verificaBusqueda(1, posX, posY) == true)){
                        if ((ameActual2.pruebaColision(1, posX, posY) == true) && actual2.pruebaColision(1, posX, posY) == true){
                            if (obsActual2.pruebaColision(1, posX, posY) == true){
                                posY -= 15;
                            }
                            else{
                                posX += 15;
                            }
                        }
                        else{
                            posX += 15;
                        }
                    }
                    else{
                        posX += 15;
                    }
                }
                else{ // Cuando llega al hormiguero
                    movimiento = 1;
                }
            }
        }
    }
}