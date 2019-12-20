package magician;

import utile.Constante;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Magician implements Observer {

    /**
     * @param s Se scrie in fisierul de iesire stringul s.
     */
    @Override
    public void update(final String s) throws IOException {
        //Se scrie in fisier Stringul s.
        Constante cnst = new Constante();
        BufferedWriter fisier = new BufferedWriter(new FileWriter(cnst.getOut(), true));
        fisier.write(s + "\n");
        fisier.close();
    }
}
