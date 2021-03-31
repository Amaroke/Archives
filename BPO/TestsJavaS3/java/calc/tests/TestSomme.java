package calc.tests;

import calc.Nombre;
import calc.Somme;

public class TestSomme {
    public static void main(String[] a) {
        testValeur();
        testGetOperateur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Nombre n3 = new Nombre(20);
        Somme s1 = new Somme(n1, n2);
        assert (s1.valeur() == 11) : "Il y a un problème avec la fonction valeur de somme et la somme de 1 et 10";
        Somme s2 = new Somme(n2, n3);
        assert (s2.valeur() == 30) : "Il y a un problème avec la fonction valeur de somme et la somme de 10 et 20";
        Somme s3 = new Somme(s1, s2);
        assert (s3.valeur() == 41) : "Il y a un problème avec la fonction valeur de somme et la somme de deux sommes";
    }

    private static void testGetOperateur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Somme s1 = new Somme(n1, n2);
        assert (s1.getOperateur().equals("+")) : "Il y a un problème avec la fonction getOperateur";
    }
}