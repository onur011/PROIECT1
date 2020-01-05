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
        
        Proiect etapa 2 (am utilizat github in efectuarea temei)
        
        Harta: Este implementata utilizand design pattern-ul Singleton. Aceasta returneaza un 
        arraylist de Stringuri.
        
        Se adauga 9 membri clasei Jucator (vsKnight1, vsPyromancer1, vsRogue1, vsWizard1,
        vsKnight2, vsPyromancer2, vsRogue2, vsWizard2, care reprezinta modificatorii in functie
        de rasa pentru prima si a doua abilitate, si membrul id care reprezinta pozitia initiala
        in sirul de jucatori). Pentru Pyromancer se utilizeaza doar modificatorii in functie de 
        rasa pentru prima abilitate, deoarece pyromancerul are aceleasi valori pentru ambele
        abilitati.
        
        Clasele Knight, Pyromance, Rogue, Wizard contin un nou camp strategie(), in care se poate
        apela una dintre cele doua strategi ale fiecarei clase, in functie de hp-ul jucatorului,
        in cazul in care jucatorul nu este imobilizat.
        
        Pentru aplicarea strategiei se utilizeaza design pattern-ul Strategy.
        
        Magicianul reprezinta un observer, care scrie un string in fisierul de iesire atunci cand
        este notificat. Pentru crearea magicianului se utilizeaza design pattern-urile Singleton 
        si Factory.
        
        Magicianul este notificat atunci cand moare un jucator, se spawneaza un inger, creste 
        nivelul unui jucator. De asemenea este notificat si cu efectul care il are ingerul asupra
        jucatorului.
        
        Pentru crearea ingerilor se folosesc design pattern-urile Singleton si Factory.
        In aplicarea ingerilor se utilizeaza Visitor, astfel fiecare inger poate ajuta/rani un
        knight, pyromancer, rogue, wizzard (ingerii reprezinta elementele vizitate, iar jucatorii
        sunt vizitatori).
        
        La inceputul rundei se creaza magicianul. Se adauga acesta ca observator pentru ingeri.
        
        Se afiseaza in fisierul de output runda curenta.
        
        Pe langa elementele de la prima etapa, acum se seteaza xp de la inceputul rundei, se adauga
        obsrverul fiecarui jucator si se apeleaza strategia pentru fiecare jucator.
        
        Se verifica care jucatori se lupta.
        
        Se spawneaza ingerii. Pentru fiecare inger se notifica aparitia lui si se verifica daca
        exista vreun jucator pe pozitia sa.
        
        La finalul rundei se sterg observatorii jucatorilor.
        
        
         










