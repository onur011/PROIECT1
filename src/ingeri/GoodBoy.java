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

    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        knight.modificaCoeficienti1(Constante.GOODBOY_K);
        knight.modificaCoeficienti2(Constante.GOODBOY_K);
        knight.setHp(knight.getHp() + Constante.GOODBOY_HP_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
    }

    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.modificaCoeficienti1(Constante.GOODBOY_P);
        pyromancer.modificaCoeficienti2(Constante.GOODBOY_P);
        pyromancer.setHp(pyromancer.getHp() + Constante.GOODBOY_HP_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
    }

    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.modificaCoeficienti1(Constante.GOODBOY_R);
        rogue.modificaCoeficienti2(Constante.GOODBOY_R);
        rogue.setHp(rogue.getHp() + Constante.GOODBOY_HP_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
    }

    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.modificaCoeficienti1(Constante.GOODBOY_W);
        wizard.modificaCoeficienti2(Constante.GOODBOY_W);
        wizard.setHp(wizard.getHp() + Constante.GOODBOY_HP_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
    }
}
