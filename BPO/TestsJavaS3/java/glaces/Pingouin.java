package glaces;

import geometrie.*;
import java.util.*;
import java.lang.*;

/**
 * Un pingouin
 * 
 * @author Mathieu Hugo, Université de Lorraine
 */
public class Pingouin {

    private Point position;
    private int taille;
     /**
     * Construction
     */
    public Pingouin() {
        this.position = new Point(299, 0);
        this.taille = 2;
    }

    public Pingouin(Point pos, int t) {
        this.position = pos;
        this.taille = t;
    }

    public int getTaille() {
        return this.taille;
    }

    public Point getPosition() {
        return this.position;
    }

    public void deplacerDroite() {
        this.position = new Point (this.position.getAbscisse() + this.getTaille(), this.position.getOrdonnee());
    }

    public void deplacerGauche() {
        this.position = new Point (this.position.getAbscisse() - this.getTaille(), this.position.getOrdonnee());
    }

    public void deplacerHaut() {
        this.position = new Point (this.position.getAbscisse(), this.position.getOrdonnee() + this.getTaille());
    }

    public void deplacerBas() {
        this.position = new Point (this.position.getAbscisse(), this.position.getOrdonnee() - this.getTaille());
    }
}
