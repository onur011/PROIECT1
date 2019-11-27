package jucatori;

import utile.Constante;

public final class Pyromancer extends Jucator implements Abilitati {

    public Pyromancer(final int x, final int y, final char tip, final char type) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HP_INITIAL_P);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HP_INITIAL_P);
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
        knight.atacaK(this, Constante.K_LUPTA_P_ABL_1, Constante.K_LUPTA_P_ABL_2);
        this.atacaP(knight, Constante.P_LUPTA_K);

        this.dupaLupta(knight, Constante.HP_NIVEL_P, Constante.HP_NIVEL_K);
    }

    @Override
    public void lupta(final Rogue rogue) {
        rogue.atacaR(this, Constante.R_LUPTA_P_ABL_1, Constante.R_LUPTA_P_ABL_2);
        this.atacaP(rogue, Constante.P_LUPTA_R);

        this.dupaLupta(rogue, Constante.HP_NIVEL_P, Constante.HP_NIVEL_R);
    }

    @Override
    public void lupta(final Pyromancer pyromancer) {
        this.atacaP(pyromancer, Constante.P_LUPTA_P);
        pyromancer.atacaP(this, Constante.P_LUPTA_P);

        this.dupaLupta(pyromancer, Constante.HP_NIVEL_P, Constante.HP_NIVEL_P);
    }

    @Override
    public void lupta(final Wizard wizard) {
        this.atacaP(wizard, Constante.P_LUPTA_W);
        wizard.atacaW(this, Constante.W_LUPTA_P_ABL_1, Constante.W_LUPTA_P_ABL_2);

        this.dupaLupta(wizard, Constante.HP_NIVEL_P, Constante.HP_NIVEL_W);
    }

    //Fireblast
    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.DMG_ABL_1_P + Constante.DMG_NIVEL_ABL_1_P * this.getNivel();
        return dmg;
    }

    //Ignite
    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.DMG_ABL_2_P + Constante.DMG_NIVEL_ABL_2_P * this.getNivel();
        return dmg;
    }

    /**Functia de atac al Pyromancer.
     * @param jucator pe cine ataca.
     * @param bonusRasa bonusul de rasa.
     */
    public void atacaP(final Jucator jucator, final float bonusRasa) {
        float dmg1, dmg2, dmg2periodic, bonusTeren = Constante.BONUS_TEREN_NEUTRU,
        dmgFaraBonusRasa = Constante.ZERO;

        if (this.getTipTeren() == 'V') {
            bonusTeren = Constante.BONUS_TEREN_P;
        }
        //Se calculeaza dmg dat de primul jucator celui de al doilea.
        //Demage total este pus in variabila damage a celui care primeste dmg.
        dmg1 = this.abilitate1() * bonusTeren * bonusRasa;
        dmgFaraBonusRasa += Math.round(this.abilitate1() * bonusTeren);

        dmg2 = this.abilitate2() * bonusTeren * bonusRasa;
        dmgFaraBonusRasa += Math.round(this.abilitate2() * bonusTeren);
        dmg2periodic = (Constante.OVERTIME_P + Constante.OVERTIME_NIVEL_P * this.getNivel())
        * bonusTeren * bonusRasa;
        jucator.setDmgFaraBonus(dmgFaraBonusRasa);
        jucator.setTimpParalizat((int) Constante.ZERO);
        jucator.setParalizat(false);
        jucator.setDmgO(Math.round(dmg2periodic));
        jucator.setTimeDmgO(Constante.OVERTIME_TIMP_P);
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
