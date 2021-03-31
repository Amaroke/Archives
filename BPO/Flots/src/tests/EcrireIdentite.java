package tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EcrireIdentite {
    public static void main(java.lang.String[] args) {
        BufferedWriter flotFiltre;
        FileWriter flot;
        try {
            flot = new FileWriter("infos.txt");
            flotFiltre = new BufferedWriter(flot);
            flotFiltre.write("MATHIEU STEINBACH");
            flotFiltre.newLine();
            flotFiltre.write("Hugo");
            flotFiltre.newLine();
            flotFiltre.write("19 av. JB Diedler");
            flotFiltre.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
