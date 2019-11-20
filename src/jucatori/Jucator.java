package jucatori;

public abstract class Jucator {
    private int hp;
    private int xp;

    public abstract void incepeLupta(Jucator jucator);
    public abstract void lupta(Knight knight);
    public abstract void lupta(Rogue rogue);
    public abstract void lupta(Pyromancer pyromancer);
    public abstract void lupta(Wizard wizard);
}
