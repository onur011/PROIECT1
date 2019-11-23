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

    public Jucator creazaJucator(final String type, final int x, final int y, final char tip) {
        switch (type) {
            case "K": return new Knight(x, y, tip, type.charAt(0));
            case "R": return new Rogue(x, y, tip, type.charAt(0));
            case "P": return new Pyromancer(x, y, tip, type.charAt(0));
            case "W": return new Wizard(x, y, tip, type.charAt(0));
            default : return null;
        }
    }
}
