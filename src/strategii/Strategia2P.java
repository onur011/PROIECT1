package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia2P implements Strategie {

    /**
     * Se aplica a doua strategie pentru pyromancer.
     */
    @Override
    public void strategie(final Jucator jucator) {
        jucator.modificaCoeficienti1(Constante.STRG_P_SCADE);
        jucator.modificaCoeficienti2(Constante.STRG_P_SCADE);
        jucator.setHp(jucator.getHp() + jucator.getHp() / Constante.P_PRIMESTE_HP);
    }
}
