package calc.tests;

import calc.Nombre;
import calc.Min;
import calc.Max;
import calc.Moyenne;

public class TestNaire {
    public static void main(String[] a) {
        testToString();
    }

    private static void testToString() {
        Nombre n1 = new Nombre(10);
        Nombre n2 = new Nombre(2);
        Nombre n3 = new Nombre(5);
        Min mini = new Min(n1, n2, n3);
        assert (mini.toString().equals("min((10)(2)(5))")) : "Il y a un problème avec la fonction toString avec un min";
        Max maxi = new Max(n1, n2, n3);
        assert (maxi.toString().equals("max((10)(2)(5))")) : "Il y a un problème avec la fonction toString avec un max";
        Moyenne moyenne = new Moyenne(n1, n2, n3);
        assert (moyenne.toString().equals("moyenne((10)(2)(5))")) : "Il y a un problème avec la fonction toString avec un moyenne";
    }
}