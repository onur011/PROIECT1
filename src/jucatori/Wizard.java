package jucatori;

import utile.Constante;

public final class Wizard extends Jucator {
    public Wizard(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HPWIZZARD);
        this.setXp(0);
        this.setNivel(0);
    }
    @Override
    public void incepeLupta(final Jucator jucator) {
        jucator.lupta(this);
    }

    @Override
    public void lupta(final Knight knight) {
    }

    @Override
    public void lupta(final Rogue rogue) {

    }

    @Override
    public void lupta(final Pyromancer pyromancer) {

    }

    @Override
    public void lupta(final Wizard wizard) {

    }
}
