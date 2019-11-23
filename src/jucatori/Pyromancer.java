package jucatori;

import utile.Constante;

public final class Pyromancer extends Jucator implements Abilitati {

    public Pyromancer(final int x, final int y, final char tip, final char type) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constante.HPPYROMANCER);
        this.setXp(0);
        this.setNivel(0);
        this.setMort(false);
        this.setTipTeren(tip);
        this.setHpInitial(Constante.HPPYROMANCER);
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
        knight.atacaK(this, Constante.PLUS10, Constante.MINUS10);
        this.atacaP(knight, Constante.PLUS20);

        this.dupaLupta(knight, Constante.D50, Constante.D80);
    }

    @Override
    public void lupta(final Rogue rogue) {

    }

    @Override
    public void lupta(final Pyromancer pyromancer) {
        /*float dmg1j1, dmg2j1, dmg2j1periodic, bonusTeren = 1.0f, dmg1j2, dmg2j2, dmg2j2periodic;
        if (this.getTipTeren() == 'V') {
            bonusTeren = Constante.PLUS25;
        }
        //Se calculeaza dmg dat de primul jucator celui de al doilea.
        //Demage total este pus in variabila damage a celui care primeste dmg.
        dmg1j1 = this.abilitate1() * bonusTeren * Constante.MINUS10;

        dmg2j1 = this.abilitate2() * bonusTeren * Constante.MINUS10;
        dmg2j1periodic = (Constante.D50 + Constante.D30 * this.getNivel()) * bonusTeren
                          * Constante.MINUS10;
        pyromancer.setDmgO(Math.round(dmg2j1periodic));
        pyromancer.setTimeDmgO(Constante.TIME2);
        pyromancer.setDamage(Math.round(dmg1j1) + Math.round(dmg2j1));

        //Se calculeaza dmg dat de al doilea jucator primului.
        //Demage total este pus in variabila damage a celui care primeste dmg.
        dmg1j2 = pyromancer.abilitate1() * bonusTeren * Constante.MINUS10;

        dmg2j2 = pyromancer.abilitate2() * bonusTeren * Constante.MINUS10;
        dmg2j2periodic = (Constante.D50 + Constante.D30 * pyromancer.getNivel()) * bonusTeren
                * Constante.MINUS10;
        this.setDmgO(Math.round(dmg2j2periodic));
        this.setTimeDmgO(Constante.TIME2);
        this.setDamage(Math.round(dmg1j2) + Math.round(dmg2j2));*/
        this.atacaP(pyromancer, Constante.MINUS10);
        pyromancer.atacaP(this, Constante.MINUS10);

        this.dupaLupta(pyromancer, Constante.D50, Constante.D50);
       /* //Se calculeza hp fiecaruia dupa dmg.
        this.iaDamage(pyromancer);
        //Se verifica daca fac un nou nivel;
        this.nouNivel(Constante.D50);
        pyromancer.nouNivel(Constante.D50);*/
    }

    @Override
    public void lupta(final Wizard wizard) {
        this.atacaP(wizard, Constante.PLUS05);
        wizard.atacaW(this, Constante.MINUS10, Constante.PLUS30);

        this.dupaLupta(wizard, Constante.D50, Constante.D30);
    }

    //Fireblast
    @Override
    public int abilitate1() {
        int dmg;
        dmg = Constante.D350 + Constante.D50 * this.getNivel();
        return dmg;
    }

    //Ignite
    @Override
    public int abilitate2() {
        int dmg;
        dmg = Constante.D150 + Constante.D20 * this.getNivel();
        return dmg;
    }

    /**Functia de atac al Pyromancer.
     * @param jucator pe cine ataca.
     * @param bonusRasa bonusul de rasa.
     */
    public void atacaP(final Jucator jucator, final float bonusRasa) {
        float dmg1, dmg2, dmg2periodic, bonusTeren = 1.0f, dmgFaraBonusRasa = 0;

        if (this.getTipTeren() == 'V') {
            bonusTeren = Constante.PLUS25;
        }
        //Se calculeaza dmg dat de primul jucator celui de al doilea.
        //Demage total este pus in variabila damage a celui care primeste dmg.
        dmg1 = this.abilitate1() * bonusTeren * bonusRasa;
        dmgFaraBonusRasa += Math.round(this.abilitate1() * bonusTeren);

        dmg2 = this.abilitate2() * bonusTeren * bonusRasa;
        dmgFaraBonusRasa += Math.round(this.abilitate2() * bonusTeren);
        dmg2periodic = (Constante.D50 + Constante.D30 * this.getNivel()) * bonusTeren
                * bonusRasa;
        jucator.setDmgFaraBonus(dmgFaraBonusRasa);
        jucator.setTimpParalizat(0);
        jucator.setParalizat(false);
        jucator.setDmgO(Math.round(dmg2periodic));
        jucator.setTimeDmgO(Constante.TIME2);
        jucator.setDamage(Math.round(dmg1) + Math.round(dmg2));
    }
}
