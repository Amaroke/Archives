package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LireIdentite {
    public static void main(java.lang.String[] args) {
        FileReader flot;
        BufferedReader flotFiltre;
        int cpt = 0;
        try {
            flot = new FileReader("infos.txt");
            flotFiltre = new BufferedReader(flot);
            String ligne = flotFiltre.readLine();
            while (ligne != null) {
                ligne = flotFiltre.readLine();
                cpt += 1;
            }
            System.out.println(cpt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
