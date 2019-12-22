package ingeri;



import jucatori.Knight;
import jucatori.Pyromancer;
import jucatori.Rogue;
import jucatori.Wizard;
import jucatori.Jucator;
import utile.Constante;

import java.io.IOException;

public class LevelUpAngel extends Inger {

    public LevelUpAngel(final String tip, final int x, final int y) {
        setTipInger(tip);
        setX(x);
        setY(y);
        setBun(true);
    }

    /**
     * knight cu LevelUpAngel.
     */
    @Override
    public void acceptaInger(final Knight knight) throws IOException {
        knight.modificaCoeficienti1(Constante.LEVELUPANGEL_K);
        knight.modificaCoeficienti2(Constante.LEVELUPANGEL_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
        this.lvUp(knight, Constante.HP_NIVEL_K);
    }

    /**
     * pyromancer cu LevelUpAngel.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        pyromancer.modificaCoeficienti1(Constante.LEVELUPANGEL_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
        this.lvUp(pyromancer, Constante.HP_NIVEL_P);
    }

    /**
     * rogue cu LevelUpAngel.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        rogue.modificaCoeficienti1(Constante.LEVELUPANGEL_R);
        rogue.modificaCoeficienti2(Constante.LEVELUPANGEL_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
        this.lvUp(rogue, Constante.HP_NIVEL_R);
    }

    /**
     * wizard cu LevelUpAngel.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        wizard.modificaCoeficienti1(Constante.LEVELUPANGEL_W);
        wizard.modificaCoeficienti2(Constante.LEVELUPANGEL_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
        this.lvUp(wizard, Constante.HP_NIVEL_W);
    }

    /**
     * Se mareste nivelul jucatorului.
     */
    public void lvUp(final Jucator jucator, final int hpNivelNou) throws IOException {
        //Se adauga xp necesar pentru a ajunge la urmatorul nivel.
        int aux = jucator.getXp();
        int nivel = aux / Constante.XP_PER_NIVEL;
        nivel++;
        jucator.setXp(nivel * Constante.XP_PER_NIVEL);
        //Se modifica nivelul si hp jucatorului.
        jucator.nouNivel(hpNivelNou);
    }
}

