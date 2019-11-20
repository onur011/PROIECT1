package jucatori;

public final class Wizard extends Jucator {
    @Override
    public void incepeLupta(final Jucator jucator) {
        jucator.lupta(this);
    }

    @Override
    public void lupta(final Knight knight) {
        System.out.println("w vs k");
    }

    @Override
    public void lupta(final Rogue rogue) {

    }

    @Override
    public void lupta(final Pyromancer pyromancer) {

    }

    @Override
    public void lupta(final Wizard wizard) {

    }
}
