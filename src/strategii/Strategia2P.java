package strategii;

import jucatori.Jucator;
import utile.Constante;

public class Strategia2P implements Strategie {
    @Override
    public void strategie(Jucator jucator) {
        jucator.modificaCoeficienti1(Constante.STRG_P_SCADE);
        jucator.modificaCoeficienti2(Constante.STRG_P_SCADE);
        jucator.setHp(jucator.getHp() + jucator.getHp() / Constante.P_PRIMESTE_HP);
    }
}
