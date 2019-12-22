package jucatori;

import ingeri.Inger;
import strategii.Context;
import strategii.Strategia1K;
import strategii.Strategia2K;
import utile.Constante;

import java.io.IOException;

public final class Knight extends Jucator implements Abilitati {

    //Constructor Knight
    public Knight(final int x, final int y, final char tip, final char type, final int id) {
        this.setId(id);
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HP_INITIAL_K);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HP_INITIAL_K);
        this.setTipCaracter(type);
        this.setParalizat(false);
        this.setTimpParalizat(0);
        this.setVsKnight1(Constante.K_LUPTA_K_ABL_1);
        this.setVsPyromancer1(Constante.K_LUPTA_P_ABL_1);
        this.setVsRogue1(Constante.K_LUPTA_R_ABL_1);
        this.setVsWizard1(Constante.K_LUPTA_W_ABL_1);
        this.setVsKnight2(Constante.K_LUPTA_K_ABL_2);
        this.setVsPyromancer2(Constante.K_LUPTA_P_ABL_2);
        this.setVsRogue2(Constante.K_LUPTA_R_ABL_2);
        this.setVsWizard2(Constante.K_LUPTA_W_ABL_2);
    }

    //Se aplica strategia pentru Knight.
    @Override
    public void strategie() {

        if ((this.getHpInitial() / Constante.LIMITA_1_HP_K  < this.getHp())
        && (this.getHp() < this.getHpInitial() / Constante.LIMITA_2_HP_K)) {
            Context context = new Context(new Strategia1K());
            context.executaStrategie(this);
        } else if (this.getHp() < this.getHpInitial() / Constante.LIMITA_1_HP_K) {
            Context context = new Context(new Strategia2K());
            context.executaStrategie(this);
        }
        //Acesta nu se modifica pentru ca initial este 0;
        this.setVsKnight1(1f);
    }

    public void alegeInger(final Inger inger) throws IOException {
        inger.acceptaInger(this);
    }

    @Override
    public void incepeLupta(final Jucator jucator) throws IOException {
        jucator.lupta(this);
    }

    //Knight vs Knight
    @Override
    public void lupta(final Knight knight) throws IOException {
        this.strategie();
        knight.strategie();
        this.atacaK(knight, this.getVsKnight1(), this.getVsKnight2());
        knight.atacaK(this, knight.getVsKnight1(), knight.getVsKnight2());

        this.dupaLupta(knight, Constante.HP_NIVEL_K, Constante.HP_NIVEL_K);
    }

    //Knight vs Rouge
    @Override
    public void lupta(final Rogue rogue) throws IOException {
        this.strategie();
        rogue.strategie();
        this.atacaK(rogue, this.getVsRogue1(), this.getVsRogue2());
        rogue.atacaR(this, rogue.getVsKnight1(), rogue.getVsKnight2());

        this.dupaLupta(rogue, Constante.HP_NIVEL_K, Constante.HP_NIVEL_R);
    }

    //Knight vs Pyromancer
    @Override
    public void lupta(final Pyromancer pyromancer) throws IOException {
        this.strategie();
        pyromancer.strategie();
        this.atacaK(pyromancer, this.getVsPyromancer1(), this.getVsPyromancer2());
        pyromancer.atacaP(this, pyromancer.getVsKnight1());

        this.dupaLupta(pyromancer, Constante.HP_NIVEL_K, Constante.HP_NIVEL_P);
    }

    //Knight vs Wizard
    @Override
    public void lupta(final Wizard wizard) throws IOException {
        this.strategie();
        wizard.strategie();
        this.atacaK(wizard, this.getVsWizard1(), this.getVsWizard2());
        wizard.atacaW(this, wizard.getVsKnight1(), wizard.getVsKnight2());

        this.dupaLupta(wizard, Constante.HP_NIVEL_K, Constante.HP_NIVEL_W);

    }
    //Execute dmg
    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.DMG_ABL_1_K + this.getNivel() * Constante.DMG_NIVEL_ABL_1_K;
        return dmg;
    }

    //Slam dmg
    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.DMG_ABL_2_K + this.getNivel() * Constante.DMG_NIVEL_ABL_2_K;
        return dmg;
    }

    //Functia in care atacatorul este Knight
    public void atacaK(final Jucator jucator, final float bonusRasa1, final float bonusRasa2) {
        float dmg1, dmg2, bonusTeren = Constante.BONUS_TEREN_NEUTRU, limita, procent,
        dmgFaraBonusRasa = Constante.ZERO;

        //Bonusul de teren
        if (this.getTipTeren() == 'L') {
           bonusTeren = Constante.BONUS_TEREN_K;
        }
        //Se calculeaza procent
        procent = Constante.PROCENT_K + this.getNivel() * Constante.PROCENT_NIVEL_K;
        if (procent > Constante.PROCENT_MAX_K) {
            procent = Constante.PROCENT_MAX_K;
        }

        limita = procent * jucator.getHpInitial();
        //Execute
        if (jucator.getHp() < limita) {
            dmg1 = jucator.getHp();
            dmgFaraBonusRasa += dmg1;
        } else {
            dmg1 = Math.round(this.abilitate1() * bonusTeren) * bonusRasa1;
            dmgFaraBonusRasa += Math.round(this.abilitate1() * bonusTeren);
        }
        //Slam
        dmg2 = Math.round(this.abilitate2() * bonusTeren) * bonusRasa2;
        dmgFaraBonusRasa += Math.round(this.abilitate2() * bonusTeren);
        jucator.setDmgFaraBonus(dmgFaraBonusRasa);
        jucator.setDmgO((int) Constante.ZERO);
        jucator.setTimeDmgO((int) Constante.ZERO);
        jucator.setParalizat(true);
        jucator.setTimpParalizat(Constante.PARALIZAT_TIMP_K);

         //Se adauga dmg pe care trebuie sa il ia jucator
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
