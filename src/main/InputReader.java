package main;

import fileio.FileSystem;
import jucatori.CreareJucator;
import jucatori.Jucator;

import java.io.IOException;
import java.util.ArrayList;

//Se reallizeaza citirea din fisier.
public class InputReader {
    private int n, m;
    private ArrayList<String> harta = new ArrayList<String>();
    private int p;
    private ArrayList<Jucator> jucatori = new ArrayList<Jucator>();
    private int r;
    private ArrayList<String> runde = new ArrayList<String>();

    /**
     * Functia de citire a fisierului de intrare.
     * @param in Fisier de input
     * @param out Fisier de output
     * @throws IOException .
     */
    public void citire(final String in, final String out) throws IOException {
        CreareJucator creareJucator = CreareJucator.getInstance();
        FileSystem fisier = new FileSystem(in, out);

        //Dimensiunile hartii.
        n = fisier.nextInt();
        m = fisier.nextInt();

        //Tipul de suprafata.
        for (int i = 0; i < n; i++) {
            harta.add(fisier.nextWord());
        }
        //Numarul de jucatori.
        p = fisier.nextInt();

        //Vector de jucatori.
        for (int i = 0; i < p; i++) {
            jucatori.add(creareJucator.creazaJucator(fisier.nextWord(),
                         fisier.nextInt(), fisier.nextInt()));
        }
        //Numar de runde.
        r = fisier.nextInt();

        //Tipul de mutare pentru fiecare runda.
        for (int i = 0; i < r; i++) {
            runde.add(fisier.nextWord());
        }
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
     * @return returneaza harta
     */
    public ArrayList<String> getHarta() {
        return this.harta;
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
}
