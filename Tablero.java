// Proyecto enjambre - POO
// Diana Sanabria (-) / Jose Pablo Agüero Mora (2021126372) 
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
    //ArrayList<Recolector> recolectores = new ArrayList<Recolector>(); // Genera un arreglo de objetos clase Ficha
    int[] posObsX = new int[]{271,286,271,286, 91,106,91,106, 271,286,271,286};
    int[] posObsY = new int[]{271,271,286,286, 271,271,286,286, 136,136,151,151}; 

    int[] posRecuX = new int[]{376,391,376,391, 1191,1106,1191,1106};
    int[] posRecuY = new int[]{151,151,166,166, 1271,1271,1286,1286}; 

    int generalX = 76;
    int generalY = 76;

    public Tablero(){
        frame = new JFrame("Proyecto Enjambre - POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,860,800);
        crearTablero(1, 0, 0);
        frame.setVisible(true);
        ingresaRecolector();
        ingresaDefensor();
        ingresaObstaculo();
        ingresaRecurso();
        //ingresaDefensor();
    }

    /*public void actualizarPantalla(){
        JPanel temp=this.getCon();
        SwingUtilities.updateComponentTreeUI(temp);;
        this.validateTree();
    }*/
        


    public void ingresaRecolector (){ // Método prueba
        int cont = 0;
        while (cont <= 5){
            Recolector prRec = new Recolector();
            generalX += 30;
            prRec.X = generalX;
            generalY += 30;
            prRec.Y = generalY;
            prRec.rangoBusca = false;
            prRec.mov = 1;
            Recolector.recolectores.add(prRec);
            //recolectores.add(prRec);
            cont += 1;
        }

        Recolector testR = new Recolector(); // Solo para pruebas
        testR.X = 421;
        testR.Y = 166;
        testR.mov = 1;
        Recolector.recolectores.add(testR);
    }

    public void ingresaDefensor (){ // Método prueba
        int cont = 0;
        while (cont <= 5){
            Defensor prDef = new Defensor();
            generalX += 45;
            prDef.X = generalX;
            generalY += 30;
            prDef.Y = generalY;
            prDef.rangoBusca = false;
            prDef.mov = 1;
            Defensor.defensores.add(prDef);
            //recolectores.add(prRec);
            cont += 1;
        }

        Defensor testD = new Defensor(); // Solo para pruebas
        testD.X = 421;
        testD.Y = 136;
        testD.mov = 1;
        Defensor.defensores.add(testD); 
    }

    public void ingresaObstaculo (){ // Método prueba
        for (int i = 0; i < posObsX.length; i++){
            Obstaculo prObs = new Obstaculo();
            prObs.X = posObsX[i];
            prObs.Y = posObsY[i];
            Obstaculo.obstaculos.add(prObs);
        }
    }

    public void ingresaRecurso (){ // Método prueba
        for (int i = 0; i < posObsX.length; i++){
            Recurso prRecu = new Recurso();
            prRecu.X = posRecuX[i];
            prRecu.Y = posRecuY[i];
            Recurso.recursos.add(prRecu);
        }
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
                        //g.setColor(new Color(212, 212, 212));
                        g.drawRect(x*15, y*15, 15, 15);
                        //g.setColor(new Color(31, 21, 1));
                        //g.fillRect(x*64, y*64, 64, 64);
                        //g.fillRect(x*64, y*64, 64, 64);
                        //g.drawRect(start.x, start.y, start.width, start.height);
                    }
                }

                for (int i=0;i<Recolector.recolectores.size();i++) { // Ciclo que recorre la lista fichas
                    Recolector.recolectores.get(i).paintRec(g);
                }

                for (int i=0;i<Obstaculo.obstaculos.size();i++) { // Ciclo que recorre la lista fichas
                    Obstaculo.obstaculos.get(i).dibujar(g);
                }

                for (int i=0;i<Recurso.recursos.size();i++) { // Ciclo que recorre la lista fichas
                    Recurso.recursos.get(i).dibujar(g);
                }

                for (int i=0;i<Defensor.defensores.size();i++) { // Ciclo que recorre la lista fichas
                    Defensor.defensores.get(i).paintDef(g);
                }

                Hormiguero mapa = new Hormiguero();
                mapa.dibujar(g);

                //testR.paintRec(g); // individual

                /*if (opcion == 2){
                    System.out.println("Entró en la opción"); // Prueba
                    g.setColor(Color.red);
                    g.fillRect(x, y, 14, 14);
                } */
                //g.setColor(Color.red);
                //g.fillRect(1, 1, 14, 14);

                //g.setColor(Color.blue);
                //g.fillRect(46, 31, 14, 14);
            }
        };
        frame.add(pn, BorderLayout.CENTER);
        botonPrincipal = new JButton("Partida");
        botonPrincipal.addActionListener(this);

        panelBotones = new JPanel();
        //panelBotones.setLayout(new GridLayout(3, 1));
        panelBotones.add(botonPrincipal);
        
        frame.add(panelBotones, BorderLayout.EAST);
        //frame.add(pn);
        //frame.add(panelBotones, BorderLayout.CENTER);
    }

    public void moverTodos(){
        for (int i=0;i<Recolector.recolectores.size();i++) { // Ciclo que recorre la lista fichas
            Recolector.recolectores.get(i).moverAgente();
            int varX = Recolector.recolectores.get(i).X;
            int varY = Recolector.recolectores.get(i).Y;
            Recolector.recolectores.get(i).calcularArea(varX, varY);


            
            
            
            //int varX = recolectores.get(i).X;
            //System.out.println(varX);

            //int varY = recolectores.get(i).Y;
            //System.out.println(varY);
        }
        for (int i=0;i<Defensor.defensores.size();i++) { // Ciclo que recorre la lista fichas
            Defensor.defensores.get(i).moverAgente();
            int varDX = Defensor.defensores.get(i).X;
            int varDY = Defensor.defensores.get(i).Y;
            Defensor.defensores.get(i).calcularArea(varDX, varDY);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(botonPrincipal)){
            //System.out.println("Se presionó el botón principal");
            //testR.moverAgente();
            moverTodos();
            //System.out.println("Se presionó el botón principal");
            //int xRec = testR.X;
            //int yRec = testR.Y;
            //crearTablero(2, xRec, yRec);
            //repaint();
            frame.repaint();
        }
    }


}
