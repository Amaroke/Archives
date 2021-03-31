package tests;

import bib.Lexique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class LexiqueTest {
    Lexique lexique;

    @BeforeEach
    void init() throws Exception {
        lexique = new Lexique(10);
        lexique.ajouter("ABC");
        lexique.ajouter("DEF");
        lexique.ajouter("HIJ");
    }

    @Test
    public void print() {
        for (String mot : lexique) {
            System.out.println(mot);
        }
    }

    @Test
    public void printWithIterator() {
        Iterator<String> iterateur = lexique.iterator();
        while (iterateur.hasNext()) {
            System.out.println(iterateur.next());
        }
    }
}