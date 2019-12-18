package jucatori;

import utile.Constante;

import java.io.IOException;

public final class Pyromancer extends Jucator implements Abilitati {

    //Constructor Pyromancer
    public Pyromancer(final int x, final int y, final char tip, final char type, final int id) {
        this.setId(id);
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
    public void incepeLupta(final Jucator jucator) throws IOException {
        jucator.lupta(this);
    }

    //Pyromancer vs Knight
    @Override
    public void lupta(final Knight knight) throws IOException {
        knight.atacaK(this, Constante.K_LUPTA_P_ABL_1, Constante.K_LUPTA_P_ABL_2);
        this.atacaP(knight, Constante.P_LUPTA_K);

        this.dupaLupta(knight, Constante.HP_NIVEL_P, Constante.HP_NIVEL_K);
    }

    //Pyromancer vs Rogue
    @Override
    public void lupta(final Rogue rogue) throws IOException {
        rogue.atacaR(this, Constante.R_LUPTA_P_ABL_1, Constante.R_LUPTA_P_ABL_2);
        this.atacaP(rogue, Constante.P_LUPTA_R);

        this.dupaLupta(rogue, Constante.HP_NIVEL_P, Constante.HP_NIVEL_R);
    }

    //Pyromancer vs Pyromancer
    @Override
    public void lupta(final Pyromancer pyromancer) throws IOException {
        this.atacaP(pyromancer, Constante.P_LUPTA_P);
        pyromancer.atacaP(this, Constante.P_LUPTA_P);

        this.dupaLupta(pyromancer, Constante.HP_NIVEL_P, Constante.HP_NIVEL_P);
    }

    //Pyromancer vs Wizard
    @Override
    public void lupta(final Wizard wizard) throws IOException {
        this.atacaP(wizard, Constante.P_LUPTA_W);
        wizard.atacaW(this, Constante.W_LUPTA_P_ABL_1, Constante.W_LUPTA_P_ABL_2);

        this.dupaLupta(wizard, Constante.HP_NIVEL_P, Constante.HP_NIVEL_W);
    }

    //Fireblast dmg
    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.DMG_ABL_1_P + Constante.DMG_NIVEL_ABL_1_P * this.getNivel();
        return dmg;
    }

    //Ignite dmg
    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.DMG_ABL_2_P + Constante.DMG_NIVEL_ABL_2_P * this.getNivel();
        return dmg;
    }

    //Functia in care atacator este Pyromancer
    public void atacaP(final Jucator jucator, final float bonusRasa) {
        float dmg1, dmg2, dmg2periodic, bonusTeren = Constante.BONUS_TEREN_NEUTRU,
        dmgFaraBonusRasa = Constante.ZERO;

        //Bonus teren
        if (this.getTipTeren() == 'V') {
            bonusTeren = Constante.BONUS_TEREN_P;
        }
        //Fireblast
        dmg1 = this.abilitate1() * bonusTeren * bonusRasa;
        dmgFaraBonusRasa += Math.round(this.abilitate1() * bonusTeren);

        //Ignite
        dmg2 = this.abilitate2() * bonusTeren * bonusRasa;
        dmgFaraBonusRasa += Math.round(this.abilitate2() * bonusTeren);
        dmg2periodic = (Constante.OVERTIME_P + Constante.OVERTIME_NIVEL_P * this.getNivel())
        * bonusTeren * bonusRasa;
        jucator.setDmgFaraBonus(dmgFaraBonusRasa);
        jucator.setTimpParalizat((int) Constante.ZERO);
        jucator.setParalizat(false);
        jucator.setDmgO(Math.round(dmg2periodic));
        jucator.setTimeDmgO(Constante.OVERTIME_TIMP_P);

        //Se adauga dmg pe care trebuie sa il ia jucator
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
