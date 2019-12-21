package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class TheDoomer extends Inger {

    public TheDoomer(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(false);
    }

    @Override
    public void acceptaInger(Knight knight) throws IOException {
        knight.setHp(0);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.omoratInger();
    }

    @Override
    public void acceptaInger(Pyromancer pyromancer) throws IOException {
        pyromancer.setHp(0);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.omoratInger();
    }

    @Override
    public void acceptaInger(Rogue rogue) throws IOException {
        rogue.setHp(0);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.omoratInger();
    }

    @Override
    public void acceptaInger(Wizard wizard) throws IOException {
        wizard.setHp(0);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.omoratInger();
    }
}
