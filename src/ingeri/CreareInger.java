package ingeri;

public final class CreareInger {
    private static CreareInger instance = null;

    private CreareInger() { }

    public static CreareInger getInstance() {
        if (instance == null) {
            instance = new CreareInger();
        }
        return instance;
    }
    //Se creaza ingerul in functie de tipul sau.
    public Inger creazaInger(final String tip, final int x, final int y) {
        switch (tip) {
            case "DamageAngel": return new DamageAngel(tip, x, y);
            case "DarkAngel": return new DarkAngel(tip, x, y);
            case "Dracula": return new Dracula(tip, x, y);
            case "GoodBoy": return new GoodBoy(tip, x, y);
            case "LevelUpAngel": return new LevelUpAngel(tip, x, y);
            case "LifeGiver": return new LifeGiver(tip, x, y);
            case "SmallAngel": return new SmallAngel(tip, x, y);
            case "Spawner": return new Spawner(tip, x, y);
            case "TheDoomer": return new TheDoomer(tip, x, y);
            case "XPAngel": return new XPAngel(tip, x, y);
            default : return null;
        }
    }
}
