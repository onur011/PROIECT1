package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia2W implements Strategie {

    /**
     * Se aplica a doua strategie pentru wizard.
     */
    @Override
    public void strategie(final Jucator jucator) {
        jucator.modificaCoeficienti1(Constante.STRG_W_SCADE);
        jucator.modificaCoeficienti2(Constante.STRG_W_SCADE);
        jucator.setHp(jucator.getHp() + jucator.getHp() / Constante.W_PRIMESTE_HP);
    }
}
