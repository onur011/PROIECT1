package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia1R implements Strategie {
    @Override
    public void strategie(Jucator jucator) {
        jucator.setHp(jucator.getHp() - jucator.getHp() / Constante.R_PIERDE_HP);
        jucator.modificaCoeficienti1(Constante.STRG_R_CRESTE);
        jucator.modificaCoeficienti2(Constante.STRG_R_CRESTE);
    }
}
