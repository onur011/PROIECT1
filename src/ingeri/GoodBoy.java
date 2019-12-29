package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class GoodBoy extends Inger {

    public GoodBoy(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(true);
    }

    /**
     * knight cu GoodBoy.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        if (knight.getMort()) {
            return;
        }
        knight.modificaCoeficienti1(Constante.GOODBOY_K);
        knight.modificaCoeficienti2(Constante.GOODBOY_K);
        knight.setVsKnight1(1f);
        knight.setHp(knight.getHp() + Constante.GOODBOY_HP_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        //knight.verificareHp();
    }

    /**
     * pyromancer cu GoodBoy.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getMort()) {
            return;
        }
        pyromancer.modificaCoeficienti1(Constante.GOODBOY_P);
        pyromancer.modificaCoeficienti2(Constante.GOODBOY_P);
        pyromancer.setHp(pyromancer.getHp() + Constante.GOODBOY_HP_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        //pyromancer.verificareHp();
    }

    /**
     * rogue cu GoodBoy.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        if (rogue.getMort()) {
            return;
        }
        rogue.modificaCoeficienti1(Constante.GOODBOY_R);
        rogue.modificaCoeficienti2(Constante.GOODBOY_R);
        rogue.setHp(rogue.getHp() + Constante.GOODBOY_HP_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        //rogue.verificareHp();
    }

    /**
     * wizard cu GoodBoy.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        if (wizard.getMort()) {
            return;
        }
        wizard.modificaCoeficienti1(Constante.GOODBOY_W);
        wizard.modificaCoeficienti2(Constante.GOODBOY_W);
        wizard.setHp(wizard.getHp() + Constante.GOODBOY_HP_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        //wizard.verificareHp();
    }
}
