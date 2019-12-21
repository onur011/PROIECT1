package ingeri;


import jucatori.*;
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
        this.lvUp(knight, Constante.HP_NIVEL_K);
        knight.modificaCoeficienti1(Constante.LEVELUPANGEL_K);
        knight.modificaCoeficienti2(Constante.LEVELUPANGEL_K);
        knight.notificaObserveri(this.seteazaOutput(knight));
    }

    /**
     * pyromancer cu LevelUpAngel.
     */
    @Override
    public void acceptaInger(final Pyromancer pyromancer) throws IOException {
        this.lvUp(pyromancer, Constante.HP_NIVEL_P);
        pyromancer.modificaCoeficienti1(Constante.LEVELUPANGEL_P);
        pyromancer.notificaObserveri(this.seteazaOutput(pyromancer));
    }

    /**
     * rogue cu LevelUpAngel.
     */
    @Override
    public void acceptaInger(final Rogue rogue) throws IOException {
        this.lvUp(rogue, Constante.HP_NIVEL_R);
        rogue.modificaCoeficienti1(Constante.LEVELUPANGEL_R);
        rogue.modificaCoeficienti2(Constante.LEVELUPANGEL_R);
        rogue.notificaObserveri(this.seteazaOutput(rogue));
    }

    /**
     * wizard cu LevelUpAngel.
     */
    @Override
    public void acceptaInger(final Wizard wizard) throws IOException {
        this.lvUp(wizard, Constante.HP_NIVEL_W);
        wizard.modificaCoeficienti1(Constante.LEVELUPANGEL_W);
        wizard.modificaCoeficienti2(Constante.LEVELUPANGEL_W);
        wizard.notificaObserveri(this.seteazaOutput(wizard));
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

