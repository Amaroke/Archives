package lanceur;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La classe LanceurJeu permet de démarrer un jeu à deux joueurs, défini par une classe possédant
 * - un constructeur avec 0, .. k entiers en paramètres
 * - une méthode void unePartie()
 */

public class LanceurJeu {

    private final String[] arguments;

    public LanceurJeu(String[] args) {
        arguments = args;
    }

    public void jouer() throws ClassNotFoundException, ExceptionJeu, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        if (arguments.length != 0) {
            Class<?> classe = Class.forName(arguments[0]);
            Constructor<?>[] constructeurs = classe.getConstructors();
            Constructor<?> constructeur = null;
            for (Constructor<?> i : constructeurs) {
                if (i.getParameterCount() == arguments.length - 1) constructeur = i;
            }
            if(constructeur == null){
                throw new ExceptionJeu("Aucun lancement disponnible avec ce genre d'arguments !");
            }
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 1; i < arguments.length; i++) {
                Matcher m = Pattern.compile("(\\d+)").matcher(arguments[i]);
                if (m.find()) {
                    array.add(Integer.parseInt(arguments[i]));
                } else {
                    throw new ExceptionJeu("Un des paramètresest incorrect !");
                }
            }
            Object objet = constructeur.newInstance(array.toArray());
            Method methode = classe.getMethod("unePartie");
            methode.invoke(objet);
        } else {
            throw new ExceptionJeu("Vous avez besoin d'arguments lors du lancement d'un jeu !");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, ExceptionJeu, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        LanceurJeu j = new LanceurJeu(args);
        j.jouer();
    }
}