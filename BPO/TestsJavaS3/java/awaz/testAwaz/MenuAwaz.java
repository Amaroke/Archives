package testAwaz;

import awaz.Awaz;
import awaz.AwazImage;
import java.util.Locale;
import java.util.Scanner;

/**
 * Cette classe est la question 3 du Tp Awaz
 * 
 * @author MATHIEU STEINBACH Hugo
 * @version Septembre 2020
 */
public class MenuAwaz {
    public static void main(String[] args) {
        // Création d'une mélodie vide
        int choix = 0;
        Awaz melodie = new Awaz();
        AwazImage melodieJouable;
        Scanner scan = new Scanner(System.in);
        while (choix != 1) {
            if (choix == 0) {
                System.out.println(
                        "1 : Quitter le programme.\n2 : Ajouter une note à la mélodie.\n3 : Enregistrer la mélodie dans un fichier.\n4 : Demander si la mélodie est vide.\n5 : Récupérer la dernière note de la mélodie.\n6 : Récupérer le titre de la mélodie.\n7 : Récupérer une note de la mélodie.\n8 : Récupérer le nombre de notes de la mélodie.\n9 : Effacer toutes les notes de la mélodie.\n10 : Construire la mélodie à partir d'un fichier.\n11 : Fixer le titre de la mélodie.\n12 : Retourner la mélodie au format ABC.\n13 : Transposer chaque note de la mélodie.\n14 : Fixer le titre et afficher la partition.\n15 : Fixer la partition à afficher en ABC.");
            }
            System.out.print("Votre choix (0 pour réafficher le menu) : ");
            scan.useLocale(Locale.ENGLISH);
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Vous avez quitté le programme !\n");
                    break;
                case 2:
                    System.out.print("Saisissez la note à ajouter (Do Do# Ré Ré# Mi Fa Fa# Sol Sol# La La# Si) : ");
                    String note = scan.next();
                    melodie.add(note);
                    System.out.println("Vous avez ajouté la note " + note + " !\n");
                    break;
                case 3:
                    System.out.print("Saisissez le nom du fichier : ");
                    String nom = scan.next();
                    melodie.enregistrer(nom);
                    System.out.println("Vous avez enregistré la mélodie.\n");
                    break;
                case 4:
                    if (melodie.estVide()) {
                        System.out.println("La mélodie est vide !\n");
                    } else {
                        System.out.println("La mélodie n'est pas vide !\n");
                    }
                    break;
                case 5:
                    System.out.println("La dernière note de la mélodie est : " + melodie.getLast() + "\n");
                    break;
                case 6:
                    System.out.println("Le titre de la mélodie est ('Un air de rien est le titre par défaut') :  "
                            + melodie.getTitre() + "\n");
                    break;
                case 7:
                    System.out.print("Quelle note voulez-vous récupérer : ");
                    int i = scan.nextInt();
                    System.out.println("La " + i + "ère/ème note est ('null' signifie que cette note n'existe pas.) : "
                            + melodie.ieme(i - 1) + "\n");
                    break;
                case 8:
                    System.out.println("La mélodie contient " + melodie.nbNotes() + " notes.\n");
                    break;
                case 9:
                    melodie.nouveau();
                    System.out.println("Les notes ont été éffacées.\n");
                    break;
                case 10:
                    System.out.print("Saisissez le nom du fichier : ");
                    String nomFichier = scan.next();
                    melodie.ouvrir(nomFichier);
                    System.out.println("Vous avez récupérés votre mélodie depuis le fichier : " + nomFichier
                            + ", ou vous avez spécifié un nom incorrect.\n");
                    break;
                case 11:
                    System.out.print("Quel titre voulez-vous donner : ");
                    nom = scan.next();
                    melodie.setTitre(nom);
                    System.out.println("Vous avez donné ce nom : " + nom + " à la méodie.\n");
                    break;
                case 12:
                    System.out.println("Voici la mélodie au format ABC : " + melodie.toABC() + "\n");
                    break;
                case 13:
                    System.out.print("De combien de demi-tons voulez-vous transposer : ");
                    int n = scan.nextInt();
                    melodie.transposer(n);
                    System.out.println("Mélodie transposée !\n");
                    break;
                case 14:
                    System.out.print("Quel nom voulez-vous donner (un seul mot): ");
                    String nomPartition = scan.next();
                    melodieJouable = new AwazImage();
                    melodieJouable.setTitre(nomPartition);
                    melodieJouable.setMelodie(melodie.toABC());
                    System.out.print(
                            "Siasissez un entier pour fermer la partition et poursuivre l'éxecution du programme : ");
                    int pause = scan.nextInt();
                    melodieJouable.fermer();
                    System.out.println("Fin de l'affichage !\n");
                    break;
                case 15:
                    // Problème avec la fonction setMelodieNotationAbcComplete, je n'ai pas compris
                    // son utilité ou son fonctionnement.
                    System.out.println("Fonction non implémentée.\n");
                    break;
            }

        }

    }
}
