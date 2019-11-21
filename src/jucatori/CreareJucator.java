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

    public Jucator creazaJucator(final String type, final int x, final int y) {
        switch (type) {
            case "K": return new Knight(x, y);
            case "R": return new Rogue(x, y);
            case "P": return new Pyromancer(x, y);
            case "W": return new Wizard(x, y);
            default : return null;
        }
    }
}
