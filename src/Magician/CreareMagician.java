package Magician;

public class CreareMagician {
    private static CreareMagician instance = null;

    private CreareMagician() { }

    public static CreareMagician getInstance() {
        if (instance == null) {
            instance = new CreareMagician();
        }
        return instance;
    }
    //Se creaza magicianul
    public Magician creazaMagician() {
        return new Magician();
    }
}
