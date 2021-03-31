package calc.tests;

import calc.Nombre;
import calc.Quotient;

public class TestQuotient {
    public static void main(String[] a) {
        testValeur();
        testGetOperateur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(10);
        Nombre n2 = new Nombre(2);
        Nombre n3 = new Nombre(5);
        Quotient q1 = new Quotient(n1, n2);
        assert (q1.valeur() == 5) : "Il y a un problème avec la fonction valeur de Quotient et le Quotient de 10 et 2";
        Quotient q2 = new Quotient(n1, n3);
        assert (q2.valeur() == 2) : "Il y a un problème avec la fonction valeur de Quotient et le Quotient de 10 et 5";
        Quotient q3 = new Quotient(q1, q2);
        assert (q3.valeur() == 2)
                : "Il y a un problème avec la fonction valeur de Quotient et le Quotient de deux Quotient";
    }

    private static void testGetOperateur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Quotient q1 = new Quotient(n1, n2);
        assert (q1.getOperateur().equals("/")) : "Il y a un problème avec la fonction getOperateur de Quotient";
    }
}