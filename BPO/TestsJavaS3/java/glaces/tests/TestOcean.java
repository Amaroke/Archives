package glaces.tests;

import geometrie.*;
import glaces.Iceberg2D;
import glaces.Ocean;

/**
 * @author MATHIEU Hugo
 */
public class TestOcean {
    public static void main(String[] args) {
        testToString();
        testGetCount();
        testGetWidth();
        testGetHeight();
        //testGetColors(); Trop contraignant à écrire (90 000 éléments)
        //testFondre(); On ne peut pas tester fondre car on à pas de getter sur les icebergs
    }

    public static void testToString() {
        Ocean o;
        boolean b;

        o = new Ocean();
        b = o.toString().equals("Largeur : 300 Hauteur : 300 Nombre d'icebergs : 2");
        assert (b) : "Bug quand la chaîne de caractère renvoyée n'est pas la bonne";
    }

    public static void testGetCount() {
        Ocean o;
        boolean b;

        o = new Ocean();
        b = o.getCount() == 2;
        assert (b) : "Bug, le nombre d'icebergs compté n'est pas le même que celui généré avec l'océan de base";

        o = new Ocean(5, 300, 300);
        b = o.getCount() == 5;
        assert (b) : "Bug, le nombre d'icebergs compté n'est pas le même que celui généré avec un océan de 5 icebergs";
    }

    public static void testGetWidth() {
        Ocean o;
        boolean b;

        o = new Ocean();
        b = o.getWidth() == 300;
        assert (b) : "Bug, la largeur testée de l'océan n'est pas le même que celle générée avec l'océan de base";

        o = new Ocean(3, 1000, 1000);
        b = o.getWidth() == 1000;
        assert (b) : "Bug, la largeur testée de l'océan n'est pas le même que celle générée avec un océan de 1000*1000";
    }

    public static void testGetHeight() {
        Ocean o;
        boolean b;

        o = new Ocean();
        b = o.getHeight() == 300;
        assert (b) : "Bug, la hauteur testée de l'océan n'est pas le même que celle générée avec l'océan de base";

        o = new Ocean(3, 400, 400);
        b = o.getHeight() == 400;
        assert (b) : "Bug, la hauteur testée de l'océan n'est pas le même que celle générée avec un océan de 1000*1000";
    }
}
