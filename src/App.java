import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int seme;
        System.out.println("Sette e mezzo.");
        String[] semi = { "denari", "bastoni", "coppe", "spade" };
        int nCarta;
        String cont, risposta;
        double budget, puntata;
        budget = 100;

        do {
            boolean[] mazzo = new boolean[40];
            double[] punteggio = { 0, 0 };
            do {
                System.out.println("Budget attuale: " + budget + " euro");
                System.out.println("Quanto vuoi puntare?");
                puntata = sc.nextDouble();
                sc.nextLine();
                if (puntata <= 0 || puntata > budget) {
                    System.out.println("Puntata non valida!");
                }
            } while (puntata <= 0 || puntata > budget);

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    System.out.println(" \n E' il turno del giocatore");
                } else {
                    System.out.println("\n E' il turno del banco");
                }
                do {
                    cont = "N";
                    int index;
                    do {
                        nCarta = rnd.nextInt(10) + 1;
                        seme = rnd.nextInt(4);
                        index = (seme * 10) + nCarta - 1;
                    } while (mazzo[index]);
                    mazzo[index] = true;
                    System.out.println("Hai pescato " + nCarta + " di " + semi[seme]);
                    if (nCarta <= 7) {
                        punteggio[i] = punteggio[i] + nCarta;

                    } else {
                        punteggio[i] = punteggio[i] + 0.50;
                    }
                    System.out.println("Il punteggio attuale è: " + punteggio[i]);
                    if (i == 0) {
                        if (punteggio[0] <= 7.50) {
                            System.out.println("Vuoi continuare? (S/N)");
                            cont = sc.nextLine();
                        }

                    } else {
                        if (punteggio[i] <= 4.50) {
                            cont = "S";

                        }
                    }

                } while (punteggio[i] <= 7.50 && cont.equalsIgnoreCase("S"));
            }
            System.out.println();
            if (punteggio[0] <= 7.50 && punteggio[0] > punteggio[1]) {

                System.out.println("Hai vinto!");
                budget = budget + puntata;

            } else {
                System.out.println("Hai perso!");
                budget = budget - puntata;
            }
            risposta = "n";

            if (budget > 0) {
                System.out.println("Vuoi fare un'altra partita?");
                risposta = sc.nextLine();
            } else {
                System.out.println("Hai perso tutti i tuoi soldi!");
            }
        } while (risposta.equalsIgnoreCase("s"));
        System.out.println("La partita è terminata. Il tuo budget è di: " + budget + " euro");

        sc.close();
    }
}
