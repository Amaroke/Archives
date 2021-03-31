package glaces.tests;

import geometrie.*;
import glaces.Iceberg2D;

/**
 * @author MATHIEU Hugo
 */

public class TestIceberg2D {
    public static void main(String[] args) {
        testCoinEnBasAGauche();
        testCoinEnHautADroite();
        testHauteur();
        testLargeur();
        testSurface();
        testCollisionEstVrai();
        testCollisionEstFaux();
        testEstPlusGrosQueEstVrai();
        testEstPlusGrosQueEstFaux();
        testToString();
        testCentre();
        testFondre();
        testCasserDroite();
        testCasserGauche();
        testCasserHaut();
        testCasserBas();
    }

    // Tests des fonctions d'observations

    private static void testCoinEnBasAGauche() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        b = new Point (1.,2.).equals(i.coinEnBasAGauche());
        assert (b): "Bug quand le point renvoyé est différent du point en paramètre avec un petit iceberg.";

        i = new Iceberg2D(new Point (10., 2.), new Point(355., 444.));
        b = new Point (10., 2.).equals(i.coinEnBasAGauche());
        assert (b): "Bug quand le point renvoyé est différent du point en paramètre avec un grand iceberg."; 
    }

    private static void testCoinEnHautADroite() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        b = new Point (3.,4.).equals(i.coinEnHautADroite());
        assert (b): "Bug quand le point renvoyé est différent du point en paramètre avec un petit iceberg.";

        i = new Iceberg2D(new Point (10., 2.), new Point(355., 444.));
        b = new Point (355., 444.).equals(i.coinEnHautADroite());
        assert (b): "Bug quand le point renvoyé est différent du point en paramètre avec un grand iceberg."; 
    }

    private static void testHauteur() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        b = 2.0 == i.hauteur();
        assert (b): "Bug quand la hauteur renvoyée est différent de celle calculée avec un petit iceberg.";

        i = new Iceberg2D(new Point (10., 2.), new Point(355., 444.));
        b = 442.0 == i.hauteur();
        assert (b): "Bug quand la hauteur renvoyée est différent de celle calculée avec un grand iceberg."; 
    }
    
    private static void testLargeur() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        b = 2.0 == i.largeur();
        assert (b): "Bug quand la largeur renvoyée est différent de celle calculée avec un petit iceberg.";

        i = new Iceberg2D(new Point (10., 2.), new Point(355., 444.));
        b = 345.0 == i.largeur();
        assert (b): "Bug quand la largeur renvoyée est différent de celle calculée avec un grand iceberg."; 
    }

    private static void testSurface() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        b = 4.0 == i.surface();
        assert (b): "Bug quand la surface renvoyée est différent de celle calculée avec un petit iceberg.";

        i = new Iceberg2D(new Point (10., 2.), new Point(355., 444.));
        b = 152490.0 == i.surface();
        assert (b): "Bug quand la surface renvoyée est différent de celle calculée avec un grand iceberg."; 
    }

    private static void testCollisionEstVrai() {
        Iceberg2D i1, i2;
        boolean b;
        i1 = new Iceberg2D(new Point (1.,2.), new Point(4.,5.));
        i2 = new Iceberg2D(new Point (3.,4.), new Point(6.,7.));

        b = i1.collision(i2);
        assert (b): "Bug quand aucune collision n'est détectée avec deux icebergs en collision avec i2 en paramètre.";

        b = i2.collision(i1);
        assert (b): "Bug quand aucune collision n'est détectée avec deux icebergs en collision avec i1 en paramètre.";
    }

    private static void testCollisionEstFaux() {
        Iceberg2D i1, i2;
        boolean b;
        i1 = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        i2 = new Iceberg2D(new Point (5.,6.), new Point(7.,8.));

        b = i1.collision(i2);
        assert (!b): "Bug quand une collision est détectée avec deux icebergs qui ne sont pas en collision avec i2 en paramètre.";

        b = i2.collision(i1);
        assert (!b): "Bug quand une collision est détectée avec deux icebergs qui ne sont pas en collision avec i1 en paramètre.";
    }

    private static void testEstPlusGrosQueEstVrai() {
        Iceberg2D i1, i2;
        boolean b;
        i1 = new Iceberg2D(new Point (1.,2.), new Point(4.,5.));
        i2 = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));

        b = i1.estPlusGrosQue(i2);
        assert (b): "Bug quand l'iceberg en paramètre est detecté plus petit que le recepteur.";
    }

    private static void testEstPlusGrosQueEstFaux() {
        Iceberg2D i1, i2;
        boolean b;
        i1 = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        i2 = new Iceberg2D(new Point (1.,2.), new Point(4.,5.));

        b = i1.estPlusGrosQue(i2);
        assert (!b): "Bug quand l'iceberg en paramètre n'est pas detecté plus petit que le recepteur.";
    }

    private static void testToString() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        b = i.toString().equals("<1.0,2.0> <3.0,4.0>");
        assert (b): "Bug quand la chaîne de caractère renvoyée n'est pas la bonne";
    }

    private static void testCentre() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (1.,2.), new Point(3.,4.));
        b = i.centre().equals(new Point (2.0, 3.0));
        assert (b): "Bug quand le centre renvoyée est différent du centre calculée avec un petit iceberg.";

        i = new Iceberg2D(new Point (10., 2.), new Point(355., 444.));
        b = i.centre().equals(new Point (182.5, 223));
        assert (b): "Bug quand le centre renvoyée est différent du centre calculée avec un grand iceberg.";
    }

    // Tests des fonctions de transformation

    private static void testFondre() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (10.,10.), new Point(20.,20.));
        i.fondre(0.5);
        b = (i.coinEnBasAGauche().equals(new Point (12.5, 12.5)) && (i.coinEnHautADroite().equals(new Point (17.5, 17.5))));
        assert (b): "Bug quand les coins de l'iceberg une fois fondu renvoyé sont différentes de celles de celui calculé.";
    }
    
    private static void testCasserDroite() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (10.,10.), new Point(20.,20.));
        i.casserDroite(0.1);
        b = i.coinEnHautADroite().equals(new Point (18, 20));
        assert (b): "Bug quand le coin en haut a droite n'a pas bougé de 10% vers la gauche.";
    }

    private static void testCasserGauche() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (10.,10.), new Point(20.,20.));
        i.casserGauche(0.1);
        b = i.coinEnBasAGauche().equals(new Point (11., 10.));
        assert (b): "Bug quand le coin en bas à gauche n'a pas bougé de 10% vers la droite.";
    }

    private static void testCasserHaut() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (10.,10.), new Point(20.,20.));
        i.casserHaut(0.1);
        b = i.coinEnHautADroite().equals(new Point (20., 18.));
        assert (b): "Bug quand le coin en haut a droite n'a pas bougé de 10% vers le bas.";
    }

    private static void testCasserBas() {
        Iceberg2D i;
        boolean b;
        i = new Iceberg2D(new Point (10.,10.), new Point(20.,20.));
        i.casserBas(0.1);
        b = i.coinEnBasAGauche().equals(new Point (10., 11.));
        assert (b): "Bug quand le coin en bas à gauche n'a pas bougé de 10% vers le haut.";
    }
}