package Magician;

import java.io.IOException;

public interface Subject {
    public void adaugaObserver (Observer o);
    public void stergeObserver (Observer o);
    public void notificaObserveri(String str) throws IOException;
}
