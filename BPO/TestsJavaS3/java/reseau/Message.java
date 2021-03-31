package reseau;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;
import java.util.*;

/**
 * @author martine & hugo
 * @version 4 déc. 2014 & oct. 2020
 */
public class Message {

    private ArrayList<Octet> message;

    /**
     * Constructeur d'un message vide
     */
    public Message() {
        this.message = new ArrayList<Octet>();
    }

    /**
     * Constructeur de copie (copie profonde)
     * 
     * @param mess nombre d'éléments à copier
     * @exception AssertionError si mess est null
     */
    public Message(Message mess) {
        this();
        assert (mess != null) : "Paramètre invalide, un message ne peut être null";
        for (int i = 0; i < mess.size(); ++i) {
            this.message.add(mess.getOctet(i));
        }
    }

    /**
     * Constructeur d'un message à partir des petits entiers (1 petit entier est
     * codé sur un seul octet)
     * 
     * @param v des petits entiers qui constituent le message
     */
    public Message(short... v) {
        this();
        for (short i : v) {
            this.message.add(new Octet(i));
        }
    }

    /**
     * Constructeur d'un message à partir des entiers (1 entier est codé sur 2
     * octets)
     * 
     * @param v des entiers qui constituent le message
     */
    public Message(int... v) {
        this();
        for (int i : v) {
            if (i <= 255) {
                this.message.add(new Octet(0));
                this.message.add(new Octet(i));
            } else {
                this.message.add(new Octet((i) >> 8));
                this.message.add(new Octet(i % 256));
            }
        }
    }

    /**
     * Constructeur d'un message à partir de la chaîne de caractères
     * 
     * @param mot chaîne de caractères qui constitue le message
     */
    public Message(String mot) {
        this();
        String[] tab_str = mot.split("\\.");
        int[] tab_int = new int[tab_str.length];
        for (int i = 0; i < tab_str.length; ++i) {
            tab_int[i] = Integer.parseInt(tab_str[i]);
        }
        for (int i = 0; i < tab_int.length; ++i) {
            this.message.add(new Octet(tab_int[i]));
        }
    }

    /**
     * Constructeur d'un message à partir de l'adresse
     * 
     * @param adr adresse à placer dans le message
     */
    public Message(Adresse adr) {
        this();
        for (int i = 0; i < adr.getNbreOctets(); ++i) {
            this.message.add(adr.getOctet(i));
        }
    }

    /**
     * Retourne le nombre d'octets
     * 
     * @return le nombre d'octets
     */
    public int size() {
        return this.message.size();
    }

    /**
     * Retourne l'octet d'indice i dans le Message
     * 
     * @param index de l'octet à retourner
     * @return octet d'indice i
     */
    public Octet getOctet(int index) {
        return this.message.get(index);
    }

    /**
     * Ajouter un petit entier à la fin, entier &ge; 0
     * 
     * @param x entier à ajouter
     */
    public void ajouter(short x) {
        this.message.add(new Octet(x));
    }

    /**
     * Ajouter un entier à la fin, entier &ge; 0
     * 
     * @param x entier à ajouter
     */
    public void ajouter(int x) {
        if (x <= 255) {
            this.message.add(new Octet(0));
            this.message.add(new Octet(x));
        } else {
            this.message.add(new Octet((x) >> 8));
            this.message.add(new Octet(x % 256));
        }
    }

    /**
     * Ajouter un octet à la fin
     * 
     * @param o octet à ajouter
     * @exception AssertionError si o est null
     */
    public void ajouter(Octet o) {
        this.message.add(o);
    }

    /**
     * Concaténer un autre message
     * 
     * @param mess message à ajouter à la fin
     * @exception AssertionError si mess est null
     */
    public void ajouter(Message mess) {
        for (int i = 0; i < mess.size(); ++i) {
            this.message.add(mess.getOctet(i));
        }
    }

    /**
     * Ajouter les octets d'une adresse à la fin
     * 
     * @param adr adresse à ajouter
     * @exception AssertionError si adr est null
     */
    public void ajouter(Adresse adr) {
        assert (adr != null) : "Paramètre invalide, une adresse ne peut être nulle";
        for (int i = 0; i < adr.getNbreOctets(); ++i) {
            this.message.add(adr.getOctet(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.size(); ++i) {
            if (i < this.size() - 1) {
                s.append(this.getOctet(i).toString()).append(".");
            } else {
                s.append(this.getOctet(i).toString());
            }
        }
        return s.toString();
    }

    /**
     * Extraire les 2 octets situés en index et index+1 pour en faire un entier
     * octets forts puis faibles (big endian)
     * 
     * @param index index du premier octet
     * @exception AssertionError si index ou index+1 n'est pas dans le domaine du
     *                           tableau
     * @return un entier
     */
    public int extraireEntier(int index) {
        assert (index + 1 <= this.size()) : "L'index est en dehors de la taille du tableau";
        int a = this.getOctet(index).getValue() << 8;
        a+= this.getOctet(index + 1).getValue();
        return a;
    }

    /**
     * Extraire les nbOctets premiers octets pour en faire une adresse
     * 
     * @param nbOctets nombre d'octets à extraire
     * @exception AssertionError si nbOctets &gt; longueur du message
     * @return une adresse
     */
    public Adresse extraireAdresse(int nbOctets) {
        assert (nbOctets + 1 <= this.size()) : "Le nombre d'octets ne peut être supérieur à la taille du message";
        Adresse a = new Adresse();
        for (int i = 0; i < nbOctets - 1; ++i) {
            ajouter(this.getOctet(i));
        }
        return a;
    }

    /**
     * Transformer le message en une suite de lettres, si possible
     * 
     * @return null si l'un des octets n'est pas une lettre (maj ou min)
     */
    public String extraireChaine() {
        String s = "";
        for (int i = 0; i < this.size(); ++i) {
            if (this.getOctet(i).estUneLettre()) {
                s = s + (char) this.getOctet(i).getValue();
            } else {
                return null;
            }
        }
        return s;
    }

    /**
     * Augmenter de i chaque octet dont la valeur est comprise entre les valeurs bi
     * et bs
     * 
     * @param i  valeur à ajouter
     * @param bi borne inférieure, inclue
     * @param bs borne supérieure, inclue
     */
    public void augmenter(int i, int bi, int bs) {
        for (int j = bi; j <= bs; ++j) {
            this.message.set(j, new Octet(this.getOctet(j).getValue() + i));
        }
    }

    /**
     * On enlève les i premiers éléments
     * 
     * @param i nombre d'éléments à enlever
     * @exception AssertionError si i n'est pas dans le domaine du tableau
     */
    public void supprimer(int i) {
        assert (i <= this.size()) : "On ne peut pas enlever plus d'éléments que le nombre d'éléments du tableau";
        for (int j = 0; j < i; ++j) {
            this.message.remove(0);
        }
    }

    /**
     * On enlève les éléments entre debut et fin inclus
     * 
     * @param debut borne inférieure
     * @param fin   borne supérieure
     * @exception AssertionError si on n'a pas 0 &le; debut &le; fin &lt; size()
     */
    public void supprimer(int debut, int fin) {
        for (int j = debut; j <= fin; ++j) {
            this.message.remove(debut);
        }
    }

}
