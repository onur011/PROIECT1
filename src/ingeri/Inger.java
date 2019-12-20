package ingeri;

import magician.Observer;
import magician.Subject;

import java.io.IOException;
import java.util.ArrayList;

public class Inger implements Subject {
    private ArrayList<Observer> list;
    private String tipInger;
    private int x;
    private int y;
    private boolean bun;

    /**
     * @param o Se adauga observator.
     */
    @Override
    public void adaugaObserver(final Observer o) {
        list.add(o);
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
     * @return returneaza tipul de inger(bun/rau).
     */
    public boolean getBun() {
        return this.bun;
    }

    /**
     * @param bun seteaza tipul de inger.
     */
    public void setBun(final boolean bun) {
        this.bun = bun;
    }

    /**
     * @return returneaza ce fel de inger este.
     */
    public String getTipInger() {
        return this.tipInger;
    }

    /**
     * @param tipInger seteaza ce fel de inger este.
     */
    public void setTipInger(final String tipInger) {
        this.tipInger = tipInger;
    }

    /**
     * @param x seteza pozitia x.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @param y seteaza pozitia y.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * @return returneaza pozitia x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return returneaza pozitia y.
     */
    public int getY() {
        return this.y;
    }
}

