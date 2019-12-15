    Veis Onur Sener
        CD 321

        Proiect etapa 1 (am utilizat github in efectuarea temei)

        In proiectarea temei se foloseste principiul double dispatch (design pattern Visitor),
        unde elementele vizitate reprezinta clasele Knight, Pyromancer, Rouge, Wizard, iar
        vizitatorii sunt tot aceleasi clase. Astfel se genereaza toate cele 16 scenarii de lupta.

        Pentru crearea unui jucator am utilizat pattern-ul Singleton (clasa CreareJucator).

        Initial, se utilizeaza metoda "citire" pentru a avea acces la informatiile din fisierul
        de intrare.

        Jucatorii sunt salvati intr-un arraylist de Jucator.

        Harta si rundele reprezinta un arraylist de String.

        Algoritmul urmator se repeta in functie de numarul de runde:

            Pentru fiecare jucator se apeleaza urmatoarele metode (daca nu este mort)

                - Se seteaza dmg primit fara bonusuri de rasa pe 0.

                - Se muta jucatorul.

                - Se modifica tipul de teren pe care se afla jucatorul

                - Se aplica dmg de overtime

                - Se verifica daca jucatorul este paralizat

            Dupa care se genereaza luptele dintre toti jucatorii, astfel incat sa se lupte
            doar o data.

            In metoda "cineLupta" se verifica daca jucatorii sunt pe aceeasi pozitie si
            daca nu sunt morti. In caz afirmativ cei doi se vor lupta.

            Aici se utilizeaza Visitor si se ajunge pe unul dintre cele 16 cazuri.

            Explic doar implementerea clasei Knight, deoarece clasele Pyromancer, Rogue si
            Wizard urmeaza acelasi principiu.

            Knight:
                * Extinde clasa Jucator si implementeaza interfata Abilitati.

                * Prezinta un constructor.

                * Prezinta o metoda "incepeLupta", care urmeaza unul din cele 4 cazuri.

                * Prezinta 4 metode "lupta".

                * Fiecare metoda "lupta" calculeaza dmg pe care il da Knight unui jucator,
                dupa care calculeaza dmg pe care il ia Knight de la jucator si in final se
                verifica starea celor 2 jucatori (se scade dmg din hp,se actualizeaza xp, nivelul,
                dupa formulele date in enunt).

                * Prezinta o metoda pentru prima abilitate si una pentru a doua. Calculeaza dmg
                dupa formulele date (clasa Wizard nu prezinta aceste metode).

                * Functia in care Knight ataca "atacaK" (jucator este victima, bonusrasa1
                reprezinta bonusul de rasa pentru prima abilitate si bonusrasa2 reprezinta bonusul
                de rasa pentru a doua abilitate). Aceasta functie calculeaza dmg pe care il ia
                jucator de la Knight, cate runde ia overtime dmg, cat dmg de overtime primeste si
                cate runde este paralizat.

        In final, se afiseaza jucatorii conform metodei prezentate in enunt (tip, nivel, xp, hp,
        pozitie).

        Membrul "dmgFaraBonus" memoreaza dmg primit de la adversar, fara bonusul de rasa. Este
        utilizat de Wizard pentru abilitatea Deflect.










