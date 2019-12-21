package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class Spawner extends Inger {

    public Spawner(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(true);
    }

    @Override
    public void acceptaInger(Knight knight) throws IOException {
        knight.setMort(false);
        knight.setHp(Constante.SPAWNER_K);
        knight.notificaObserveri(this.seteazaOutput(knight));

    }

    @Override
    public void acceptaInger(Pyromancer pyromancer) throws IOException {
        pyromancer.setMort(false);
        pyromancer.setHp(Constante.SPAWNER_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
    }

    @Override
    public void acceptaInger(Rogue rogue) throws IOException {
        rogue.setMort(false);
        rogue.setHp(Constante.SPAWNER_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
    }

    @Override
    public void acceptaInger(Wizard wizard) throws IOException {
        wizard.setMort(false);
        wizard.setHp(Constante.SPAWNER_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
    }
}
