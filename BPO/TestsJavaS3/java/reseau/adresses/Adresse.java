package reseau.adresses;

/**
 * @author martine & hugo
 * @version 20 nov. 2014 & oct. 2020
 */

public class Adresse {

    private Octet[] octets;

    /**
     * Constructeur de copie (copie profonde)
     * 
     * @param a adresse à copier
     * @exception AssertionError si a est null
     */
    public Adresse(Adresse a) {
        assert (a != null) : "Paramètre invalide, une adresse ne peut être null";
        this.octets = new Octet[a.getNbreOctets()];
        for (int i = 0; i < a.octets.length; ++i) {
            this.octets[i] = a.octets[i];
        }
    }

    /**
     * Constructeur à partir du tableau d'octets
     * 
     * @param al octets
     * @exception AssertionError si al est null
     */
    public Adresse(Octet... al) {
        assert (al != null) : "Paramètre invalide, le tableau ne peut être null";
        this.octets = new Octet[al.length];
        for (int i = 0; i < al.length; ++i) {
            this.octets[i] = al[i];
        }
    }

    /**
     * Adresse avec tous les bits à 0
     * 
     * @param nbBits nombre de bits
     * @exception AssertionError si le nombre total de bits n'est pas un multiple de
     *                           8 supérieur ou égal à 8
     */
    public Adresse(int nbBits) {
        assert (nbBits % 8 == 0 && nbBits >= 8)
                : "Paramètre invalide, le nombre total de bits n'est pas un multiple de 8 ou il n'est pas supérieur ou égal à 8";
        this.octets = new Octet[(nbBits / 8)];
        for (int i = 0; i < nbBits / 8; ++i) {
            this.octets[i] = new Octet();
        }
    }

    /**
     * Adresse masque composée de nbBitsUn bits à 1 suivis de 0 pour compléter.
     * 
     * @param nbBits   nombre de bits total
     * @param nbBitsUn nombre de bits à 1
     * @exception AssertionError si le nombre total de bits n'est pas un multiple de
     *                           8 supérieur ou égal à 8
     * @exception AssertionError si le nombre total de 1 est incorrect (négatif ou
     *                           supérieur à nbBits)
     */
    public Adresse(int nbBits, int nbBitsUn) {
        assert (nbBits % 8 == 0 && nbBits >= 8)
                : "Paramètre invalide, le nombre total de bits n'est pas un multiple de 8 ou il n'est pas supérieur ou égal à 8";
        assert (nbBitsUn > 0 && nbBitsUn < nbBits)
                : "Paramètre invalide, le nombre de bits à un n'est pas supérieur à 0 ou inférieur au nombre de bits";
        this.octets = new Octet[(nbBits / 8)];
        for (int i = 0; i < (nbBits / 8); ++i) {
            this.octets[i] = new Octet();
        }
        for (int i = 0; i < nbBitsUn / 8; ++i) {
            this.octets[i].setUn();
        }
        this.octets[nbBitsUn/8].setUn(nbBitsUn%8);
    }

    /**
     * Constructeur à partir d'une adresse écrite sous forme de notation décimale
     * pointée (par ex : 245.156.0.0)
     * 
     * @param s notation décimale pointée d'une adresse (par ex : 245.156.0.0)
     * @exception AssertionError si le nombre d'octets est différent de 4, 6, 8 ou
     *                           si un entier est trop grand
     */
    public Adresse(String s) {
        String[] tab_str = s.split("\\.");
        int[] tab_int = new int[tab_str.length];
        this.octets = new Octet[tab_int.length];
        for (int i = 0; i < tab_str.length; ++i) {
            tab_int[i] = Integer.parseInt(tab_str[i]);
        }
        assert (tab_int.length == 4 || tab_int.length == 6 || tab_int.length == 8)
                : "Paramètre invalide, le nombre d'octets n'est pas bon";
        for (int i = 0; i < tab_int.length; ++i) {
            assert (tab_int[i] <= 255) : "Paramètre invalide, l'entier est trop grand pour un octet";
            this.octets[i] = new Octet(tab_int[i]);
        }
    }

    /**
     * Retourne le nombre de bits
     * 
     * @return le nombre de bits
     */
    public int size() {
        return this.octets.length * 8;
    }

    /**
     * Retourne le nombre d'octets
     * 
     * @return le nombre d'octets
     */
    public int getNbreOctets() {
        return this.octets.length;
    }

    /**
     * Appliquer un masque
     * 
     * @param masque masque à appliquer
     * @exception AssertionError si le masque et le receveur ne sont pas de la même
     *                           taille
     */
    public void masquer(Adresse masque) {
        assert (masque.getNbreOctets() == this.getNbreOctets())
                : "Erreur, le masque et le receveur ne sont pas de la même taille";
        for (int i = 0; i < this.getNbreOctets(); ++i) {
            this.getOctet(i).masquer(masque.getOctet(i));
        }
    }

    /**
     * Inverser les octets : complément à 1 de chaque octet (0 &rarr; 1, 1 &rarr; 0)
     */
    public void inverser() {
        for (int i = 0; i < this.getNbreOctets(); ++i) {
            this.getOctet(i).inverser();
        }
    }

    /**
     * Fixer les octets
     * 
     * @param alo octets
     * @exception AssertionError si alo est null
     */
    public void setOctets(Octet... alo) {
        assert (alo != null) : "Paramètre invalide, alo ne peut être null";
        for (Octet i : alo) {
            int j = 0;
            this.octets[j] = i;
            ++j;
        }
    }

    /**
     * Fixer un des octets de l'adresse, k est le rang de l'octet, k &ge; 0
     * 
     * @param o octet
     * @param k rang de l'octet
     * @exception AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public void setOctet(Octet o, int k) {
        assert (k >= 0 && k <= this.getNbreOctets()) : "Paramètre invalide, k est en dehors de l'adresse";
        this.octets[k] = o;
    }

    /**
     * Consulter un des octets de l'adresse, k est le rang de l'octet, k &ge; 0
     * 
     * @param k rang de l'octet
     * @return l'octet de rang k de l'adresse
     * @exception AssertionError si k n'est pas entre 0 et le nombre d'octets
     */
    public Octet getOctet(int k) {
        assert (k >= 0 && k <= this.octets.length) : "Paramètre invalide, k n'est pas entre 0 et le nombre d'octets";
        return this.octets[k];
    }

    /**
     * Construit la chaîne de caractères où la valeur de chaque octet est séparé du
     * suivant par un point. Par exemple 192.45.43.100
     * 
     * @return la chaîne de caractères construite
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.getNbreOctets(); ++i) {
            if (i < this.getNbreOctets() - 1) {
                s.append(this.getOctet(i).toString()).append(".");
            } else {
                s.append(this.getOctet(i).toString());
            }
        }
        return s.toString();
    }

}
