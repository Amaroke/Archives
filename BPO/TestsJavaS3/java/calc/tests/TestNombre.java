package calc.tests;

import calc.Nombre;

public class TestNombre {
    public static void main(String[] a) {
        testValeur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(1);
        assert (n1.valeur() == 1) : "Problème avec la fonction valeur de nombre avec 1";
        Nombre n2 = new Nombre(10);
        assert (n2.valeur() == 10) : "Problème avec la fonction valeur de nombre avec 10";
        Nombre n3 = new Nombre(20);
        assert (n3.valeur() == 20) : "Problème avec la fonction valeur de nombre avec 20";
    }
}