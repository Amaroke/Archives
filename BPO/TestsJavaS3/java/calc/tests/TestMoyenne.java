package calc.tests;

import calc.Nombre;
import calc.Moyenne;

public class TestMoyenne {
    public static void main(String[] a) {
        testValeur();
        testGetOperateur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(4);
        Nombre n2 = new Nombre(10);
        Nombre n3 = new Nombre(20);
        Moyenne m1 = new Moyenne(n1, n2);
        assert (m1.valeur() == 7) : "Il y a un problème avec la fonction valeur de moyenne et le moyenne de 4 et 10";
        Moyenne m2 = new Moyenne(n1, n2, n3);
        assert (m2.valeur() == 11) : "Il y a un problème avec la fonction valeur de moyenne et le moyenne de 4, 10 et 20";
    }

    private static void testGetOperateur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Moyenne m1 = new Moyenne(n1, n2);
        assert (m1.getOperateur().equals("moyenne")) : "Il y a un problème avec la fonction getOperateur";
    }
}