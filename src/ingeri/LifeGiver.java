package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class LifeGiver extends Inger {

    public LifeGiver(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(true);
    }

    /**
     * LifeGiver pentru Knight.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        if (knight.getMort()) {
            return;
        }
        knight.setHp(knight.getHp() + Constante.LIFEGIVER_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.verificareHp();
    }

    /**
     * LifeGiver pentru Pyromaner.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getMort()) {
            return;
        }
        pyromancer.setHp(pyromancer.getHp() + Constante.LIFEGIVER_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.verificareHp();
    }

    /**
     * LifeGiver pentru Rogue.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        if (rogue.getMort()) {
            return;
        }
        rogue.setHp(rogue.getHp() + Constante.LIFEGIVER_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.verificareHp();
    }

    /**
     * LifeGiver pentru Wizard.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        if (wizard.getMort()) {
            return;
        }
        wizard.setHp(wizard.getHp() + Constante.LIFEGIVER_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.verificareHp();
    }
}
