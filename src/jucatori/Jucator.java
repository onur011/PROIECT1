package jucatori;

public abstract class Jucator {
    private int hp;
    private int xp;
    private int x;
    private int y;
    private int nivel;

    /**
     * @param x pozitia pe Ox.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @return returneaza pozitia pe Ox.
     */
    public int getX() {
        return this.x;
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
