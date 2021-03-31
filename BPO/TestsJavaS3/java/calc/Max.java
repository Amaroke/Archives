package calc;

public class Max extends Naire {
    public Max(Expression... e) {
        super(e);
    }

    public int valeur() {
        int maxi = this.elem[0].valeur();
        for (int i = 1; i < this.elem.length; ++i) {
            if (maxi < this.elem[i].valeur()) {
                maxi = this.elem[i].valeur();
            }
        }
        return maxi;
    }

    public String getOperateur() {
        return "max";
    }
}