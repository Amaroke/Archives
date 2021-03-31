package bib;

import java.util.Iterator;

public class Livre implements Iterator<String> {
    private final Lexique anglais;
    private final Lexique francais;
    private final String titre;
    private int index;

    public Livre(Lexique anglais, Lexique francais, String titre) {
        this.anglais = anglais;
        this.francais = francais;
        this.index = 0;
        this.titre = titre;
    }

    @Override
    public boolean hasNext() {
        return index < this.francais.nbMots() + this.anglais.nbMots();
    }

    @Override
    public String next() {
        StringBuilder affichage = new StringBuilder();
        if (this.index == 0) {
            affichage.append("Titre du livre : ");
            affichage.append(this.titre);
            affichage.append("\n");
        }
        if (this.index < this.francais.nbMots()) {
            affichage.append(this.francais.getTabMots()[index]);
        } else {
            affichage.append(this.anglais.getTabMots()[index - this.francais.nbMots()]);
        }
        ++this.index;
        return affichage.toString();
    }
}
