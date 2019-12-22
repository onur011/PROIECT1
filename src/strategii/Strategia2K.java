package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia2K implements Strategie {

    /**
     * Se aplica a doua strategie pentru knight.
     */
    @Override
    public void strategie(final Jucator jucator) {
        jucator.modificaCoeficienti1(Constante.STRG_K_SCADE);
        jucator.modificaCoeficienti2(Constante.STRG_K_SCADE);
        jucator.setHp(jucator.getHp() + jucator.getHp() / Constante.K_PRIMESTE_HP);
    }
}
