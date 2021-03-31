package calc.tests;

import calc.Nombre;
import calc.Min;

public class TestMin {
    public static void main(String[] a) {
        testValeur();
        testGetOperateur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Nombre n3 = new Nombre(20);
        Min m1 = new Min(n1, n2);
        assert (m1.valeur() == 1) : "Il y a un problème avec la fonction valeur de min et le min de 1 et 10";
        Min m2 = new Min(n1, n2, n3);
        assert (m2.valeur() == 1) : "Il y a un problème avec la fonction valeur de min et le min de 1, 10 et 20";
    }

    private static void testGetOperateur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Min m1 = new Min(n1, n2);
        assert (m1.getOperateur().equals("min")) : "Il y a un problème avec la fonction getOperateur";
    }
}