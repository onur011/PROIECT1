package jucatori;

public final class CreareJucator {
    private static CreareJucator instance = null;

    private CreareJucator() { }

    public static CreareJucator getInstance() {
        if (instance == null) {
            instance = new CreareJucator();
        }
        return instance;
    }

    public Jucator creazaJucator(final String type) {
        switch (type) {
            case "K": return new Knight();
            case "R": return new Rogue();
            case "P": return new Pyromancer();
            case "W": return new Wizard();
            default : return null;
        }
    }
}
