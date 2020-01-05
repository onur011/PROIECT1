package main;

import magician.Magician;
import magician.CreareMagician;
import ingeri.Inger;
import jucatori.Jucator;
import utile.Constante;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        CitireIntrare intrare = new CitireIntrare();
        ArrayList<String>  runde;
        Harta harta = Harta.getInstance(args[0], args[1]);
        ArrayList<Jucator> jucatori;
        ArrayList<ArrayList<Inger>> ingeri;
        int n, m, r, p, i, j, k;

        Constante constante = new Constante();
        //Se memoreaza calea fisierului de iesire.
        constante.out(args[1]);

        //Se extrag informatiile utile pentru desfasurarea jocului.
        intrare.citire(args[0], args[1]);
        n = intrare.getN();
        m = intrare.getM();
        r = intrare.getR();
        p = intrare.getP();
        jucatori = intrare.getJucatori();
        runde = intrare.getRunde();
        ingeri = intrare.getIngeri();

        //Runde joc
        for (i = 0; i < r; i++) {
            //Se creaza magicianul
            CreareMagician creareMagician = CreareMagician.getInstance();
            Magician magician = creareMagician.creazaMagician();

            BufferedWriter fisier = new BufferedWriter(new FileWriter(args[1], true));
            fisier.write("~~ Round " + Integer.toString(i + 1) + " ~~\n");
            fisier.close();

            //Se adauga observer pentru ingeri
            for (Inger inger : ingeri.get(i)) {
                inger.adaugaObserver(magician);
            }

            for (j = 0; j < p; j++) {
                //Se adauga observerul tuturor jucatorilor
                jucatori.get(j).adaugaObserver(magician);
                jucatori.get(j).inceputDeRunda();
                //Se seteaza xp de la inceputul rundei.
                jucatori.get(j).setXpInitial(jucatori.get(j).getXp());
                //Daca jucatorul nu este mort
                if (!jucatori.get(j).getMort()) {
                    //Setam dmg fara bonus pe 0
                    jucatori.get(j).setDmgFaraBonus(0);
                    //Se muta jucatorii
                    jucatori.get(j).muta(runde.get(i).charAt(j));
                    if (jucatori.get(j).getX() >= 0 && jucatori.get(j).getY() >= 0) {
                        //Se modifica tipul de teren pe care este jucatorul, dupa mutare.
                        jucatori.get(j).setTipTeren(harta.getHarta().get(jucatori.get(j).getX()).
                                charAt(jucatori.get(j).getY()));
                    }
                    //Se scade dmg de overtime
                    jucatori.get(j).overtime();
                    //Se aplica strategia
                    jucatori.get(j).strategie();
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

            for (Inger inger : ingeri.get(i)) {
                //Se norifica observatorii in legatura cu aparitia ingerului.
                inger.spawn();

                for (Jucator jucatorAux : jucatori) {
                    jucatorAux.esteInger(inger);
                }
            }
            BufferedWriter fisier1 = new BufferedWriter(new FileWriter(args[1], true));
            fisier1.write("\n");
            fisier1.close();

            //Se sterge observerul tuturor jucatorilor.
            for (j = 0; j < p; j++) {
                jucatori.get(j).stergeObserver(magician);
            }

        }

        //Se afiseaza
        intrare.afisare(jucatori, args[1]);
    }
}
