package jucatori;

import ingeri.Inger;
import strategii.Context;
import strategii.Strategia1R;
import strategii.Strategia2R;
import utile.Constante;

import java.io.IOException;

public final class Rogue extends Jucator implements Abilitati {
    //Memoreaza cate lupte a avut un Rogue (este utilizat pentru critica)
    private int numarLovituri;

    //Constructor Rogue
    public Rogue(final int x, final int y, final char tip, final char type, final int id) {
        this.setId(id);
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
        this.setVsKnight1(Constante.R_LUPTA_K_ABL_1);
        this.setVsPyromancer1(Constante.R_LUPTA_P_ABL_1);
        this.setVsRogue1(Constante.R_LUPTA_R_ABL_1);
        this.setVsWizard1(Constante.R_LUPTA_W_ABL_1);
        this.setVsKnight2(Constante.R_LUPTA_K_ABL_2);
        this.setVsPyromancer2(Constante.R_LUPTA_P_ABL_2);
        this.setVsRogue2(Constante.R_LUPTA_R_ABL_2);
        this.setVsWizard2(Constante.R_LUPTA_W_ABL_2);
    }

    @Override
    public void strategie() {
        if (this.getParalizat()) {
            return;
        }

        if ((this.getHpInitial() / Constante.LIMITA_1_HP_R  < this.getHp())
                && (this.getHp() < this.getHpInitial() / Constante.LIMITA_2_HP_R)) {
            Context context = new Context(new Strategia1R());
            context.executaStrategie(this);
        } else if (this.getHp() < this.getHpInitial() / Constante.LIMITA_1_HP_R) {
            Context context = new Context(new Strategia2R());
            context.executaStrategie(this);
        }
    }

    @Override
    public void alegeInger(final Inger inger) throws IOException {
        inger.acceptaInger(this);
    }

    @Override
    public void incepeLupta(final Jucator jucator) throws IOException {
        jucator.lupta(this);
    }

    //Rogue vs Knight
    @Override
    public void lupta(final Knight knight) throws IOException {

        this.atacaR(knight, this.getVsKnight1(), this.getVsKnight2());
        knight.atacaK(this, knight.getVsRogue1(), knight.getVsRogue2());

        this.dupaLupta(knight, Constante.HP_NIVEL_R, Constante.HP_NIVEL_K);
    }

    //Rogue vs Rogue
    @Override
    public void lupta(final Rogue rogue) throws IOException {

        this.atacaR(rogue, this.getVsRogue1(), this.getVsRogue2());
        rogue.atacaR(this, rogue.getVsRogue1(), rogue.getVsRogue2());

        this.dupaLupta(rogue, Constante.HP_NIVEL_R, Constante.HP_NIVEL_R);
    }

    //Rogue vs Pyromancer
    @Override
    public void lupta(final Pyromancer pyromancer) throws IOException {

        this.atacaR(pyromancer, this.getVsPyromancer1(), this.getVsPyromancer2());
        pyromancer.atacaP(this, pyromancer.getVsRogue1());

        this.dupaLupta(pyromancer, Constante.HP_NIVEL_R, Constante.HP_NIVEL_P);
    }

    //Rogue vs Wizard
    @Override
    public void lupta(final Wizard wizard) throws IOException {

        this.atacaR(wizard, this.getVsWizard1(), this.getVsWizard2());
        wizard.atacaW(this, wizard.getVsRogue1(), wizard.getVsRogue2());

        this.dupaLupta(wizard, Constante.HP_NIVEL_R, Constante.HP_NIVEL_W);
    }

    //Backstab dmg
    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.DMG_ABL_1_R + this.getNivel() * Constante.DMG_NIVEL_ABL_1_R;
        return dmg;
    }

    //Paralysis dmg
    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.DMG_ABL_2_R + this.getNivel() * Constante.DMG_NIVEL_ABL_2_R;
        return dmg;
    }

    //Functia in care atacatorul este Rogue
    public void atacaR(final Jucator jucator, final float bonusRasa1, final float bonusRasa2) {
        float dmg1, dmg2, bonusTeren = Constante.BONUS_TEREN_NEUTRU, limita, procent,
        dmgFaraBonusRasa = Constante.ZERO, critica = Constante.CRITICA_NORMALA_R;
        int runde = Constante.OVERTIME_TIMP_R;

        //Bonus teren
        if (this.getTipTeren() == 'W') {
            bonusTeren = Constante.BONUS_TEREN_R;
            if (this.numarLovituri % Constante.CRITICA_PER_RUNDE == 0) {
                critica = Constante.CRITICA_BONUS_R;
            }
            runde = Constante.OVERTIME_TIMP_BONUS_R;
        }
        this.numarLovituri++;

        //Backstab
        dmg1 = Math.round(Math.round(this.abilitate1() * bonusRasa1) * bonusTeren) * critica;
        dmgFaraBonusRasa += Math.round(Math.round(this.abilitate1() * bonusTeren) * critica);

        //Paralysis
        dmg2 = Math.round(this.abilitate2() * bonusRasa2) * bonusTeren;
        dmgFaraBonusRasa += Math.round(this.abilitate2() * bonusTeren);
        jucator.setDmgFaraBonus(dmgFaraBonusRasa);
        jucator.setTimpParalizat(runde + 1);
        jucator.setParalizat(true);
        jucator.setDmgO(Math.round(dmg2));
        jucator.setTimeDmgO(runde);

        //Se adauga dmg pe care trebuie sa il ia jucator
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
