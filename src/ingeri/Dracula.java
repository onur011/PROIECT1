package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class Dracula extends Inger {

    public Dracula(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(false);
    }

    /**
     * knight cu Dracula.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        if (knight.getMort()) {
            return;
        }
        knight.modificaCoeficienti1(Constante.DRACULA_K);
        knight.modificaCoeficienti2(Constante.DRACULA_K);
        knight.setVsKnight1(1f);
        knight.setHp(knight.getHp() - Constante.DRACULA_HP_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.omoratInger();
    }

    /**
     * pyromancer cu Dracula.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getMort()) {
            return;
        }
        pyromancer.modificaCoeficienti1(Constante.DRACULA_P);
        pyromancer.setHp(pyromancer.getHp() - Constante.DRACULA_HP_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.omoratInger();
    }

    /**
     * rogue cu Dracula.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        if (rogue.getMort()) {
            return;
        }
        rogue.modificaCoeficienti1(Constante.DRACULA_R);
        rogue.modificaCoeficienti2(Constante.DRACULA_R);
        rogue.setHp(rogue.getHp() - Constante.DRACULA_HP_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.omoratInger();
    }

    /**
     * wizard cu Dracula.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        if (wizard.getMort()) {
            return;
        }
        wizard.modificaCoeficienti1(Constante.DRACULA_W);
        wizard.modificaCoeficienti2(Constante.DRACULA_W);
        wizard.setHp(wizard.getHp() - Constante.DRACULA_HP_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.omoratInger();
    }
}
