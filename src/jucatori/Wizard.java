package jucatori;

import utile.Constante;

import java.io.IOException;

public final class Wizard extends Jucator {

    //Constructor Wizard
    public Wizard(final int x, final int y, final char tip, final char type, final int id) {
        this.setId(id);
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HP_INITIAL_W);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HP_INITIAL_W);
        this.setTipCaracter(type);
        this.setParalizat(false);
        this.setTimpParalizat(0);
    }
    @Override
    public void incepeLupta(final Jucator jucator) throws IOException {
        jucator.lupta(this);
    }

    //Wizard vs Knight
    @Override
    public void lupta(final Knight knight) throws IOException {
        knight.atacaK(this, Constante.K_LUPTA_W_ABL_1, Constante.K_LUPTA_W_ABL_2);
        this.atacaW(knight, Constante.W_LUPTA_K_ABL_1, Constante.W_LUPTA_K_ABL_2);

        this.dupaLupta(knight, Constante.HP_NIVEL_W, Constante.HP_NIVEL_K);
    }

    //Wizard vs Rogue
    @Override
    public void lupta(final Rogue rogue) throws IOException {
        rogue.atacaR(this, Constante.R_LUPTA_W_ABL_1, Constante.R_LUPTA_W_ABL_2);
        this.atacaW(rogue, Constante.W_LUPTA_R_ABL_1, Constante.W_LUPTA_R_ABL_2);

        this.dupaLupta(rogue, Constante.HP_NIVEL_W, Constante.HP_NIVEL_R);
    }

    //Wizard vs Pyromancer
    @Override
    public void lupta(final Pyromancer pyromancer) throws IOException {
        pyromancer.atacaP(this, Constante.P_LUPTA_W);
        this.atacaW(pyromancer, Constante.W_LUPTA_P_ABL_1, Constante.W_LUPTA_P_ABL_2);

        this.dupaLupta(pyromancer, Constante.HP_NIVEL_W, Constante.HP_NIVEL_P);
    }

    //Wizard vs Wizard
    @Override
    public void lupta(final Wizard wizard) throws IOException {
        wizard.atacaW(this, Constante.W_LUPTA_W_ABL_1, Constante.W_LUPTA_W_ABL_2);
        this.atacaW(wizard, Constante.W_LUPTA_W_ABL_1, Constante.W_LUPTA_W_ABL_2);

        this.dupaLupta(wizard, Constante.HP_NIVEL_W, Constante.HP_NIVEL_W);
    }

    //Functia in care atacatorul este Wizard
    public void atacaW(final Jucator jucator, final float bonusRasa1, final float bonusRasa2) {
        float dmg1, dmg2 = Constante.ZERO, procent, procent2,
        bonusTeren = Constante.BONUS_TEREN_NEUTRU;

        //Bonus teren
        if (this.getTipTeren() == 'D') {
            bonusTeren = Constante.BONUS_TEREN_W;
        }

        //Drain
        procent = Constante.PROCENT_W + this.getNivel() * Constante.PROCENT_NIVEL_W;
        dmg1 = procent * Math.min(Constante.PROCENT_ABL_1_W * jucator.getHpInitial(),
        jucator.getHp()) * bonusTeren * bonusRasa1;

        //Deflect (nu se foloseste cand victima este un Wizard)
        if (jucator.getTipCaracter() != 'W') {
            procent2 = Constante.PROCENT_ABL_2_W + this.getNivel()
            * Constante.PROCENT_ALB_2_NIVEL_W;
            if (procent2 > Constante.PROCENT_MAX_ABL_2_W) {
                procent2 = Constante.PROCENT_MAX_ABL_2_W;
            }
            dmg2 = procent2 * this.getDmgFaraBonus() * bonusTeren * bonusRasa2;
        }

        //Se adauga dmg pe care trebuie sa il ia jucator
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
