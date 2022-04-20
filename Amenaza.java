
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
        vida= 10;
    }
    
    public void accionAgente(){
        vida -=1;
    }
    public int getVida(){
        return vida;
    }
    
    public void moverAgente(){}
    
    public void paintDef(Graphics g){
        g.setColor(Color.green);
        g.fillRect(X, Y, 14, 14);
    }
     
}
