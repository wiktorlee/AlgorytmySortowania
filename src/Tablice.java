import java.util.Random;

public class Tablice {

    public static int[] generujTablice(int rozmiarTablicy) {
        int[] tablica = new int[rozmiarTablicy];


        for (int i = 0; i < rozmiarTablicy; i++) {          //Tworzenie tablicy z elementami od 1 do n
            tablica[i] = i + 1;
        }


        Random rand = new Random();

        for (int i = rozmiarTablicy - 1; i > 0; i--) {      //mieszanie tablicy (Fisher-Yates Shuffle)
            int j = rand.nextInt(i + 1);
            zamien(tablica, i, j);
        }
        return tablica;
    }

    public static int[] przygotujWariant(int[] tablica, double wariant) {
        int[] kopia = tablica.clone();
        if (wariant == -1.0) {
            java.util.Arrays.sort(kopia);
            odwrocTablice(kopia);

        } else {
            int granica = (int) (Sortowanie.ROZMIAR_TABLICY * wariant);

            java.util.Arrays.sort(kopia, 0, granica);
        }
        return kopia;
    }

    private static void odwrocTablice(int[] tablica) {
        for (int i = 0; i < tablica.length / 2; i++) {          //metoda do odwracania tablicy
            zamien(tablica, i, tablica.length - 1 - i);
        }
    }

    private static void zamien(int[] tab, int i, int j) {
        int temp = tab[i];                                      //metoda do odwracania tablicy uzywana w odwrocTablice
        tab[i] = tab[j];
        tab[j] = temp;
    }
}
