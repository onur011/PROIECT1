package Magician;

import utile.Constante;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Magician implements Observer {

    @Override
    public void update(String s) throws IOException {
        //Se scrie in fisier Stringul s.
        BufferedWriter fisier = new BufferedWriter(new FileWriter(Constante.out, true));
        fisier.write(s + "\n");
        fisier.close();
    }
}
