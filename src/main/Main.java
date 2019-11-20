package main;


import jucatori.Jucator;
import jucatori.CreareJucator;

import java.util.LinkedList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        LinkedList<Jucator> jucatori = new LinkedList<>();
        CreareJucator creareJucator = CreareJucator.getInstance();

        jucatori.add(creareJucator.creazaJucator("K"));
        jucatori.add(creareJucator.creazaJucator("W"));
        jucatori.get(0).incepeLupta(jucatori.get(1));
    }
}
