package glaces;

import geometrie.Point;

/**
 * Un iceberg rectangulaire
 * 
 * @author Martine Gautier et Mathieu Hugo, Université de Lorraine
 */
public class Iceberg2D {

    private Point enBasAGauche;
    private Point enHautADroite;

    /**
     * Construction
     * 
     * @param g le coin en bas à gauche
     * @param d le coin en haut à droite uniquement en coordonnées positives
     */
    public Iceberg2D(Point g, Point d) {
        /**
         * Initialise un iceberg à partir de ses deux extrémité
         * 
         * @param g le coin en bas à gauche
         * @param d le coin en haut à droite
         */
        enBasAGauche = g;
        enHautADroite = d;
    }

    /**
     * Construction par fusion de deux icebergs qui se touchent
     * 
     * @param i1 premier iceberg à fusionner
     * @param i2 deuxième iceberg à fusionner
     */
    public Iceberg2D(Iceberg2D i1, Iceberg2D i2) {
        enBasAGauche = new Point(Math.min(i1.enBasAGauche.getAbscisse(), i2.enBasAGauche.getAbscisse()),
                Math.min(i1.enBasAGauche.getOrdonnee(), i2.enBasAGauche.getOrdonnee()));
        enHautADroite = new Point(Math.max(i1.enHautADroite.getAbscisse(), i2.enHautADroite.getAbscisse()),
                Math.max(i1.enHautADroite.getOrdonnee(), i2.enHautADroite.getOrdonnee()));
    }

    /**
     * Retourne le coin en bas à gauche
     * 
     * @return le coin en bas à gauche
     */
    public Point coinEnBasAGauche() {
        return this.enBasAGauche;
    }

    /**
     * Retourne le coin en haut à droite
     * 
     * @return le coin en haut à droite
     */
    public Point coinEnHautADroite() {
        return this.enHautADroite;
    }

    /**
     * Retourne la hauteur
     * 
     * @return hauteur
     */
    public double hauteur() {
        return this.coinEnHautADroite().getOrdonnee() - this.coinEnBasAGauche().getOrdonnee();
    }

    /**
     * Retourne la largeur
     * 
     * @return largeur
     */
    public double largeur() {
        return this.coinEnHautADroite().getAbscisse() - this.coinEnBasAGauche().getAbscisse();
    }

    /**
     * Retourne la surface totale
     * 
     * @return surface totale
     */
    public double surface() {
        return this.largeur() * this.hauteur();
    }

    /**
     * Retourne vrai si il y a une collision entre les deux icebergs
     * 
     * @param i iceberg potentiellement en collision
     * @return vrai si collision entre les deux icebergs
     */
    public boolean collision(Iceberg2D i) {
        // Tous les cas de collisions ne semble pas être couvert.
        return ((i.coinEnBasAGauche().getAbscisse() <= coinEnHautADroite().getAbscisse()
                && i.coinEnBasAGauche().getOrdonnee() <= coinEnHautADroite().getOrdonnee())
                && (coinEnBasAGauche().getAbscisse() <= i.coinEnHautADroite().getAbscisse()
                        && coinEnBasAGauche().getOrdonnee() <= i.coinEnHautADroite().getOrdonnee()));
    }

    /**
     * Retourne vrai si this est plus volumineux que i
     * 
     * @param i iceberg à comparer
     * @return vrai si this est plus volumineux que i
     */
    public boolean estPlusGrosQue(Iceberg2D i) {
        return this.surface() > i.surface();
    }

    public String toString() {
        return this.enBasAGauche + " " + this.enHautADroite;
    }

    /**
     * Retourne le point au centre
     * 
     * @return le point au centre de l'iceberg
     */
    public Point centre() {
        return new Point(this.largeur() / 2.0 + this.coinEnBasAGauche().getAbscisse(),
                this.hauteur() / 2.0 + this.coinEnBasAGauche().getOrdonnee());
    }

    /**
     * Réduction dans les quatre directions ; le centre ne bouge pas
     * 
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void fondre(double fr) {
        double l = (this.largeur() * fr) / 2.0;
        double h = (this.hauteur() * fr) / 2.0;

        this.enBasAGauche.deplacer(l, h);
        this.enHautADroite.deplacer(-l, -h);
    }

    /**
     * Casser une partie à droite
     * 
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserDroite(double fr) {
        enHautADroite = new Point(this.coinEnHautADroite().getAbscisse() * (1 - fr),
                this.coinEnHautADroite().getOrdonnee());
    }

    /**
     * Casser une partie à gauche
     * 
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserGauche(double fr) {
        enBasAGauche = new Point(this.coinEnBasAGauche().getAbscisse() * (1 + fr),
                this.coinEnBasAGauche().getOrdonnee());
    }

    /**
     * Casser une partie en haut
     * 
     * @param fr dans ]0..1[ facteur de réduction
     */
    public void casserHaut(double fr) {
        enHautADroite = new Point(this.coinEnHautADroite().getAbscisse(),
                this.coinEnHautADroite().getOrdonnee() * (1 - fr));
    }

    /**
     * Casser une partie en bas
     * 
     * @param fr dans ]0..1[ : définit le pourcentage supprimé
     */
    public void casserBas(double fr) {
        enBasAGauche = new Point(this.coinEnBasAGauche().getAbscisse(),
                this.coinEnBasAGauche().getOrdonnee() * (1 + fr));
    }

}
