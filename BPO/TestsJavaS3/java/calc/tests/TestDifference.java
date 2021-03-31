package calc.tests;

import calc.Nombre;
import calc.Difference;

public class TestDifference {
    public static void main(String[] a) {
        testValeur();
        testGetOperateur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Nombre n3 = new Nombre(20);
        Difference d1 = new Difference(n1, n2);
        assert (d1.valeur() == -9) : "Il y a un problème avec la fonction valeur de Diffrence et la Diffrence de 1 et 10";
        Difference d2 = new Difference(n2, n3);
        assert (d2.valeur() == -10) : "Il y a un problème avec la fonction valeur de Diffrence et la Diffrence de 10 et 20";
        Difference d3 = new Difference(d1, d2);
        assert (d3.valeur() == 1) : "Il y a un problème avec la fonction valeur de Diffrence et la Diffrence de deux Diffrence";
    }

    private static void testGetOperateur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Difference s1 = new Difference(n1, n2);
        assert (s1.getOperateur().equals("-")) : "Il y a un problème avec la fonction getOperateur de Difference";
    }
}