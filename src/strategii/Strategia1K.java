package strategii;

import jucatori.Jucator;
import strategii.Strategie;
import utile.Constante;

public class Strategia1K implements Strategie {
    @Override
    public void strategie(Jucator jucator) {
        jucator.setHp(jucator.getHp() - jucator.getHp() / Constante.K_PIERDE_HP);
        jucator.modificaCoeficienti1(Constante.STRG_K_CRESTE);
        jucator.modificaCoeficienti2(Constante.STRG_K_CRESTE);
    }
}
