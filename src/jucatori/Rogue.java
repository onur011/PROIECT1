package jucatori;

import utile.Constante;

public final class Rogue extends Jucator implements Abilitati {
    private int numarLovituri;
    public Rogue(final int x, final int y, final char tip, final char type) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HP_INITIAL_R);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HP_INITIAL_R);
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
        this.atacaR(knight, Constante.R_LUPTA_K_ABL_1, Constante.R_LUPTA_K_ABL_2);
        knight.atacaK(this, Constante.K_LUPTA_R_ABL_1, Constante.K_LUPTA_R_ABL_2);

        this.dupaLupta(knight, Constante.HP_NIVEL_R, Constante.HP_NIVEL_K);
    }

    @Override
    public void lupta(final Rogue rogue) {
        this.atacaR(rogue, Constante.R_LUPTA_R_ABL_1, Constante.R_LUPTA_R_ABL_2);
        rogue.atacaR(this, Constante.R_LUPTA_R_ABL_1, Constante.R_LUPTA_R_ABL_2);

        this.dupaLupta(rogue, Constante.HP_NIVEL_R, Constante.HP_NIVEL_R);
    }

    @Override
    public void lupta(final Pyromancer pyromancer) {
        this.atacaR(pyromancer, Constante.R_LUPTA_P_ABL_1, Constante.R_LUPTA_P_ABL_2);
        pyromancer.atacaP(this, Constante.P_LUPTA_R);

        this.dupaLupta(pyromancer, Constante.HP_NIVEL_R, Constante.HP_NIVEL_P);
    }

    @Override
    public void lupta(final Wizard wizard) {
        this.atacaR(wizard, Constante.R_LUPTA_W_ABL_1, Constante.R_LUPTA_P_ABL_2);
        wizard.atacaW(this, Constante.W_LUPTA_R_ABL_1, Constante.W_LUPTA_R_ABL_2);

        this.dupaLupta(wizard, Constante.HP_NIVEL_R, Constante.HP_NIVEL_W);
    }

    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.DMG_ABL_1_R + this.getNivel() * Constante.DMG_NIVEL_ABL_1_R;
        return dmg;
    }

    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.DMG_ABL_2_R + this.getNivel() * Constante.DMG_NIVEL_ABL_2_R;
        return dmg;
    }

    public void atacaR(final Jucator jucator, final float bonusRasa1, final float bonusRasa2) {
        float dmg1, dmg2, bonusTeren = Constante.BONUS_TEREN_NEUTRU, limita, procent,
        dmgFaraBonusRasa = Constante.ZERO, critica = Constante.CRITICA_NORMALA_R;
        int runde = Constante.OVERTIME_TIMP_R;

        if (this.getTipTeren() == 'W') {
            bonusTeren = Constante.BONUS_TEREN_R;
            if (this.numarLovituri % Constante.CRITICA_PER_RUNDE == 0) {
                critica = Constante.CRITICA_BONUS_R;
            }
            runde = Constante.OVERTIME_TIMP_BONUS_R;
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
