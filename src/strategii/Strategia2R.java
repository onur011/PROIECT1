package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia2R implements Strategie {

    /**
     * Se aplica a doua strategie pentru rogue.
     */
    @Override
    public void strategie(final Jucator jucator) {
        jucator.modificaCoeficienti1(Constante.STRG_R_SCADE);
        jucator.modificaCoeficienti2(Constante.STRG_R_SCADE);
        jucator.setHp(jucator.getHp() + jucator.getHp() / Constante.R_PRIMESTE_HP);
    }
}
