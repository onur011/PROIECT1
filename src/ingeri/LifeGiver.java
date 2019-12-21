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
        knight.setHp(knight.getHp() + Constante.LIFEGIVER_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
    }

    /**
     * LifeGiver pentru Pyromaner.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.setHp(pyromancer.getHp() + Constante.LIFEGIVER_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
    }

    /**
     * LifeGiver pentru Rogue.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.setHp(rogue.getHp() + Constante.LIFEGIVER_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
    }

    /**
     * LifeGiver pentru Wizard.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.setHp(wizard.getHp() + Constante.LIFEGIVER_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
    }
}
