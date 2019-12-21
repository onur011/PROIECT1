package strategii;

import jucatori.Jucator;

public class Context {
    private Strategie strategie;

    public Context(final Strategie strategie) {
        this.strategie = strategie;
    }

    /**
     * @param jucator .
     */
    public void executaStrategie(final Jucator jucator) {
        strategie.strategie(jucator);
    }
}
