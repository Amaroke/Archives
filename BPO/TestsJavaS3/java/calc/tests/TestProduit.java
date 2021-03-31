package calc.tests;

import calc.Nombre;
import calc.Produit;

public class TestProduit {
    public static void main(String[] a) {
        testValeur();
        testGetOperateur();
    }

    private static void testValeur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Nombre n3 = new Nombre(20);
        Produit p1 = new Produit(n1, n2);
        assert (p1.valeur() == 10) : "Il y a un problème avec la fonction valeur de Produit et le Produit de 1 et 10";
        Produit p2 = new Produit(n2, n3);
        assert (p2.valeur() == 200) : "Il y a un problème avec la fonction valeur de Produit et le Produit de 10 et 20";
        Produit p3 = new Produit(p1, p2);
        assert (p3.valeur() == 2000)
                : "Il y a un problème avec la fonction valeur de Produit et le Produit de deux Produit";
    }

    private static void testGetOperateur() {
        Nombre n1 = new Nombre(1);
        Nombre n2 = new Nombre(10);
        Produit p1 = new Produit(n1, n2);
        assert (p1.getOperateur().equals("*")) : "Il y a un problème avec la fonction getOperateur de Produit";
    }
}