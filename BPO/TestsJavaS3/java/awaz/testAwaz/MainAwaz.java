package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;

/**
 * Cette classe est le point de départ du Tp Awaz
 * @author martine
 * @version Janvier 2018
 */
public class MainAwaz {
    public static void main(String[] args) {
        // Création d'une melodie vide
        Awaz melodie = new Awaz() ;

        // Ajout de notes à la mélodie
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;
        melodie.add("Do") ;
        melodie.add("Ré") ;
        melodie.add("Mi") ;
        melodie.add("Fa") ;
        melodie.add("Sol") ;
        melodie.add("La") ;
        melodie.add("Si") ;

        //  Affichage de la mélodie
        System.out.println(melodie);

        // Calcul et affichage du nombre de notes
        int nbNotes = melodie.nbNotes();
        System.out.println(nbNotes);

        // Transposage de la mélodie.
        melodie.transposer(2);
        System.out.println(melodie);
        
        //Affichage de la mélodie en ligne
        String melodieLigne ="";
        for (int i=0;i<nbNotes;i=i+1){
            melodieLigne = melodieLigne + melodie.ieme(i) + " " ;
        }
        System.out.println(melodieLigne);
        
        // Enregistrement de la mélodie
        melodie.enregistrer("fichierMelodie");
        System.out.println(melodie.toABC());

        // On affiche et on joue la mélodie
        AwazImage melodieJouable = new AwazImage();
        melodieJouable.setMelodie(melodie.toABC());
    }
}
