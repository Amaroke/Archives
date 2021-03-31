package glaces;

import geometrie.*;
import java.util.*;

/**
 * Un poisson
 * 
 * @author Mathieu Hugo, Université de Lorraine
 */
public class Poisson {

    private Point position;
    private int hauteur;
    private int largeur;
    private int sens; //1 deplacement vers le haut 2 vers le bas 3 vers la gauche 4 vers la droite

    /**
     * Construction
     */
    public Poisson() {
        /**
         * Initialise un Poisson ...
        */
        Random r = new Random();
        this.position = new Point(0,0);
        this.largeur = r.nextInt(10);
        this.hauteur = r.nextInt(10);
        this.sens = 1+r.nextInt(4);
    }

    public Point getPosition(){
        return this.position;
    }

    public int getLargeur(){
        return this.largeur;
    }

    public int getHauteur(){
        return this.hauteur;
    }

    public void deplacement(){
        if (sens == 1) {
            this.position = new Point (this.position.getAbscisse(), this.position.getOrdonnee()+1);
        }
        else if (sens == 2) {
            this.position = new Point (this.position.getAbscisse(), this.position.getOrdonnee()-1);
        }
        else if (sens == 3) {
            this.position = new Point (this.position.getAbscisse()-1, this.position.getOrdonnee());
        }
        else if (sens == 4) {
            this.position = new Point (this.position.getAbscisse()+1, this.position.getOrdonnee());
        }
    }
}
