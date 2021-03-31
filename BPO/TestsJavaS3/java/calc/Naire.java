package calc;

public abstract class Naire implements Expression {
    protected Expression[] elem;

    public Naire(Expression[] e) {
        this.elem = new Expression[e.length];
        for (int i = 0; i < elem.length; ++i) {
            this.elem[i] = e[i];
        }
    }

    public String toString() {
        String s = getOperateur() + "(";
        for (int i = 0; i < elem.length; ++i) {
            s = s + "(" + elem[i] + ")";
        }
        return s + ")";
    }

    public abstract String getOperateur();
}