import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Sette e mezzo.");

        int nCarta;
        double[] punteggio = { 0, 0 };
        String cont;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.println("E' il turno del giocatore");
            } else {
                System.out.println("E' il turno del banco");
            }
            do {
                cont = "N";
                nCarta = rnd.nextInt(10) + 1;
                System.out.println("Hai pescato " + nCarta);
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
        if (punteggio[0] <= 7.50 && punteggio[0] > punteggio[1]) {
            System.out.println("Hai vinto!");

        } else
            System.out.println("Hai perso!");

    }
}
