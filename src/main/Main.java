package main;

import jucatori.Jucator;

import java.io.IOException;
import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        CitireIntrare intrare = new CitireIntrare();
        ArrayList<String> harta, runde;
        ArrayList<Jucator> jucatori;
        int n, m, r, p, i, j, k;

        //Se extrag informatiile utile pentru desfasurarea jocului.
        intrare.citire(args[0], args[1]);
        n = intrare.getN();
        m = intrare.getM();
        r = intrare.getR();
        p = intrare.getP();
        jucatori = intrare.getJucatori();
        harta = intrare.getHarta();
        runde = intrare.getRunde();

        //Runde joc
        for (i = 0; i < r; i++) {

            for (j = 0; j < p; j++) {
                //Daca jucatorul nu este mort
                if (!jucatori.get(j).getMort()) {
                    //Setam dmg fara bonus pe 0
                    jucatori.get(j).setDmgFaraBonus(0);
                    //Se muta jucatorii
                    jucatori.get(j).muta(runde.get(i).charAt(j));
                    //Se modifica tipul de teren pe care este jucatorul, dupa mutare.
                    jucatori.get(j).setTipTeren(harta.get(jucatori.get(j).getX()).
                                                charAt(jucatori.get(j).getY()));
                    //Se scade dmg de overtime
                    jucatori.get(j).overtime();
                    //Se verifica cat timp este jucatorul paralizat
                    jucatori.get(j).paralizatRunda();
                }
            }

            //Selectam luptele intre jucatori.
            for (j = 0; j < p - 1; j++) {
                for (k = j + 1; k < p; k++) {
                    jucatori.get(j).cineLupta(jucatori.get(k));
                }
            }
        }
        //Se afiseaza
       intrare.afisare(jucatori, args[0], args[1]);
    }
}
