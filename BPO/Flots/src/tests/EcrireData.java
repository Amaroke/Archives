package tests;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EcrireData {
    public static void main(java.lang.String[] args) {
        PrintWriter flotFiltre;
        FileWriter flot;
        int nbalea = (int) (10 + Math.random() * (31 - 10));
        int nbalea2 = (int) (Math.random() * 25);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        try {
            flot = new FileWriter(args[0]);
            flotFiltre = new PrintWriter(flot);
            for (int i = 0; i < nbalea; ++i) {
                flotFiltre.print(alphabet.charAt(nbalea2) + " " + (-5 + (int) (Math.random() * (8 - (-5)))));
                if (nbalea2 == 25) {
                    nbalea2 = 0;
                } else {
                    nbalea2++;
                }
                if (i < nbalea - 1) {
                    flotFiltre.println(""); //Pour éviter la ligne vide
                }
            }
            flotFiltre.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

