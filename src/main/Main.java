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
        int n, m, r, p, i, j, k;

        //Se extrag informatiile utile pentru desfasurarea jocului.
        input.citire(args[0], args[1]);
        n = input.getN();
        m = input.getM();
        r = input.getR();
        p = input.getP();
        jucatori = input.getJucatori();
        harta = input.getHarta();
        runde = input.getRunde();

        //Runde joc
        for (i = 0; i < r; i++) {
            //Mutarea jucatorilor si declaram ca nu sunt in lupta
            for (j = 0; j < p; j++) {
                jucatori.get(j).setDmgFaraBonus(0);
                if (!jucatori.get(j).getMort()) {
                    jucatori.get(j).setSeLupta(false);
                    jucatori.get(j).muta(runde.get(i).charAt(j));
                    jucatori.get(j).setTipTeren(harta.get(jucatori.get(j).getX()).
                                                charAt(jucatori.get(j).getY()));
                    jucatori.get(j).overtime();
                    jucatori.get(j).paralizatRunda();
                }
            }

            //Selectam luptele intre jucatori.
            for (j = 0; j < p; j++) {
                for (k = j; k < p; k++) {
                    if (j != k) {
                        jucatori.get(j).cineLupta(jucatori.get(k));
                    }
                }
            }

        }

        input.afisare(jucatori, args[0], args[1]);
    }
}
