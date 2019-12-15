package main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Harta {
    private static Harta instance = null;
    private ArrayList<String> harta = new ArrayList<String>();

    //Constructor de citire a hartii din fisierul de intrare
    Harta(String in, String out) throws IOException {
        FileSystem fisier = new FileSystem(in, out);
        int n,m;

        n = fisier.nextInt();
        m = fisier.nextInt();

        for (int i = 0; i < n; i++) {
            harta.add(fisier.nextWord());
        }

        fisier.close();
    }

    public static Harta getInstance(String in, String out) throws IOException {
        if (instance == null ){
            instance = new Harta(in, out);
        }

    return instance;
    }

    public ArrayList<String> getHarta() {
        return this.harta;
    }
}
