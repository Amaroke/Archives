package bib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Lexique implements Iterable<String> {
    private final String[] tabMots;
    private int nbMots;

    public Lexique(int capacite) {
        this.tabMots = new String[capacite];
        this.nbMots = 0;
    }

    public void ajouter(String mot) throws Exception {
        if (this.nbMots() == this.getCapacite()) {
            throw new IOException("Le lexique est plein !");
        }
        this.tabMots[this.nbMots()] = mot;
        ++this.nbMots;
    }

    public int nbMots() {
        return nbMots;
    }

    public int getCapacite() {
        return this.tabMots.length;
    }

    public String[] getTabMots() {
        return tabMots;
    }

    @Override
    public String toString() {
        return "Lexique{" + "tabMots=" + Arrays.asList(tabMots).toString() +
                ", NbMots=" + nbMots +
                '}';
    }

    public Iterator<String> iteratorArray() {
        return new ArrayList<>(Arrays.asList(tabMots)).iterator();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < nbMots && tabMots[i] != null;
            }

            @Override
            public String next() {
                return tabMots[i++];
            }
        };
    }
}
