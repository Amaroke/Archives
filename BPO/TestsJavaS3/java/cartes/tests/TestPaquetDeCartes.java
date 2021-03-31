package cartes.tests;

import cartes.Couleur;
import cartes.Carte;
import cartes.FabriqueCartes;
import cartes.PaquetDeCartes;

public class TestPaquetDeCartes {
        public static void main(String[] args) {
                testGetNombreDeCartes();
                testEstVideVrai();
                testEstVideFaux();
                testGetValeur();
                testToString();
                testAjouterCarte();
                testAjouterPaquet();
                testMelanger();
                testRetourner();
                testGetSommet();
                testPiocher();
        }

        private static void testGetNombreDeCartes() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                b = paquetVide.getNombreDeCartes() == 0;
                assert (b) : "Le nombre de carte retournée pour un paquet vide n'est pas le bon";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                b = paquet1Vert.getNombreDeCartes() == 1;
                assert (b) : "Le nombre de carte retournée pour un paquet de 1 carte n'est pas le bon";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                b = paquet5Vert.getNombreDeCartes() == 5;
                assert (b) : "Le nombre de carte retournée pour un paquet de 5 cartes n'est pas le bon";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                b = paquet32.getNombreDeCartes() == 32;
                assert (b) : "Le nombre de carte retournée pour un paquet de 32 cartes n'est pas le bon";
        }

        private static void testEstVideVrai() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                b = paquetVide.estVide();
                assert (b) : "La fonction est vide est fausse dans le cas d'un paquet vide";
        }

        private static void testEstVideFaux() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                b = paquet1Vert.estVide();
                assert (!b) : "La fonction est vide est fausse dans le cas d'un paquet de 1 carte";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                b = paquet5Vert.estVide();
                assert (!b) : "La fonction est vide est fausse dans le cas d'un paquet de 5 cartes";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                b = paquet32.estVide();
                assert (!b) : "La fonction est vide est fausse dans le cas d'un paquet de 32 carte";
        }

        private static void testGetValeur() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                b = paquetVide.getValeur() == 0;
                assert (b) : "La valeur pour un paquet vide n'est pas le bon";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                b = paquet1Vert.getValeur() == 1;
                assert (b) : "La valeur pour un paquet de 1 carte n'est pas le bon";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                b = paquet5Vert.getValeur() == 15;
                assert (b) : "La valeur pour un paquet de 5 cartes n'est pas le bon";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                b = paquet32.getValeur() == 144;
                assert (b) : "La valeur pour un paquet de 32 cartes n'est pas le bon";
        }

        private static void testToString() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                b = paquetVide.toString().equals("");
                assert (b) : "Le contenu renvoyé pour un paquet vide n'est pas le bon";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                b = paquet1Vert.toString().equals("Carte{valeur=1, couleur=Vert} ");
                assert (b) : "Le contenu renvoyé pour un paquet de 1 carte n'est pas le bon";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                b = paquet5Vert.toString().equals(
                                "Carte{valeur=1, couleur=Vert} Carte{valeur=2, couleur=Vert} Carte{valeur=3, couleur=Vert} Carte{valeur=4, couleur=Vert} Carte{valeur=5, couleur=Vert} ");
                assert (b) : "Le contenu renvoyé pour un paquet de 5 cartes n'est pas le bon";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                b = paquet32.toString().equals(
                                "Carte{valeur=1, couleur=Bleu} Carte{valeur=2, couleur=Bleu} Carte{valeur=3, couleur=Bleu} Carte{valeur=4, couleur=Bleu} Carte{valeur=5, couleur=Bleu} Carte{valeur=6, couleur=Bleu} Carte{valeur=7, couleur=Bleu} Carte{valeur=8, couleur=Bleu} Carte{valeur=1, couleur=Rouge} Carte{valeur=2, couleur=Rouge} Carte{valeur=3, couleur=Rouge} Carte{valeur=4, couleur=Rouge} Carte{valeur=5, couleur=Rouge} Carte{valeur=6, couleur=Rouge} Carte{valeur=7, couleur=Rouge} Carte{valeur=8, couleur=Rouge} Carte{valeur=1, couleur=Vert} Carte{valeur=2, couleur=Vert} Carte{valeur=3, couleur=Vert} Carte{valeur=4, couleur=Vert} Carte{valeur=5, couleur=Vert} Carte{valeur=6, couleur=Vert} Carte{valeur=7, couleur=Vert} Carte{valeur=8, couleur=Vert} Carte{valeur=1, couleur=Jaune} Carte{valeur=2, couleur=Jaune} Carte{valeur=3, couleur=Jaune} Carte{valeur=4, couleur=Jaune} Carte{valeur=5, couleur=Jaune} Carte{valeur=6, couleur=Jaune} Carte{valeur=7, couleur=Jaune} Carte{valeur=8, couleur=Jaune} ");
                assert (b) : "Le contenu renvoyé pour un paquet de 32 cartes n'est pas le bon";
        }

        private static void testAjouterCarte() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                paquetVide.ajouter(new Carte(1, Couleur.VERT));
                b = paquetVide.getValeur() == 1 && paquetVide.getNombreDeCartes() == 1;
                assert (b) : "Il y a un problème lors de l'ajout d'une carte dans un paquet vide";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                paquet1Vert.ajouter(new Carte(1, Couleur.VERT));
                b = paquet1Vert.getValeur() == 2 && paquet1Vert.getNombreDeCartes() == 2;
                assert (b) : "Il y a un problème lors de l'ajout d'une carte dans un paquet d'une carte";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                paquet5Vert.ajouter(new Carte(1, Couleur.VERT));
                b = paquet5Vert.getValeur() == 16 && paquet5Vert.getNombreDeCartes() == 6;
                assert (b) : "Il y a un problème lors de l'ajout d'une carte dans un paquet de 5 cartes";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                paquet32.ajouter(new Carte(1, Couleur.VERT));
                b = paquet32.getValeur() == 145 && paquet32.getNombreDeCartes() == 33;
                assert (b) : "Il y a un problème lors de l'ajout d'une carte dans un paquet de 32 cartes";
        }

        private static void testAjouterPaquet() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                paquet32.ajouter(paquet1Vert);
                b = paquet32.getValeur() == 145 && paquet32.getNombreDeCartes() == 33;
                assert (b) : "Il y a un problème lors de l'ajout d'un paquet d'une carte.";
                paquet32 = singleton.getPaquet32();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                paquet32.ajouter(paquetVide);
                b = paquet32.getValeur() == 144 && paquet32.getNombreDeCartes() == 32;
                assert (b) : "Il y a un problème lors de l'ajout d'un paquet vide.";
        }

        private static void testMelanger() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                paquetVide.melanger();
                b = paquetVide.getValeur() == 0 && paquetVide.getNombreDeCartes() == 0;
                assert (b) : "Il y a un problème lors du mélange dans un paquet vide";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                paquet1Vert.melanger();
                b = paquet1Vert.getValeur() == 1 && paquet1Vert.getNombreDeCartes() == 1;
                assert (b) : "Il y a un problème lors du mélange dans un paquet d'une carte";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                paquet5Vert.melanger();
                b = paquet5Vert.getValeur() == 15 && paquet5Vert.getNombreDeCartes() == 5;
                assert (b) : "Il y a un problème lors du mélange dans un paquet de 5 cartes";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                paquet32.melanger();
                b = paquet32.getValeur() == 144 && paquet32.getNombreDeCartes() == 32;
                assert (b) : "Il y a un problème lors du mélange dans un paquet de 32 cartes";
        }

        private static void testRetourner() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                paquetVide.retourner();
                b = paquetVide.getValeur() == 0 && paquetVide.getNombreDeCartes() == 0;
                assert (b) : "Il y a un problème lorsqu'on retourne un paquet vide";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                paquet1Vert.retourner();
                b = paquet1Vert.getValeur() == 1 && paquet1Vert.getNombreDeCartes() == 1;
                assert (b) : "Il y a un problème lorsqu'on retourne un paquet d'une carte";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                paquet5Vert.retourner();
                b = paquet5Vert.getValeur() == 15 && paquet5Vert.getNombreDeCartes() == 5;
                assert (b) : "Il y a un problème lorsqu'on retourne un paquet de 5 cartes";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                paquet32.retourner();
                b = paquet32.getValeur() == 144 && paquet32.getNombreDeCartes() == 32;
                assert (b) : "Il y a un problème lorsqu'on retourne un paquet de 32 cartes";
        }

        private static void testGetSommet() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                b = paquetVide.getSommet() == null;
                assert (b) : "La carte au sommet pour un paquet vide n'est pas la bonne";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                b = paquet1Vert.getSommet().getValeur() == new Carte(1, Couleur.VERT).getValeur()
                                && paquet1Vert.getSommet().getCouleur() == new Carte(1, Couleur.VERT).getCouleur();
                assert (b) : "La carte au sommet pour un paquet de 1 carte n'est pas la bonne";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                b = paquet5Vert.getSommet().getValeur() == new Carte(1, Couleur.VERT).getValeur()
                                && paquet5Vert.getSommet().getCouleur() == new Carte(1, Couleur.VERT).getCouleur();
                assert (b) : "La carte au sommet pour un paquet de 5 cartes n'est pas la bonne";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                b = paquet32.getSommet().getValeur() == new Carte(1, Couleur.BLEU).getValeur()
                                && paquet32.getSommet().getCouleur() == new Carte(1, Couleur.BLEU).getCouleur();
                assert (b) : "La carte au sommet pour un paquet de 32 cartes n'est pas la bonne";
        }

        private static void testPiocher() {
                boolean b;
                FabriqueCartes singleton = FabriqueCartes.getInstance();
                PaquetDeCartes paquetVide = singleton.getPaquetVide();
                b = paquetVide.piocher() == null;
                assert (b) : "La carte piochée pour un paquet vide n'est pas la bonne";
                PaquetDeCartes paquet1Vert = singleton.getPaquet1Vert();
                b = paquet1Vert.piocher().getValeur() == new Carte(1, Couleur.VERT).getValeur();
                paquet1Vert = singleton.getPaquet1Vert();
                b = b && paquet1Vert.piocher().getCouleur() == new Carte(1, Couleur.VERT).getCouleur()
                                && paquet1Vert.getNombreDeCartes() == 0;
                assert (b) : "La carte piochée pour un paquet de 1 carte n'est pas la bonne";
                PaquetDeCartes paquet5Vert = singleton.getPaquet5Vert();
                b = paquet5Vert.piocher().getValeur() == new Carte(1, Couleur.VERT).getValeur();
                paquet5Vert = singleton.getPaquet5Vert();
                b = b && paquet5Vert.piocher().getCouleur() == new Carte(1, Couleur.VERT).getCouleur()
                                && paquet5Vert.getNombreDeCartes() == 4;
                assert (b) : "La carte piochée pour un paquet de 5 cartes n'est pas la bonne";
                PaquetDeCartes paquet32 = singleton.getPaquet32();
                b = paquet32.piocher().getValeur() == new Carte(1, Couleur.BLEU).getValeur();
                paquet32 = singleton.getPaquet32();
                b = b && paquet32.piocher().getCouleur() == new Carte(1, Couleur.BLEU).getCouleur()
                                && paquet32.getNombreDeCartes() == 31;
                assert (b) : "La carte piochée pour un paquet de 32 cartes n'est pas la bonne";
        }
}
