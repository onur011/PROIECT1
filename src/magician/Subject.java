package magician;

import java.io.IOException;

public interface Subject {
    void adaugaObserver(Observer o);
    void stergeObserver(Observer o);
    void notificaObserveri(String str) throws IOException;
}
