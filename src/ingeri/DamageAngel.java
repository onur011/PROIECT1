package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class DamageAngel extends Inger {

    public DamageAngel(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(true);
    }

    /**
     * knight cu DamageAngel.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        if (knight.getMort()) {
            return;
        }
        knight.modificaCoeficienti1(Constante.DAMAGEANGEL_K);
        knight.modificaCoeficienti2(Constante.DAMAGEANGEL_K);
        knight.setVsKnight1(1f);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.omoratInger();
    }

    /**
     * pyromancer cu DamageAngel.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getMort()) {
            return;
        }
        pyromancer.modificaCoeficienti1(Constante.DAMAGEANGEL_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.omoratInger();
    }

    /**
     * rogue cu DamageAngel.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        if (rogue.getMort()) {
            return;
        }
        rogue.modificaCoeficienti1(Constante.DAMAGEANGEL_R);
        rogue.modificaCoeficienti2(Constante.DAMAGEANGEL_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.omoratInger();
    }

    /**
     * wizard cu DamageAngel.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        if (wizard.getMort()) {
            return;
        }
        wizard.modificaCoeficienti1(Constante.DAMAGEANGEL_W);
        wizard.modificaCoeficienti2(Constante.DAMAGEANGEL_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.omoratInger();
    }
}
