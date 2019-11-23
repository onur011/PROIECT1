package jucatori;

import utile.Constante;

public abstract class Jucator {
    private int hp;
    private int xp;
    private int x;
    private int y;
    private int nivel;
    private boolean seLupta;
    private boolean mort;
    private int damage;
    private char tipTeren;
    private int dmgO;
    private int timeDmgO;
    private int hpInitial;
    private char tipCaracter;

    /**
     * @return returneaza tipul de jucator;
     */
    public char getTipCaracter() {
        return this.tipCaracter;
    }
    /**
     * @param type Se seteaza tipul jucatorului.
     */
    public void setTipCaracter(final char type) {
        this.tipCaracter = type;
    }
    /**
     * @return returneaza daca jucatorul este mort sau nu;
     */
    public boolean getMort() {
        return this.mort;
    }
    /**
     * @param hpInitial seteaza hp initial al jucatorului pe fiecare nivel
     */
    public void setHpInitial(final int hpInitial) {
        this.hpInitial = hpInitial;
    }

    /**
     * @param hpNivelNou Calculeaza nivelul jucatorului
     * Daca trece la un nivel nou, ii modificam hp si il aducem la 100%
     */
    public void nouNivel(final int hpNivelNou) {
        int nivelInitial = this.nivel;
        if (this.mort) {
            return;
        }
        if (this.xp >= Constante.NIVELXP) {
            this.nivel = (this.xp - Constante.NIVELXP) / Constante.D50;
        }

        if (nivelInitial != this.nivel) {
            this.hp = this.hpInitial + hpNivelNou;
            this.hpInitial = this.hp;
        }
    }
    /**
     * @param jucator a
     * Functia de calculare a dmg luat de 2 jucatori care se lupta
     * Se adauga si ex corespunzator daca unul dintre ei moare.
     */
    public void iaDamage(final Jucator jucator) {
        int xpj1 = this.xp, xpj2 = jucator.xp;
        this.hp -= this.damage;
        jucator.hp -= jucator.damage;

        if (this.hp <= 0) {
            this.mort = true;
        }

        if (jucator.hp <= 0) {
            jucator.mort = true;
        }

        if (jucator.mort) {
            xpj1 += Math.max(0, Constante.MAXXP - (this.nivel - jucator.nivel)
                                      * Constante.NIVEL);
        }

        if (this.mort) {
            xpj2 += Math.max(0, Constante.MAXXP - (jucator.nivel - this.nivel)
                                         * Constante.NIVEL);
        }
        this.setXp(xpj1);
        jucator.setXp(xpj2);
    }
    /**
     * @return Cate runde dureaza dmgO.
     */
    public int getTime() {
        return this.timeDmgO;
    }
    /**
     * @param dmg Se seteaza damege luat de jucator.
     */
    public void setDamage(final int dmg) {
        this.damage = dmg;
    }
    /**
     * @param time Seteaza timpul de demage overtime.
     */
    public void setTimeDmgO(final int time) {
        this.timeDmgO = time;
    }
    /**
     * @param dmg Seteaza demage de overtime.
     */
    public void setDmgO(final int dmg) {
        this.dmgO = dmg;
    }
    /**
     * @param tip tipul de teren pe care se afla.
     */
    public void setTipTeren(final char tip) {
        this.tipTeren = tip;
    }

    /**
     * @return returneaza tipul de teren.
     */
    public char getTipTeren() {
        return this.tipTeren;
    }
    /**
     * @return returneaza nivelul
     */
    public int getNivel() {
        return this.nivel;
    }

    /**
     * @param bool setam daca un jucator s-a luptat sau nu.
     */
    public void setSeLupta(final boolean bool) {
        this.seLupta = bool;
    }

    /**
     * Se da damage overtime si/sau se scade durata acestuia.
     */
    public void overtime() {
        if (this.timeDmgO != 0 && this.dmgO != 0) {
            this.hp -= this.dmgO;
        }
        if (this.hp <= 0) {
            this.mort = true;
        }
        if (this.timeDmgO != 0) {
            this.timeDmgO--;
        }
    }
    /**
     * @param jucator Se decide daca cei doi jucatori se vor lupta.
     * Se scade dmg overtime de la fiecare jucator, daca are.
     */
    public void cineLupta(final Jucator jucator) {
        this.overtime();
        jucator.overtime();

        if (this.x == jucator.x && this.y == jucator.y && !this.seLupta && !jucator.seLupta
            && !this.mort && !jucator.mort) {
            this.incepeLupta(jucator);
            this.seLupta = true;
            jucator.seLupta = true;

        }
    }

    /**
     * @return returneaza hp.
     */
    public int getHp() {
        return this.hp;
    }
    /**
     * @param bool Starea caracterului.
     */
    public void setMort(final boolean bool) {
        this.mort = bool;
    }

    /**
     * @param x pozitia pe Ox.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @return returneaza pozitia rand.
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return returneaza pozitie coloana.
     */
    public int getY() {
        return this.y;
    }

    /**
     * @param y pozitia pe Oy.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * @param hp seteaza hp jucatorului.
     */
    public void setHp(final int hp) {
        this.hp = hp;
    }

    /**
     * @return returneaza xp.
     */
    public int getXp() {
        return this.xp;
    }
    /**
     * @param xp seteaza xp jucatorului.
     */
    public void setXp(final int xp) {
        this.xp = xp;
    }

    /**
     * @param nivel seteaza nivelul jucatorului.
     */
    public void setNivel(final int nivel) {
        this.nivel = nivel;
    }

    /**
     * @param chr functia de mutare a jucatorilor.
     */
    public void muta(final char chr) {
        if (chr == 'U') {
            this.x -= 1;
        } else if (chr == 'D') {
            this.x += 1;
        } else if (chr == 'L') {
            this.y -= 1;
        } else if (chr == 'R') {
            this.y += 1;
        }
    }

    public abstract void incepeLupta(Jucator jucator);
    public abstract void lupta(Knight knight);
    public abstract void lupta(Rogue rogue);
    public abstract void lupta(Pyromancer pyromancer);
    public abstract void lupta(Wizard wizard);
}
