package glaces.tests;

import geometrie.*;
import glaces.Iceberg2D;
import glaces.ArcticImage;

/**
 * @author MATHIEU Hugo
 */

public class TestArcticImage {
    public static void main(String[] args) {
        ArcticImage img = new ArcticImage(300,300);
        int[][] tab = new int[300][300] ;
        for (int i = 0 ; i < tab.length ; i++) {
            for (int j = 0 ; j < tab.length ; j++) {
                if (j % 2 == 0) {
                    tab[i][j] = 0 ;
                }
                else {
                    tab[i][j] = 1 ;
                }
            }
        }
        img.setColors(tab);
    }
}