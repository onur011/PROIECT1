package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia1W implements Strategie {
    @Override
    public void strategie(Jucator jucator) {
        jucator.setHp(jucator.getHp() - jucator.getHp() / Constante.W_PIERDE_HP);
        jucator.modificaCoeficienti1(Constante.STRG_W_CRESTE);
        jucator.modificaCoeficienti2(Constante.STRG_W_CRESTE);
    }
}
