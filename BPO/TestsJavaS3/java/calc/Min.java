package calc;

public class Min extends Naire {
    public Min(Expression... e) {
        super(e);
    }

    public int valeur() {
        int mini = this.elem[0].valeur();
        for (int i = 1; i < this.elem.length; ++i) {
            if (mini > this.elem[i].valeur()) {
                mini = this.elem[i].valeur();
            }
        }
        return mini;
    }

    public String getOperateur() {
        return "min";
    }
}