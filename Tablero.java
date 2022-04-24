// Proyecto enjambre - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Tablero

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablero implements ActionListener{
    JFrame frame;
    JPanel panelBotones;
    JButton botonPrincipal;

    public Tablero(){
        frame = new JFrame("Proyecto Enjambre - POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,860,800);
        crearTablero(1, 0, 0);
        frame.setVisible(true);
        ordenaElementos();
    }

    public void ordenaElementos(){
        ingresaRecolector();
        ingresaDefensor();
        ingresaObstaculo();
        ingresaRecurso();
        ingresaAmenaza();
    }

    public void ingresaRecolector (){ // Método prueba
        int cont = 0;
        while (cont <= 16){
            int numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            int multiplo = (numRandom * 15) + 1;

            Recolector prRec = new Recolector();
            prRec.X = multiplo;

            numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            multiplo = (numRandom * 15) + 1;
            prRec.Y = multiplo;

            prRec.rangoBusca = false;
            prRec.mov = 1;
            Recolector.recolectores.add(prRec);
            Agente.agentes.add(prRec);
            cont += 1;
        }
    }

    public void ingresaDefensor (){ // Método prueba
        int cont = 0;
        while (cont <= 17){
            int numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            int multiplo = (numRandom * 15) + 1;

            Defensor prDef = new Defensor();
            prDef.X = multiplo;

            numRandom = (int)Math.floor(Math.random()*(49-1)+1);
            multiplo = (numRandom * 15) + 1;
            prDef.Y = multiplo;

            prDef.rangoBusca = false;
            prDef.mov = 1;
            Defensor.defensores.add(prDef);
            Agente.agentes.add(prDef);
            cont += 1;
        }
    }

    public void ingresaObstaculo (){ // Método prueba
        for (int i = 0; i < Obstaculo.posObsX.length; i++){
            Obstaculo prObs = new Obstaculo();
            prObs.coorX = Obstaculo.posObsX[i];
            prObs.coorY = Obstaculo.posObsY[i];
            Obstaculo.listaObstaculos.add(prObs);
        }
    }

    public void ingresaRecurso (){ // Método prueba // Aquí tiraba la excepción del out of bounds
        for (int i = 0; i < Recurso.posRecuX.length; i++){
            Recurso prRecu = new Recurso();
            prRecu.coorX = Recurso.posRecuX[i];
            prRecu.coorY = Recurso.posRecuY[i];
            Recurso.listaRecursos1.add(prRecu);
        }
        Recurso insRecurso = new Recurso();
        insRecurso.respawnObjeto();
    }

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

    private void crearTablero(int opcion, int x, int y){
        frame.setBounds(50,50,860,800);
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
                    Recolector.recolectores.get(i).paintRec(g);
                }

                for (int i=0;i<Defensor.defensores.size();i++) { 
                    Defensor.defensores.get(i).paintDef(g);
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

        panelBotones = new JPanel();
        panelBotones.add(botonPrincipal);
        frame.add(panelBotones, BorderLayout.EAST);
    }

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
            int varX = Recolector.recolectores.get(i).X;
            int varY = Recolector.recolectores.get(i).Y;
            Recolector.recolectores.get(i).calcularArea(varX, varY);
            Recolector.recolectores.get(i).calcularHuida(varX, varY);
            Recolector.recolectores.get(i).moverAgente();
        }
        for (int i=0;i<Defensor.defensores.size();i++) {
            int varDX = Defensor.defensores.get(i).X;
            int varDY = Defensor.defensores.get(i).Y;
            Defensor.defensores.get(i).calcularAreaAtaque(varDX, varDY);
            Defensor.defensores.get(i).calcularArea(varDX, varDY);
            Defensor.defensores.get(i).moverAgente();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(botonPrincipal)){
            moverTodos();
            frame.repaint();
        }
    }
}
