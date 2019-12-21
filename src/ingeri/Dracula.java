package ingeri;

import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import utile.Constante;

import java.io.IOException;

public class Dracula extends Inger {

    public Dracula(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(false);
    }

    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        knight.modificaCoeficienti1(Constante.DRACULA_K);
        knight.modificaCoeficienti2(Constante.DRACULA_K);
        knight.setHp(knight.getHp() - Constante.DRACULA_HP_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        knight.omoratInger();
    }

    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.modificaCoeficienti1(Constante.DRACULA_P);
        pyromancer.setHp(pyromancer.getHp() - Constante.DRACULA_HP_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        pyromancer.omoratInger();
    }

    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.modificaCoeficienti1(Constante.DRACULA_R);
        rogue.modificaCoeficienti2(Constante.DRACULA_R);
        rogue.setHp(rogue.getHp() - Constante.DRACULA_HP_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        rogue.omoratInger();
    }

    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.modificaCoeficienti1(Constante.DRACULA_W);
        wizard.modificaCoeficienti2(Constante.DRACULA_W);
        wizard.setHp(wizard.getHp() - Constante.DRACULA_HP_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        wizard.omoratInger();
    }
}
