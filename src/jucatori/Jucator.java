package jucatori;

import ingeri.Inger;
import magician.Observer;
import magician.Subject;
import utile.Constante;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Jucator implements Subject {
    private ArrayList<Observer> list = new ArrayList<Observer>();
    private int id;
    private int hp;
    private int xp;
    private int x;
    private int y;
    private int nivel;
    private boolean mort;
    private int damage;
    private char tipTeren;
    private int dmgO;
    private int timeDmgO;
    private int hpInitial;
    private char tipCaracter;
    private boolean paralizat;
    private int timpParalizat;
    private float dmgFaraBonus;
    private float vsKnight1;
    private float vsPyromancer1;
    private float vsRogue1;
    private float vsWizard1;
    private float vsKnight2;
    private float vsPyromancer2;
    private float vsRogue2;
    private float vsWizard2;
    private int xpInitial;

    /**
     * @param xpInitial se seteaza xp de la inceputul rundei.
     */
    public void setXpInitial( final int xpInitial) {
        this.xpInitial = xpInitial;
    }

    /**
     * @return returneaza xp de la inceputul rundei.
     */
    public int getXpInitial() {
        return this.xpInitial;
    }

    /**
     * @param ind Se seteaza modificator de versus knight.
     */
    public void setVsKnight2(final float ind) {
        this.vsKnight2 = ind;
    }

    /**
     * @param ind Se seteaza modificator de versus pyromancer.
     */
    public void setVsPyromancer2(final float ind) {
        this.vsPyromancer2 = ind;
    }

    /**
     * @param ind Se seteaza modificator de versus rogue.
     */
    public void setVsRogue2(final float ind) {
        this.vsRogue2 = ind;
    }

    /**
     * @param ind Se seteaza modificator de versus wizard.
     */
    public void setVsWizard2(final float ind) {
        this.vsWizard2 = ind;
    }

    /**
     * @return Se returneaza modificator de rasa versus knight.
     */
    public float getVsKnight2() {
        return this.vsKnight2;
    }

    /**
     * @return Se returneaza modificator de rasa versus pyromancer.
     */
    public float getVsPyromancer2() {
        return this.vsPyromancer2;
    }

    /**
     * @return Se returneaza modificator de rasa versus rogue.
     */
    public float getVsRogue2() {
        return this.vsRogue2;
    }

    /**
     * @return Se returneaza modificator de rasa versus wizard.
     */
    public float getVsWizard2() {
        return this.vsWizard2;
    }

    /**
     * @param ind Se seteaza modificator de versus knight.
     */
    public void setVsKnight1(final float ind) {
        this.vsKnight1 = ind;
    }

    /**
     * @param ind Se seteaza modificator de versus pyromancer.
     */
    public void setVsPyromancer1(final float ind) {
        this.vsPyromancer1 = ind;
    }

    /**
     * @param ind Se seteaza modificator de versus rogue.
     */
    public void setVsRogue1(final float ind) {
        this.vsRogue1 = ind;
    }

    /**
     * @param ind Se seteaza modificator de versus wizard.
     */
    public void setVsWizard1(final float ind) {
        this.vsWizard1 = ind;
    }

    /**
     * @return Se returneaza modificator de rasa versus knight.
     */
    public float getVsKnight1() {
        return this.vsKnight1;
    }

    /**
     * @return Se returneaza modificator de rasa versus pyromancer.
     */
    public float getVsPyromancer1() {
        return this.vsPyromancer1;
    }

    /**
     * @return Se returneaza modificator de rasa versus rogue.
     */
    public float getVsRogue1() {
        return this.vsRogue1;
    }

    /**
     * @return Se returneaza modificator de rasa versus wizard.
     */
    public float getVsWizard1() {
        return this.vsWizard1;
    }

    /**
     * @param id Se seteaza id initial.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return Se returneaza id initial.
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param o Se adauga observator.
     */
    @Override
    public void adaugaObserver(final Observer o) {
        this.list.add(o);
    }

    /**
     * @param o Se sterge observator.
     */
    @Override
    public void stergeObserver(final Observer o) {
        list.remove(o);
    }

    /**
     * @param str Se notifica observatorii.
     */
    @Override
    public void notificaObserveri(final String str) throws IOException {
        for (Observer o : list) {
            o.update(str);
        }
    }

    /**
     * @param dmgFaraBonusRasa dmg primit fara bonus de rasa.
     */
    public void setDmgFaraBonus(final float dmgFaraBonusRasa) {
        this.dmgFaraBonus = dmgFaraBonusRasa;
    }

    /**
     * @return returneaza dmg luat fara bonus rasa.
     */
    public float getDmgFaraBonus() {
        return this.dmgFaraBonus;
    }
    /**
     * Returneaza hp initial al nivelului respectiv.
     */
    protected int getHpInitial() {
        return this.hpInitial;
    }
    /**
     * @param timp cate runde este paralizat.
     */
    public void setTimpParalizat(final int timp) {
        this.timpParalizat = timp;
    }
    /**
     * @param paralizat Seteaza daca jucatorul este imobilizat sau nu.
     */
    public void setParalizat(final boolean paralizat) {
        this.paralizat = paralizat;
    }
    /**
     * Functia de calcularea hp si nivel dupa batalie.
     * @param jucator jucatorul cu care se lupta.
     * @param hpNivel1 hp per nivel pentru jucatorul 1.
     * @param hpNivel2 hp per nivel pentru jucatorul 2.
     */
    public void dupaLupta(final Jucator jucator, final int hpNivel1, final int hpNivel2)
        throws IOException {

        //Se calculeza hp fiecaruia dupa dmg.
        this.iaDamage(jucator);
        //Se verifica daca fac un nou nivel;
        this.nouNivel(hpNivel1);
        jucator.nouNivel(hpNivel2);
    }

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
    public void nouNivel(final int hpNivelNou) throws IOException {
        int nivelInitial = this.nivel;
        //Daca jucatorul moare, nu ii mai crestem nivelul
        if (this.mort) {
            return;
        }
        //Se calculeaza nivelul actual al jucatorului
        if (this.xp >= Constante.XP_NIVEL_0) {
            this.nivel = (this.xp - Constante.XP_NIVEL_0) / Constante.XP_PER_NIVEL;
        }
        //Se calculeaza hp jucatorului, in cazul in care acesta a avansat in nivel.
        if (nivelInitial != this.nivel) {
            this.hp = this.hpInitial + hpNivelNou * (this.nivel - nivelInitial);
            this.hpInitial = this.hp;
        }

        for (int i = nivelInitial + 1; i <= this.nivel; i++) {
            String str = this.numeCaracter() + " " + this.id + " reached level "
            + Integer.toString(i);
            this.notificaObserveri(str);
        }
    }
    /**
     * @param jucator jucatorul care ia dmg.
     * Functia de calculare a dmg luat de 2 jucatori care se lupta
     * Se adauga si ex corespunzator daca unul dintre ei moare.
     */
    public void iaDamage(final Jucator jucator) throws IOException {
        int xpj1 = this.xp, xpj2 = jucator.xp;
        //Se scade dmg primit de fiecare jucator
        this.hp -= this.damage;
        jucator.hp -= jucator.damage;
        //Se verifica daca sunt morti.
        if (this.hp <= 0) {
            this.mort = true;
            String str = "Player " + this.numeCaracter() + " " + this.getId() + " was killed by "
                    + jucator.numeCaracter() + " " + jucator.getId();
            this.notificaObserveri(str);
        }

        if (jucator.hp <= 0) {
            jucator.mort = true;
            String str = "Player " + jucator.numeCaracter() + " " + jucator.getId()
                    + " was killed by " + this.numeCaracter() + " " + this.getId();
            jucator.notificaObserveri(str);
        }
        //Daca unul este mort,se calculeaza xp pentru celalalt.
        if (jucator.mort) {
            xpj1 += Math.max(0, Constante.XP - (this.nivel - jucator.nivel)
                    * Constante.XP_NIVEL);
        }

        if (this.mort) {
            xpj2 += Math.max(0, Constante.XP - (jucator.nivel - this.nivel)
                    * Constante.XP_NIVEL);
        }
        //Se adauga xp si dmg primit este trecut pe 0;
        this.xp = xpj1;
        jucator.xp = xpj2;

        this.damage = (int) Constante.ZERO;
        jucator.damage = (int) Constante.ZERO;
    }
    /**
     * @return Cate runde dureaza dmgO.
     */
    public int getTime() {
        return this.timeDmgO;
    }

    /**
     * @return Se returneaza numele jucatorului.
     */
    public String numeCaracter() {
        switch (this.getTipCaracter()) {
            case 'K' : return "Knight";

            case 'R' : return "Rogue";

            case 'W' : return "Wizard";

            case 'P' : return "Pyromancer";
            default : return null;
        }
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
     * Se da damage overtime si se scade durata acestuia.
     */
    public void overtime() {
        if (this.timeDmgO != 0) {
            this.hp -= this.dmgO;
            this.timeDmgO--;
        }
        if (this.hp <= 0) {
            this.mort = true;
        }
    }
    /**
     * @param jucator Se decide daca cei doi jucatori se vor lupta.
     */
    public void cineLupta(final Jucator jucator) throws IOException {
        //Se lupta doar daca se afla pe aceeasi pozitie si nu sunt morti.
        if (this.x == jucator.x && this.y == jucator.y && !this.mort && !jucator.mort) {
            this.incepeLupta(jucator);
        }
    }

    /**
     * Verifica daca jucatorul mai este imobilizat.
     */
    public void paralizatRunda() {
        if (this.timpParalizat != Constante.ZERO) {
            this.timpParalizat--;
            if (this.timpParalizat == Constante.ZERO) {
                this.paralizat = false;
            }
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
        if (this.paralizat) {
            return;
        }

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

    /**
     * Se verifica daca hp depaseste hp maxim.
     */
    public void verificareHp() {
        if (this.hp > this.hpInitial) {
            this.hp = this.hpInitial;
        }
    }

    /**
     * @param ind Se modifica coeficientii abilitatii 1 cu suma cu ind.
     */
    public void modificaCoeficienti1(final float ind) {
        this.vsKnight1 += ind;
        this.vsPyromancer1 += ind;
        this.vsRogue1 += ind;
        this.vsWizard1 += ind;
    }

    /**
     * @param ind Se modifica coeficientii abilitatii 2 cu suma cu ind.
     */
    public void modificaCoeficienti2(final float ind) {
        this.vsKnight2 += ind;
        this.vsPyromancer2 += ind;
        this.vsRogue2 += ind;
        this.vsWizard2 += ind;
    }

    /**
     * Se verifica daca ingerul este pe pozitia jucatorului.
     */
    public void esteInger(final Inger inger) throws IOException {
        if (this.x == inger.getX() && this.y == inger.getY()) {
            this.alegeInger(inger);
        }
    }

    /**
     * Se verifica daca jucatorul a fost omorat de inger.
     */
    public void omoratInger() throws IOException {
        if (this.hp <= 0) {
            String str = "Player " + this.numeCaracter() + " " + this.getId()
            + " was killed by an angel";
            this.notificaObserveri(str);
            this.mort = true;
        }
    }

    /**
     * Returneaza daca jucatorul este paralizat sau nu.
     */
    public boolean getParalizat() {
        return this.paralizat;
    }

    public  void inceputDeRunda() {
    }

    public abstract void strategie();
    public abstract void alegeInger(Inger inger) throws IOException;
    public abstract void incepeLupta(Jucator jucator) throws IOException;
    public abstract void lupta(Knight knight) throws IOException;
    public abstract void lupta(Rogue rogue) throws IOException;
    public abstract void lupta(Pyromancer pyromancer) throws IOException;
    public abstract void lupta(Wizard wizard) throws IOException;
}
