package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class DarkAngel extends Inger {

    public DarkAngel(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(false);
    }

    /**
     * knight cu DarkAngel.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        knight.setHp(knight.getHp() - Constante.DARKANGEL_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.omoratInger();
    }

    /**
     * pyromancer cu DarkAngel.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.setHp(pyromancer.getHp() - Constante.DARKANGEL_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.omoratInger();
    }

    /**
     * rogue cu DarkAngel.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.setHp(rogue.getHp() - Constante.DARKANGEL_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.omoratInger();
    }

    /**
     * wizard cu DarkAngel.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.setHp(wizard.getHp() - Constante.DARKANGEL_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.omoratInger();
    }
}
