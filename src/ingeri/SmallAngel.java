package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class SmallAngel extends Inger {

    public SmallAngel(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(true);
    }

    /**
     * knight cu SmallAngel.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        knight.modificaCoeficienti1(Constante.SMALLANGEL_K);
        knight.modificaCoeficienti2(Constante.SMALLANGEL_K);
        knight.setHp(knight.getHp() + Constante.SMALLANGEL_HP_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.verificareHp();
    }

    /**
     * pyromancer cu SmallAngel.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.modificaCoeficienti1(Constante.SMALLANGEL_P);
        pyromancer.setHp(pyromancer.getHp() + Constante.SMALLANGEL_HP_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.verificareHp();
    }

    /**
     * rogue cu SmallAngel.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.modificaCoeficienti1(Constante.SMALLANGEL_R);
        rogue.modificaCoeficienti2(Constante.SMALLANGEL_R);
        rogue.setHp(rogue.getHp() + Constante.SMALLANGEL_HP_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.verificareHp();
    }

    /**
     * wizard cu SmallAngel.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.modificaCoeficienti1(Constante.SMALLANGEL_W);
        wizard.modificaCoeficienti2(Constante.SMALLANGEL_W);
        wizard.setHp(wizard.getHp() + Constante.SMALLANGEL_HP_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.verificareHp();
    }
}
