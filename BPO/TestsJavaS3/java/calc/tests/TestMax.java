package calc.tests;

import calc.Nombre;
import calc.Max;

public class TestMax {
    public static void main(String[] a) {
        testValeur();
        testGetOperateur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Nombre n3 = new Nombre(20);
        Max m1 = new Max(n1, n2);
        assert (m1.valeur() == 10) : "Il y a un problème avec la fonction valeur de max et le max de 1 et 10";
        Max m2 = new Max(n1, n2, n3);
        assert (m2.valeur() == 20) : "Il y a un problème avec la fonction valeur de max et le max de 1, 10 et 20";
    }

    private static void testGetOperateur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Max m1 = new Max(n1, n2);
        assert (m1.getOperateur().equals("max")) : "Il y a un problème avec la fonction getOperateur";
    }
}