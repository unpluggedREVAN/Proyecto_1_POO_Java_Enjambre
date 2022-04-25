// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Defensor

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.*;

public class Defensor extends Agente{
    public boolean rangoBusca;
    public boolean rangoAtaca;

    static ArrayList<Defensor> defensores = new ArrayList<Defensor>();

    Random random = new Random();
    int rnd = random.nextInt(42);

    public Defensor(){
        rangoBusca = false;
        rangoAtaca = false;
    }

    // Pinta cuerpo en pantalla
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

    // Verifica que no colisione con otro defensor
    public boolean verificaBusqueda(int dir, int xA, int yA){
        for (int i=0;i<defensores.size();i++) { 
            if (dir == 1){
                if (defensores.get(i).posX == xA){
                    if (defensores.get(i).posY == yA - 15) {
                        return false;
                    }
                }
            }
            if (dir == 2){
                if (defensores.get(i).posY == yA){
                    if (defensores.get(i).posX == xA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 3){
                if (defensores.get(i).posX == xA){
                    if (defensores.get(i).posY == yA + 15) {
                        return false;
                    }
                }
            }
            if (dir == 4){
                if (defensores.get(i).posY == yA){
                    if (defensores.get(i).posX == xA - 15) {
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

    // Busca amenazas cercanas para así saber que debe atacar
    public boolean accionAgente(int xA, int yA){

        for (int i=0;i<Amenaza.listaAmenazas.size();i++) { 
            if (Amenaza.listaAmenazas.get(i).coorX == xA){
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) { 
                    rangoAtaca = true;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA - 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) {
                    rangoAtaca = true;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA + 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA - 15) {
                    rangoAtaca = true;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorY == yA){ 
                if (Amenaza.listaAmenazas.get(i).coorX == xA + 15) {
                    rangoAtaca = true;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoAtaca = true;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA - 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoAtaca = true;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorX == xA + 15){ 
                if (Amenaza.listaAmenazas.get(i).coorY == yA + 15) {
                    rangoAtaca = true;
                    return true;
                }
            }
            if (Amenaza.listaAmenazas.get(i).coorY == yA){ 
                if (Amenaza.listaAmenazas.get(i).coorX == xA - 15) {
                    rangoAtaca = true;
                    return true;
                }
            }
        }
        rangoAtaca = false;
        return false;
    }

    // Desplaza el cuerpo del defensor según el set de movimiento o los objetos que tenga cerca
    public void moverAgente(){
        int numRand = (int)Math.floor(Math.random()*(4-1+1)+1);
        this.direccion = numRand;

        // Primer set de movimiento = Búsqueda de objetivos y reacciones
        if (movimiento == 1){
            Recurso actual = new Recurso();
            Obstaculo obsActual = new Obstaculo();
            Recolector recActual = new Recolector();
            Amenaza ameActual = new Amenaza();
            
            if (rangoAtaca == true && rangoBusca == false){
                if ((posY-15 > 0) && (posX + 15 <= 736) && (posY+15 <= 736) && (posX-15 > 0)){
                    ameActual.bajarVida();
                }
            }
            if (rangoBusca == false && rangoAtaca == false){
                if ((verificaBusqueda(direccion, posX, posY) == true) && (recActual.verificaBusqueda(direccion, posX, posY) == true)){
                    if (obsActual.pruebaColision(direccion, posX, posY) == true){
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
                actual.bajarVida();
            }
        }

        // Segundo set de movimiento = Ruta de vuelta al hormiguero
        if (movimiento == 2){
            Recurso actual = new Recurso();
            Obstaculo obsActual = new Obstaculo();
            Recolector recActual = new Recolector();
            Amenaza ameActual = new Amenaza();
            if (posX != 1){
                if ((verificaBusqueda(4, posX, posY) == true) && (recActual.verificaBusqueda(4, posX, posY) == true)){
                    if ((ameActual.pruebaColision(4, posX, posY) == true) && (actual.pruebaColision(4, posX, posY) == true)){
                        if (obsActual.pruebaColision(4, posX, posY) == true){
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
                    if ((verificaBusqueda(1, posX, posY) == true) && (recActual.verificaBusqueda(1, posX, posY) == true)){
                        if ((ameActual.pruebaColision(1, posX, posY) == true) && actual.pruebaColision(1, posX, posY) == true){
                            if (obsActual.pruebaColision(1, posX, posY) == true){
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