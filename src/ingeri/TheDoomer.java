package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;

import java.io.IOException;

public class TheDoomer extends Inger {

    public TheDoomer(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(false);
    }

    /**
     * knight cu TheDoomer.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        knight.setHp(0);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.omoratInger();
    }

    /**
     * pyromancer cu TheDoomer.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.setHp(0);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.omoratInger();
    }

    /**
     * rogue cu TheDoomer.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.setHp(0);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.omoratInger();
    }

    /**
     * wizard cu TheDoomer.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.setHp(0);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.omoratInger();
    }
}
