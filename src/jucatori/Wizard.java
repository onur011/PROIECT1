package jucatori;

import utile.Constante;

public final class Wizard extends Jucator {

    public Wizard(final int x, final int y, final char tip, final char type) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HPWIZZARD);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HPWIZZARD);
        this.setTipCaracter(type);
        this.setParalizat(false);
        this.setTimpParalizat(0);
    }
    @Override
    public void incepeLupta(final Jucator jucator) {
        jucator.lupta(this);
    }

    @Override
    public void lupta(final Knight knight) {
        knight.atacaK(this, Constante.MINUS20, Constante.PLUS05);
        this.atacaW(knight, Constante.PLUS20, Constante.PLUS40);

        this.dupaLupta(knight, Constante.D30, Constante.D80);
    }

    @Override
    public void lupta(final Rogue rogue) {
    }

    @Override
    public void lupta(final Pyromancer pyromancer) {
        pyromancer.atacaP(this, Constante.PLUS05);
        this.atacaW(pyromancer, Constante.MINUS10, Constante.PLUS30);

        this.dupaLupta(pyromancer, Constante.D30, Constante.D50);
    }

    @Override
    public void lupta(final Wizard wizard) {
        wizard.atacaW(this, Constante.PLUS05, 0);
        this.atacaW(wizard, Constante.PLUS05, 0);

        this.dupaLupta(wizard, Constante.D30, Constante.D30);
    }

    public void atacaW(final Jucator jucator, final float bonusRasa1, final float bonusRasa2) {
        float dmg1, dmg2 = 0, procent, procent2, bonusTeren = 1.0f;

        if (this.getTipTeren() == 'D') {
            bonusTeren = Constante.PLUS10;
        }
        procent = Constante.MINUS80 + this.getNivel() * Constante.MINUS95;
        dmg1 = procent * Math.min(Constante.MINUS70 * jucator.getHpInitial(), jucator.getHp())
              * bonusTeren * bonusRasa1;

        if (jucator.getTipCaracter() != 'W') {
            procent2 = Constante.MINUS65 + this.getNivel() * Constante.MINUS98;
            if (procent2 > Constante.MINUS30) {
                procent2 = Constante.MINUS30;
            }
            dmg2 = procent2 * this.getDmgFaraBonus() * bonusTeren * bonusRasa2;
        }

        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
