package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia1K implements Strategie {

    /**
     * Se aplica prima strategie pentru knight.
     */
    @Override
    public void strategie(final Jucator jucator) {
        jucator.setHp(jucator.getHp() - jucator.getHp() / Constante.K_PIERDE_HP);
        jucator.modificaCoeficienti1(Constante.STRG_K_CRESTE);
        jucator.modificaCoeficienti2(Constante.STRG_K_CRESTE);
    }
}
