package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class XPAngel extends Inger {

    public XPAngel(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(true);
    }

    /**
     * knight cu XPAngel.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        knight.setXp(knight.getXp() + Constante.XPANGEL_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.nouNivel(Constante.HP_NIVEL_K);
    }

    /**
     * pyromancer cu XPAngel.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.setXp(pyromancer.getXp() + Constante.XPANGEL_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.nouNivel(Constante.HP_NIVEL_P);
    }

    /**
     * rogue cu XPAngel.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.setXp(rogue.getXp() + Constante.XPANGEL_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.nouNivel(Constante.HP_NIVEL_R);
    }

    /**
     * wizard cu XPAngel.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.setXp(wizard.getXp() + Constante.XPANGEL_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.nouNivel(Constante.HP_NIVEL_W);
    }
}
