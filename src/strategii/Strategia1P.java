package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia1P implements Strategie {
    @Override
    public void strategie(Jucator jucator) {
        jucator.setHp(jucator.getHp() - jucator.getHp() / Constante.P_PIERDE_HP);
        jucator.modificaCoeficienti1(Constante.STRG_P_CRESTE);
        jucator.modificaCoeficienti2(Constante.STRG_P_CRESTE);
    }
}
