package tests;

import bib.Lexique;
import bib.Livre;
import org.junit.jupiter.api.Test;

public class LivreTest {
    @Test
    public void printWithIterator() throws Exception {
        Lexique lexiqueFrancais = new Lexique(3);
        Lexique lexiqueAnglais = new Lexique(2);
        lexiqueFrancais.ajouter("ABC");
        lexiqueFrancais.ajouter("DEF");
        lexiqueFrancais.ajouter("HIJ");
        lexiqueAnglais.ajouter("KLM");
        lexiqueAnglais.ajouter("NOP");
        Livre livre = new Livre(lexiqueAnglais, lexiqueFrancais, "Un super livre.");
        while (livre.hasNext()) {
            System.out.println(livre.next());
        }
    }

}