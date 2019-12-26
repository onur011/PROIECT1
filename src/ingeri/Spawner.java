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

    /**
     * knight cu Spawner.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        if (!knight.getMort()) {
            return;
        }
        knight.setMort(false);
        knight.setHp(Constante.SPAWNER_K);
        knight.setXp(knight.getXpInitial());
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.notificaObserveri(this.outputSpawn(knight));

    }

    /**
     * pyromancer cu Spawner.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        if (!pyromancer.getMort()) {
            return;
        }
        pyromancer.setMort(false);
        pyromancer.setHp(Constante.SPAWNER_P);
        pyromancer.setXp(pyromancer.getXpInitial());
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.notificaObserveri(this.outputSpawn(pyromancer));
    }

    /**
     * rogue cu Spawner.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        if (!rogue.getMort()) {
            return;
        }
        rogue.setMort(false);
        rogue.setHp(Constante.SPAWNER_R);
        rogue.setXp(rogue.getXpInitial());
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.notificaObserveri(this.outputSpawn(rogue));
    }

    /**
     * wizard cu Spawner.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        if (!wizard.getMort()) {
            return;
        }
        wizard.setMort(false);
        wizard.setHp(Constante.SPAWNER_W);
        wizard.setXp(wizard.getXpInitial());
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.notificaObserveri(this.outputSpawn(wizard));
    }
}
