package glaces;

import geometrie.*;
import java.util.*;

/**
 * Le jeu
 * 
 * @author Mathieu Hugo, Université de Lorraine
 */
public class Jeu {

    private Ocean o;
    private boolean partie_en_cours;
    ArcticImage img;

    /**
     * Construction d'un jeu avec un ocean une articimage et l'etat de la partie
     */
    public Jeu() {
        this.o = new Ocean(3, 500, 500);
        this.partie_en_cours = true;
        this.img = new ArcticImage(500, 500);
    }

    public void jouer() {
        this.img.setColors(this.o.getColors());
        //On continue de jouer tant que l'on a pas mis fin à la partie
        while (this.partie_en_cours) {
            // On récupère le déplacement souhaité
            Scanner scan = new Scanner(System.in);
            System.out.print("Vers où se déplacer (z, q, s, d) ou autre chose pour finir la partie : ");
            char choix = scan.next().charAt(0);
            switch (choix) {
                case 'z':
                // On execute le déplacement si on est pas au bordure de l'ocean
                    if (this.o.getPingouin().getPosition().getOrdonnee() >= o.getHeight()
                            - this.o.getPingouin().getTaille() - 1) {
                        System.out.print("Vous sortez de l'océan veuillez saisir un autre déplacement.");
                    } else {
                        this.o.getPingouin().deplacerHaut();
                    }
                    break;
                case 'd':
                    if (this.o.getPingouin().getPosition().getAbscisse() >= o.getWidth() - 1) {
                        System.out.print("Vous sortez de l'océan veuillez saisir un autre déplacement.");
                    } else {
                        this.o.getPingouin().deplacerDroite();
                    }
                    break;
                case 's':
                    if (this.o.getPingouin().getPosition().getOrdonnee() <= 0) {
                        System.out.print("Vous sortez de l'océan veuillez saisir un autre déplacement.");
                    } else {
                        this.o.getPingouin().deplacerBas();
                    }
                    break;
                case 'q':
                    if (this.o.getPingouin().getPosition().getAbscisse() <= this.o.getPingouin().getTaille() - 1) {
                        System.out.print("Vous sortez de l'océan veuillez saisir un autre déplacement.");
                    } else {
                        this.o.getPingouin().deplacerGauche();
                    }
                    break;
                //Si on saisit autre chose que z, q, s ou d on met fin à la partie
                default:
                    System.out.println("Vous avez mis fin à la partie !");
                    this.partie_en_cours = false;
                    break;
            }
            this.img.setColors(this.o.getColors());
        }
    }
}
