package main;

import fileio.FileSystem;
import jucatori.CreareJucator;
import jucatori.Jucator;

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

    /**
     * Functia de citire a fisierului de intrare.
     * @param in Fisier de input
     * @param out Fisier de output
     */
    public void citire(final String in, final String out) throws IOException {
        CreareJucator creareJucator = CreareJucator.getInstance();
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
                    x, y, harta.getHarta().get(x).charAt(y)));
        }
        //Numar de runde.
        r = fisier.nextInt();

        //Tipul de mutare pentru fiecare runda.
        for (int i = 0; i < r; i++) {
            runde.add(fisier.nextWord());
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
     * Functia de afisarea.
     * @param jucatorii jucatori
     * @param in fisier citire
     * @param out   fisier scriere
     */
    public void afisare(final ArrayList<Jucator> jucatorii, final String in,
                        final String out) throws IOException  {
        FileSystem fisier = new FileSystem(in, out);
        for (int i = 0; i < jucatorii.size(); i++) {
            fisier.writeCharacter(jucatorii.get(i).getTipCaracter());
            fisier.writeWord(" ");

            if (jucatori.get(i).getMort()) {
                fisier.writeWord("dead");
                fisier.writeNewLine();
                continue;
            }

            fisier.writeInt(jucatorii.get(i).getNivel());
            fisier.writeWord(" ");
            fisier.writeInt(jucatorii.get(i).getXp());
            fisier.writeWord(" ");
            fisier.writeInt(jucatorii.get(i).getHp());
            fisier.writeWord(" ");
            fisier.writeInt(jucatorii.get(i).getX());
            fisier.writeWord(" ");
            fisier.writeInt(jucatorii.get(i).getY());
            fisier.writeNewLine();
        }
        fisier.close();
    }
}
