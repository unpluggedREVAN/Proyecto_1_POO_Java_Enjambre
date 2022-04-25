// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Tablero

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero implements ActionListener{
    JFrame frame;
    JPanel panelBotones;
    JPanel panelIm;
    JButton botonPrincipal;
    JLabel simbolo;

    public Tablero(){
        frame = new JFrame("Proyecto Enjambre - POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,860,800);
        crearTablero(1, 0, 0);
        frame.setVisible(true);
        ordenaElementos();
    }

    // Crea todas las instancias de las demás clases
    public void ordenaElementos(){
        ingresaRecolector();
        ingresaDefensor();
        ingresaObstaculo();
        ingresaRecurso();
        ingresaAmenaza();
    }

    // Crea las instancias de Recolector
    public void ingresaRecolector (){ // Método prueba
        int cont = 0;
        while (cont <= 18){ // 16
            int numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            int multiplo = (numRandom * 15) + 1;

            Recolector prRec = new Recolector();
            prRec.posX = multiplo;

            numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            multiplo = (numRandom * 15) + 1;
            prRec.posY = multiplo;

            prRec.rangoBusca = false;
            prRec.movimiento = 1;
            Recolector.recolectores.add(prRec);
            cont += 1;
        }
    }

    // Crea las instancias de Defensor
    public void ingresaDefensor (){ // Método prueba
        int cont = 0;
        while (cont <= 22){ // 17
            int numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            int multiplo = (numRandom * 15) + 1;

            Defensor prDef = new Defensor();
            prDef.posX = multiplo;

            numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            multiplo = (numRandom * 15) + 1;
            prDef.posY = multiplo;

            prDef.rangoBusca = false;
            prDef.movimiento = 1;
            Defensor.defensores.add(prDef);
            cont += 1;
        }
    }

    // Crea las instancias de Obstaculo
    public void ingresaObstaculo (){ // Método prueba
        for (int i = 0; i < Obstaculo.posObsX.length; i++){
            Obstaculo prObs = new Obstaculo();
            prObs.coorX = Obstaculo.posObsX[i];
            prObs.coorY = Obstaculo.posObsY[i];
            Obstaculo.listaObstaculos.add(prObs);
        }
    }

    // Crea las instancias de Recurso
    public void ingresaRecurso (){ 
        for (int i = 0; i < Recurso.posRecuX.length; i++){
            Recurso prRecu = new Recurso();
            prRecu.coorX = Recurso.posRecuX[i];
            prRecu.coorY = Recurso.posRecuY[i];
            Recurso.listaRecursos1.add(prRecu);
        }
        Recurso insRecurso = new Recurso();
        insRecurso.respawnObjeto();
    }

    // Crea las instancias de Amenaza
    public void ingresaAmenaza (){ // Método prueba
        for (int i = 0; i < Amenaza.posAmeX.length; i++){
            Amenaza prAme = new Amenaza();
            prAme.coorX = Amenaza.posAmeX[i];
            prAme.coorY = Amenaza.posAmeY[i];
            Amenaza.listaAmenazas.add(prAme);
        }
        Amenaza insAmenaza = new Amenaza();
        insAmenaza.respawnObjeto();
    }

    // Genera el tablero inlcuyendo todos los elementos
    private void crearTablero(int opcion, int x, int y){
        frame.setBounds(50,50,1145,800);
        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for(int y = 0; y < 50; y++){
                    for(int x = 0; x < 50; x++){
                        g.setColor(Color.black);
                        g.drawRect(x*15, y*15, 15, 15);
                    }
                }

                for (int i=0;i<Recolector.recolectores.size();i++) { 
                    Recolector.recolectores.get(i).paintAgente(g);
                }

                for (int i=0;i<Defensor.defensores.size();i++) { 
                    Defensor.defensores.get(i).paintAgente(g);
                }

                for (int i=0;i<Recurso.listaRecursos1.size();i++) { 
                    Recurso.listaRecursos1.get(i).paintObjeto(g);
                }

                for (int i=0;i<Amenaza.listaAmenazas.size();i++) { 
                    Amenaza.listaAmenazas.get(i).paintObjeto(g);
                }

                for (int i=0;i<Obstaculo.listaObstaculos.size();i++) { 
                    Obstaculo.listaObstaculos.get(i).paintObjeto(g);
                }

                Hormiguero mapa = new Hormiguero();
                mapa.paintHormiguero(g);
            }
        };
        frame.add(pn, BorderLayout.CENTER);
        botonPrincipal = new JButton("Partida");
        botonPrincipal.addActionListener(this);

        // Sección para adjuntar la imagen - Se debe cambiar la ruta según cada caso
        simbolo = new JLabel();
        ImageIcon imagenInfo= new ImageIcon("D:\\Versiones de prueba finales POO proyecto Enjambre\\V Pre Release\\Proyecto_1_POO_Java_Enjambre-main\\symb.png");
        simbolo.setIcon(imagenInfo);
        panelIm = new JPanel();
        panelIm.add(simbolo);
        frame.add(panelIm,BorderLayout.WEST);
        // Fin sección para adjuntar la imagen

        panelBotones = new JPanel();
        panelBotones.add(botonPrincipal);
        frame.add(panelBotones, BorderLayout.EAST);
    }

    // Recorre todas las listas para invocar los métodos correspondientes en cada caso
    public void moverTodos(){
        for (int i=0;i<Amenaza.listaAmenazas.size();i++){
            Amenaza.listaAmenazas.get(i).verificaEstado();
            Amenaza.listaAmenazas.get(i).reacciona();
        }
        for (int i=0;i<Recurso.listaRecursos1.size();i++){
            Recurso.listaRecursos1.get(i).verificaEstado();
            Recurso.listaRecursos1.get(i).reacciona();
        }
        for (int i=0;i<Recolector.recolectores.size();i++) { 
            int varX = Recolector.recolectores.get(i).posX;
            int varY = Recolector.recolectores.get(i).posY;
            Recolector.recolectores.get(i).calcularArea(varX, varY);
            Recolector.recolectores.get(i).accionAgente(varX, varY);
            Recolector.recolectores.get(i).moverAgente();
        }
        for (int i=0;i<Defensor.defensores.size();i++) {
            int varDX = Defensor.defensores.get(i).posX;
            int varDY = Defensor.defensores.get(i).posY;
            Defensor.defensores.get(i).accionAgente(varDX, varDY);
            Defensor.defensores.get(i).calcularArea(varDX, varDY);
            Defensor.defensores.get(i).moverAgente();
        }
    }

    // Método con instrucciones cuando se presiona el botón
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(botonPrincipal)){
            moverTodos();
            frame.repaint();
        }
    }
}
