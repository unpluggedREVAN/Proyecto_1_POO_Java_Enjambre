
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;



/**
 *
 * @author Diana
 */
public class Amenaza {
    //private int posicion;
    public int vida;
    public int X;
    public int Y;
    
    static ArrayList<Amenaza> amenazas = new ArrayList<Amenaza>();
    
    
    public Amenaza(){
        //posicion= ;
        vida = 5;
    }
    
    public void reaccion(){
        if (vida <= 0){
            respawn();
            vida = 5;

        }
    }

    static public void respawn(){
        int numRandom = (int)Math.floor(Math.random()*(49-1)+1);
        int multiplo = (numRandom * 15) + 1;

        for (int i = 0; i < amenazas.size(); i++){
            if (i == 0 || i == 3){
                amenazas.get(i).X = multiplo;
            }
            else{
                amenazas.get(i).X = multiplo + 15;
            }
        }

        numRandom = (int)Math.floor(Math.random()*(49-1)+1);
        multiplo = (numRandom * 15) + 1;

        for (int i = 0; i < amenazas.size(); i++){
            if (i == 0 || i == 1){
                amenazas.get(i).Y = multiplo;
            }
            else{
                amenazas.get(i).Y = multiplo + 15;
            }
        }
    }


    public int getVida(){
        return vida;
    }

    static public void bajarVida(){
        for (int i=0;i<amenazas.size();i++){
            amenazas.get(i).vida -= 1;
            //Recurso.vida -= 1;
            //System.out.println(Recurso.vida);
        }
    }
    
    //public void moverAgente(){}
    
    public void paintAme(Graphics g){
        if (vida > 0){
            g.setColor(Color.yellow);
            g.fillRect(X, Y, 14, 14);
        }
        else{
            g.setColor(Color.PINK);
            g.fillRect(X, Y, 14, 14);
        }
    }
}
