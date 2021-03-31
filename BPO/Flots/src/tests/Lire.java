package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Lire {
    public static void main(java.lang.String[] args) throws IOException {
        File fichier;
        Scanner scan;
        int cpt = 0;
        int sum = 0;
        fichier = new File(args[0]);
        boolean estLa = fichier.exists();
        if (!estLa) {
            throw new IOException("Fichier non existant !");
        }
        try {
            scan = new Scanner(fichier);
            while (scan.hasNextLine()) {
                ++cpt;
                sum += scan.nextInt();
            }
            System.out.println("Nombre d'entiers : " + cpt + " Moyenne : " + sum / cpt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
