package main;


import jucatori.Jucator;

import java.io.IOException;
import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        InputReader input = new InputReader();
        ArrayList<String> harta, runde;
        ArrayList<Jucator> jucatori;
        int n, m, r, p;

        //Se extrag informatiile utile pentru desfasurarea jocului.
        input.citire(args[0], args[1]);
        n = input.getN();
        m = input.getM();
        r = input.getR();
        p = input.getP();
        jucatori = input.getJucatori();
        harta = input.getHarta();
        runde = input.getRunde();
    }
}
