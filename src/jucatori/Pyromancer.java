package jucatori;

import ingeri.Inger;
import strategii.Context;
import strategii.Strategia1P;
import strategii.Strategia2P;
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
        this.setVsKnight1(Constante.P_LUPTA_K);
        this.setVsPyromancer1(Constante.P_LUPTA_P);
        this.setVsRogue1(Constante.P_LUPTA_R);
        this.setVsWizard1(Constante.P_LUPTA_W);
    }

    @Override
    public void strategie() {
        if (this.getParalizat()) {
            return;
        }

        if ((this.getHpInitial() / Constante.LIMITA_1_HP_P  < this.getHp())
                && (this.getHp() < this.getHpInitial() / Constante.LIMITA_2_HP_P)) {
            Context context = new Context(new Strategia1P());
            context.executaStrategie(this);
        } else if (this.getHp() < this.getHpInitial() / Constante.LIMITA_1_HP_P) {
            Context context = new Context(new Strategia2P());
            context.executaStrategie(this);
        }
    }

    public void alegeInger(final Inger inger) throws IOException {
        inger.acceptaInger(this);
    }

    @Override
    public void incepeLupta(final Jucator jucator) throws IOException {
        jucator.lupta(this);
    }

    //Pyromancer vs Knight
    @Override
    public void lupta(final Knight knight) throws IOException {
        this.strategie();
        knight.strategie();
        this.atacaP(knight, this.getVsKnight1());
        knight.atacaK(this, knight.getVsPyromancer1(), knight.getVsPyromancer2());

        this.dupaLupta(knight, Constante.HP_NIVEL_P, Constante.HP_NIVEL_K);
    }

    //Pyromancer vs Rogue
    @Override
    public void lupta(final Rogue rogue) throws IOException {
        this.strategie();
        rogue.strategie();
        this.atacaP(rogue, this.getVsRogue1());
        rogue.atacaR(this, rogue.getVsPyromancer1(), rogue.getVsPyromancer2());

        this.dupaLupta(rogue, Constante.HP_NIVEL_P, Constante.HP_NIVEL_R);
    }

    //Pyromancer vs Pyromancer
    @Override
    public void lupta(final Pyromancer pyromancer) throws IOException {
        this.strategie();
        pyromancer.strategie();
        this.atacaP(pyromancer, this.getVsPyromancer1());
        pyromancer.atacaP(this, pyromancer.getVsPyromancer1());

        this.dupaLupta(pyromancer, Constante.HP_NIVEL_P, Constante.HP_NIVEL_P);
    }

    //Pyromancer vs Wizard
    @Override
    public void lupta(final Wizard wizard) throws IOException {
        this.strategie();
        wizard.strategie();
        this.atacaP(wizard, this.getVsWizard1());
        wizard.atacaW(this, wizard.getVsPyromancer1(), wizard.getVsPyromancer2());

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
