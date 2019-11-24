package jucatori;

import utile.Constante;

public final class Knight extends Jucator implements Abilitati {

    public Knight(final int x, final int y, final char tip, final char type) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HPKNIGHT);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HPKNIGHT);
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
        this.atacaK(knight, 1, Constante.PLUS20);
        knight.atacaK(this, 1, Constante.PLUS20);

        this.dupaLupta(knight, Constante.D80, Constante.D80);
    }

    @Override
    public void lupta(final Rogue rogue) {
        rogue.atacaR(this, Constante.MINUS10, Constante.MINUS20);
        this.atacaK(rogue, Constante.PLUS15, Constante.MINUS20);

        this.dupaLupta(rogue, Constante.D80, Constante.D40);
    }

    @Override
    public void lupta(final Pyromancer pyromancer) {
        this.atacaK(pyromancer, Constante.PLUS10, Constante.MINUS10);
        pyromancer.atacaP(this, Constante.PLUS20);

        this.dupaLupta(pyromancer, Constante.D80, Constante.D50);
    }

    @Override
    public void lupta(final Wizard wizard) {
        this.atacaK(wizard, Constante.MINUS20, Constante.PLUS05);
        wizard.atacaW(this, Constante.PLUS20, Constante.PLUS40);

        this.dupaLupta(wizard, Constante.D80, Constante.D30);

    }
    //Execute
    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.MAXXP + this.getNivel() * Constante.D30;
        return dmg;
    }

    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.D100 + this.getNivel() * Constante.NIVEL;
        return dmg;
    }

    public void atacaK(final Jucator jucator, final float bonusRasa1, final float bonusRasa2) {
        float dmg1, dmg2, bonusTeren = 1.0f, limita, procent, dmgFaraBonusRasa = 0;

        if (this.getTipTeren() == 'L') {
           bonusTeren = Constante.PLUS15;
        }

        procent = Constante.MINUS80 + this.getNivel() * Constante.MINUS99;
        if (procent > Constante.MINUS60) {
            procent = Constante.MINUS60;
        }

        limita = procent * jucator.getHpInitial();

        if (jucator.getHp() < limita) {
            dmg1 = jucator.getHp();
            dmgFaraBonusRasa += dmg1;
        } else {
            dmg1 = this.abilitate1() * bonusTeren * bonusRasa1;
            dmgFaraBonusRasa += Math.round(this.abilitate1() * bonusTeren);
        }

        dmg2 = this.abilitate2() * bonusTeren * bonusRasa2;
        dmgFaraBonusRasa += Math.round(this.abilitate2() * bonusTeren);
        jucator.setDmgFaraBonus(dmgFaraBonusRasa);
        jucator.setDmgO(0);
        jucator.setTimeDmgO(0);
        jucator.setParalizat(true);
        jucator.setTimpParalizat(1);
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
