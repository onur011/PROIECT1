package main;

import fileio.FileSystem;
import ingeri.CreareInger;
import ingeri.Inger;
import jucatori.CreareJucator;
import jucatori.Jucator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Se reallizeaza citirea din fisier.
public class CitireIntrare {
    private int n, m;
    private ArrayList<String> aux = new ArrayList<String>();
    private int p;
    private ArrayList<Jucator> jucatori = new ArrayList<Jucator>();
    private int r;
    private ArrayList<String> runde = new ArrayList<String>();
    private ArrayList<ArrayList<Inger>> ingeri = new ArrayList<ArrayList<Inger>>();

    /**
     * Functia de citire a fisierului de intrare.
     * @param in Fisier de input
     * @param out Fisier de output
     */
    public void citire(final String in, final String out) throws IOException {
        CreareJucator creareJucator = CreareJucator.getInstance();
        CreareInger creareInger = CreareInger.getInstance();
        FileSystem fisier = new FileSystem(in, out);

        //Dimensiunile hartii.
        n = fisier.nextInt();
        m = fisier.nextInt();

        Harta harta = Harta.getInstance(in, out);
        //Pentru a sari peste harta
        for (int i = 0; i < n; i++) {
            aux.add(fisier.nextWord());
        }
        //Numarul de jucatori.
        p = fisier.nextInt();

        //Vector de jucatori.
        for (int i = 0; i < p; i++) {
            String str = fisier.nextWord();
            int x = fisier.nextInt();
            int y = fisier.nextInt();
            jucatori.add(creareJucator.creazaJucator(str,
                    x, y, harta.getHarta().get(x).charAt(y), i));
        }
        //Numar de runde.
        r = fisier.nextInt();

        //Tipul de mutare pentru fiecare runda.
        for (int i = 0; i < r; i++) {
            runde.add(fisier.nextWord());
        }

        for (int i = 0; i < r; i++) {
            int nrIngeri = fisier.nextInt();
            ArrayList<Inger> auxiliar = new ArrayList<Inger>();
            for (int j = 0; j < nrIngeri; j++) {
                String inger = fisier.nextWord();
                String[] tokens = inger.split(",");
                int x = Integer.parseInt(tokens[1]);
                int y = Integer.parseInt(tokens[2]);
                auxiliar.add(creareInger.creazaInger(tokens[0], x, y));
            }
            ingeri.add(auxiliar);
        }

        fisier.close();
    }

    /**
     * @return dimensiunea hartii
     */
    public int getN() {
        return this.n;
    }

    /**
     * @return dimensiunea hartii
     */
    public int getM() {
        return this.m;
    }

    /**
     * @return returneaza numarul de jucatori
     */
    public int getP() {
        return this.p;
    }

    /**
     * @return un vector de jucatori
     */
    public ArrayList<Jucator> getJucatori() {
        return this.jucatori;
    }

    /**
     * @return returneaza numarul de runde
     */
    public int getR() {
        return this.r;
    }

    /**
     * @return Returneaza un vector cu mutarile pentru fiecare runda
     */
    public ArrayList<String> getRunde() {
        return this.runde;
    }

    /**
     * @return returneaza ingerii.
     */
    public ArrayList<ArrayList<Inger>> getIngeri() {
        return this.ingeri;
    }

    /**
     * Functia de afisarea.
     * @param jucatorii jucatori
     * @param out   fisier scriere
     */
    public void afisare(final ArrayList<Jucator> jucatorii,
                        final String out) throws IOException  {

        BufferedWriter fisier = new BufferedWriter(new FileWriter(out, true));

        fisier.write("~~ Results ~~\n");

        for (int i = 0; i < jucatorii.size(); i++) {
            fisier.write(jucatorii.get(i).getTipCaracter());
            fisier.write(" ");

            if (jucatori.get(i).getMort()) {
                fisier.write("dead\n");
                continue;
            }

            fisier.write(Integer.toString(jucatorii.get(i).getNivel()));
            fisier.write(" ");
            fisier.write(Integer.toString(jucatorii.get(i).getXp()));
            fisier.write(" ");
            fisier.write(Integer.toString(jucatorii.get(i).getHp()));
            fisier.write(" ");
            fisier.write(Integer.toString(jucatorii.get(i).getX()));
            fisier.write(" ");
            fisier.write(Integer.toString(jucatorii.get(i).getY()) + "\n");

        }
        fisier.close();
    }
}
