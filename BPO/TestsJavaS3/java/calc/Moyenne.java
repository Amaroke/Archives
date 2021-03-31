package calc;

public class Moyenne extends Naire {
    public Moyenne(Expression... e) {
        super(e);
    }

    public int valeur() {
        int somme = this.elem[0].valeur();
        for (int i = 1; i < this.elem.length; ++i) {
            somme += this.elem[i].valeur();
        }
        return somme/this.elem.length;
    }

    public String getOperateur() {
        return "moyenne";
    }
}