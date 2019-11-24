package jucatori;

import utile.Constante;

public final class Rogue extends Jucator implements Abilitati {
    private int numarLovituri;
    public Rogue(final int x, final int y, final char tip, final char type) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HPROGUE);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HPROGUE);
        this.setTipCaracter(type);
        this.setParalizat(false);
        this.setTimpParalizat(0);
        this.numarLovituri = 0;
    }
    @Override
    public void incepeLupta(final Jucator jucator) {
        jucator.lupta(this);
    }

    @Override
    public void lupta(final Knight knight) {
        this.atacaR(knight, Constante.MINUS10, Constante.MINUS20);
        knight.atacaK(this, Constante.PLUS15, Constante.MINUS20);

        this.dupaLupta(knight, Constante.D40, Constante.D80);
    }

    @Override
    public void lupta(final Rogue rogue) {
        this.atacaR(rogue, Constante.PLUS20, Constante.MINUS10);
        rogue.atacaR(this, Constante.PLUS20, Constante.MINUS10);

        this.dupaLupta(rogue, Constante.D40, Constante.D40);
    }

    @Override
    public void lupta(final Pyromancer pyromancer) {
        this.atacaR(pyromancer, Constante.PLUS25, Constante.PLUS20);
        pyromancer.atacaP(this, Constante.MINUS20);

        this.dupaLupta(pyromancer, Constante.D40, Constante.D50);
    }

    @Override
    public void lupta(final Wizard wizard) {
        this.atacaR(wizard, Constante.PLUS25, Constante.PLUS25);
        wizard.atacaW(this, Constante.MINUS20, Constante.PLUS20);

        this.dupaLupta(wizard, Constante.D40, Constante.D30);
    }

    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.MAXXP + this.getNivel() * Constante.D20;
        return dmg;
    }

    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.NIVEL + this.getNivel() * Constante.D10;
        return dmg;
    }

    public void atacaR(final Jucator jucator, final float bonusRasa1, final float bonusRasa2) {
        float dmg1, dmg2, bonusTeren = 1.0f, limita, procent, dmgFaraBonusRasa = 0, critica = 1f;
        int runde = Constante.INT3;

        if (this.getTipTeren() == 'W') {
            bonusTeren = Constante.PLUS15;
            if (this.numarLovituri % Constante.INT3 == 0) {
                critica = Constante.PLUS50;
            }
            runde = Constante.INT6;
        }
        this.numarLovituri++;

        dmg1 = this.abilitate1() * critica * bonusTeren * bonusRasa1;
        dmgFaraBonusRasa += Math.round(this.abilitate1() * critica * bonusTeren);

        dmg2 = this.abilitate2() * bonusTeren * bonusRasa2;
        dmgFaraBonusRasa += Math.round(this.abilitate2() * bonusTeren);
        jucator.setDmgFaraBonus(dmgFaraBonusRasa);
        jucator.setTimpParalizat(runde);
        jucator.setParalizat(true);
        jucator.setDmgO(Math.round(dmg2));
        jucator.setTimeDmgO(runde);
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
