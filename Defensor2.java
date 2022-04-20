
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Diana
 */
public class Defensor2 extends Agente {
    private boolean atacar;
    private boolean rangoAtaque;
    static ArrayList<Defensor> defensores = new ArrayList<Defensor>();
    
    Random random = new Random();
    int rnd = random.nextInt(42);
    
    
    public Defensor2(){
        atacar= true;
        rangoAtaque= true;
    }
    
    public boolean VerificaCoor(int dir, int xA, int yA){
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
   
    public void moverAgente(){
        int numRand = (int)Math.floor(Math.random()*(4-1+1)+1);
        this.direccion = numRand;

        if (direccion == 1){
            if (Y-15 > 0){
                if (VerificaCoor(1, X, Y) == true){
                    Y -= 15;
                }
            }
        }
        if (direccion == 2){
            if (X + 15 <= 736){
                if (VerificaCoor(2, X, Y) == true){
                    X += 15;
                }
            }
        }
        if (direccion == 3){
            if (Y+15 <= 736){
                if (VerificaCoor(3, X, Y) == true){
                    Y += 15;
                }
            }
        }
        if (direccion == 4){
            if (X-15 > 0){
                if (VerificaCoor(4, X, Y) == true){
                    X -= 15;
                }
            }
        }
    }

    public void accionAgente(){
        atacar =true;
    }
    
    public void paintDef(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(X, Y, 14, 14);
    }
} 
