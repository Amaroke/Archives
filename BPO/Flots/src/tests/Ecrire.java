package tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ecrire {
    public static void main(java.lang.String[] args) throws IOException {
        PrintWriter flotFiltre;
        FileWriter flot;
        File chemin = new File(args[0]);
        boolean estLa = chemin.exists();
        if (estLa) {
            throw new IOException("Fichier déjà existant !");
        }
        try {
            flot = new FileWriter(args[0]);
            flotFiltre = new PrintWriter(flot);
            int i = 1;
            while (i <= 999) {
                flotFiltre.println(i);
                i++;
            }
            flotFiltre.print(1000); //Pour éviter de créer une ligne vide.
            flotFiltre.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
