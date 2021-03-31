package calc.tests;

import calc.Nombre;
import calc.Somme;
import calc.Difference;
import calc.Produit;
import calc.Quotient;

public class TestBinaire {
    public static void main(String[] a) {
        testToString();
    }

    private static void testToString() {
        Nombre n1 = new Nombre(10);
        Nombre n2 = new Nombre(2);
        Nombre n3 = new Nombre(5);
        Somme s1 = new Somme(n1, n2);
        assert (s1.toString().equals("((10)+(2))")) : "Il y a un problème avec la fonction toString avec une somme";
        Somme s2 = new Somme(n1, n3);
        assert (s2.toString().equals("((10)+(5))")) : "Il y a un problème avec la fonction toString avec une somme";
        Difference d1 = new Difference(n1, n2);
        assert (d1.toString().equals("((10)-(2))")) : "Il y a un problème avec la fonction toString avec une Difference";
        Difference d2 = new Difference(n1, n3);
        assert (d2.toString().equals("((10)-(5))")) : "Il y a un problème avec la fonction toString avec une Difference";
        Produit p1 = new Produit(n1, n2);
        assert (p1.toString().equals("((10)*(2))")) : "Il y a un problème avec la fonction toString avec un Produit";
        Produit p2 = new Produit(n1, n3);
        assert (p2.toString().equals("((10)*(5))")) : "Il y a un problème avec la fonction toString avec un Produit";
        Quotient q1 = new Quotient(n1, n2);
        assert (q1.toString().equals("((10)/(2))")) : "Il y a un problème avec la fonction toString avec un Quotient";
        Quotient q2 = new Quotient(n1, n3);
        assert (q2.toString().equals("((10)/(5))")) : "Il y a un problème avec la fonction toString avec un Quotient";
    }
}