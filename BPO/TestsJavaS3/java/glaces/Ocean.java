package glaces;

import geometrie.*;
import java.util.*;
import java.lang.*;

/**
 * Un océan d'iceberg2D
 * 
 * @author Mathieu Hugo, Université de Lorraine
 */
public class Ocean {

    private Iceberg2D[] ice;
    private int largeur;
    private int hauteur;
    private Pingouin p;

    /**
     * Construction
     */
    public Ocean() {
        /**
         * Initialise un Ocean en fixant une hauteur et une largeur et place deux
         * icebergs a une position fixe, (10,10;20;20) et (50,50;200,200)
         */
        this.largeur = 300;
        this.hauteur = 300;
        this.ice = new Iceberg2D[2];
        this.ice[0] = new Iceberg2D(new Point(10, 10), new Point(20, 20));
        this.ice[1] = new Iceberg2D(new Point(50, 50), new Point(200, 200));
        this.p = new Pingouin();
    }

    public Ocean(int nb, int l, int h) {
        /**
         * Initialise un ocean avec une largeur, une hauteur et un nombre d'icebergs
         * donnés
         * 
         * @param nb le nombre d'iceberg.
         * @param l  la largeur
         * @param h  la hauteur
         */
        Random r = new Random();
        this.largeur = l;
        this.hauteur = h;
        this.ice = new Iceberg2D[nb];
        for (int i = 0; i < nb; ++i) {
            Point basGauche = new Point(r.nextInt(l - 20 * l / 100), r.nextInt(h - 20 * h / 100));
            // Je place le premier point aleatoirement sur le tableau en l'eloignant de 20%
            // du bord de l'ocean.
            Point hautDroite = new Point(basGauche.getAbscisse() + (l / 10) + r.nextInt(l / 10),
                    basGauche.getOrdonnee() + (h / 10) + r.nextInt(h / 10));
            // Je place le deuxieme point de l'iceberg au dessus et plus a droite du premier
            // avec une taille d'au moins 10% de l'ocean et potentiellement 10 autre %.
            this.ice[i] = new Iceberg2D(basGauche, hautDroite);
            this.p = new Pingouin(new Point(l - 1, 0), 10);
        }
    }

    public Pingouin getPingouin() {
        return this.p;
    }

    public String toString() {
        return "Largeur : " + this.largeur + " Hauteur : " + this.hauteur + " Nombre d'icebergs : " + this.ice.length;
    }

    /**
     * Retourne le nombre d'icebergs
     * 
     * @return le nombre d'icebergs
     */
    public int getCount() {
        return this.ice.length;
    }

    /**
     * Retourne la largeur
     * 
     * @return largeur
     */
    public int getWidth() {
        return this.largeur;
    }

    /**
     * Retourne la hauteur
     * 
     * @return hauteur
     */
    public int getHeight() {
        return this.hauteur;
    }

    /**
     * Retourne un tableau composé de 0 ou de 1
     * 
     * @return tableau de 0 et 1
     */
    public int[][] getColors() {
        int[][] tabfinal = new int[this.getWidth()][this.getHeight()];
        // Je parcours les icebergs
        for (Iceberg2D iceberg : this.ice) {
            // Je parcours les lignes de mon tableau
            for (int k = 0; k < this.getWidth(); ++k) {
                // Je parcours les colonnes de mon tableau
                for (int l = 0; l < this.getHeight(); ++l) {
                    // Si la case ou je suis est sur un iceberg alors je met cette case à 2.
                    if (k >= this.getPingouin().getPosition().getAbscisse() - this.getPingouin().getTaille()
                            && l <= this.getPingouin().getPosition().getOrdonnee() + this.getPingouin().getTaille()
                            && k <= this.getPingouin().getPosition().getAbscisse()
                            && l >= this.getPingouin().getPosition().getOrdonnee()) {
                        tabfinal[k][l] = 2;
                    }
                    // Si la case ou je suis est sur un iceberg alors je met cette case à 1
                    else if (k < iceberg.coinEnHautADroite().getAbscisse()
                            && k > iceberg.coinEnBasAGauche().getAbscisse()
                            && l < iceberg.coinEnHautADroite().getOrdonnee()
                            && l > iceberg.coinEnBasAGauche().getOrdonnee() || tabfinal[k][l] == 1) {
                        tabfinal[k][l] = 1;
                    } else {
                        // Autrement je la met à 0
                        tabfinal[k][l] = 0;
                    }
                }
            }
        }
        return tabfinal;
    }

    /**
     * Réduction dans les quatre directions de tous les icebergs; les centres ne
     * bougent pas
     * 
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void fondre(double fr) {
        for (Iceberg2D iceberg : this.ice) {
            iceberg.fondre(fr);
        }
    }
}