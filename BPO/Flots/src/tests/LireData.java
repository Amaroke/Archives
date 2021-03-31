package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LireData {
    public static void main(String[] args) {
        File fichier;
        Scanner scan;
        String car_present = "";
        String temp;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] tabNbOccurence = new int[26];
        fichier = new File(args[0]);
        try {
            scan = new Scanner(fichier);
            while (scan.hasNextLine()) {
                temp = scan.nextLine();
                for (int i = 0; i < 26; ++i) {
                    if (temp.charAt(0) == (alphabet.charAt(i))) {
                        ++tabNbOccurence[i];
                    }
                }
            }
            System.out.print("Il y a :");
            for (int i = 0; i < 25; ++i) {
                System.out.print(" " + tabNbOccurence[i] + " " + alphabet.charAt(i) + ",");
            }
            System.out.print(" " + tabNbOccurence[25] + " " + alphabet.charAt(25) + ".");
            System.out.println(car_present);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
