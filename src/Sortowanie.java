import java.util.Locale;

public class Sortowanie {
    public static final double[] WARIANTY = {0.0, 0.25, 0.5, 0.75, 0.95, 0.99, 0.997, 1.0, -1.0};
    private static final int LICZBA_TABLIC = 100;
    public static final int ROZMIAR_TABLICY = 1000000;

    public static void przeprowadzTesty() {
        CSVZapis.zapiszNaglowek();  // Zapisz nagłówek CSV
        int[][][] tabliceDanych = new int[WARIANTY.length][3][ROZMIAR_TABLICY];  // Tablica trójwymiarowa 3D,
                                                                                 // gdzie [warianty][rodzaj algorytmu][zawartosc]

        for (int t = 0; t < LICZBA_TABLIC; t++) {
            System.out.println("\n TEST DLA TABLICY " + (t + 1));
            int[] tablicaBazowa = Tablice.generujTablice(ROZMIAR_TABLICY);  //generowanie pojedynczej tablicy

            int numerTestu = t + 1;  // numer testu potrzebny przy zapisie CSV

            for (int i = 0; i < WARIANTY.length; i++) {

                String wariantText = (WARIANTY[i] == -1.0) ? "Tablica odwrotna"                           //przypisanie wariantu
                        : String.format(Locale.US, "%.3f%% posortowana", WARIANTY[i] * 100); // jesli = -1.0 to odwracamy

                System.out.println("\nWariant: " + wariantText);


                int[] wariantTablica = Tablice.przygotujWariant(tablicaBazowa, WARIANTY[i]);      // Tworzymy wariant tablicy


                tabliceDanych[i][0] = wariantTablica.clone();
                tabliceDanych[i][1] = wariantTablica.clone();   //zapelniamy tablice 3d klonami wygenerowanej tablicy
                tabliceDanych[i][2] = wariantTablica.clone();

                long[] czasy = new long[3];

                for (int j = 0; j < 3; j++) {
                    String algorytm = (j == 0) ? "ShellSort" : (j == 1) ? "MergeSort" : "QuickSort";
                    System.out.println("\n " + algorytm + ":");

                    int[] tablicaDoSortowania = tabliceDanych[i][j];  // Wybierz odpowiednią tablicę z 3D
                    long startTime = System.nanoTime();               // rozpoczecie pomiaru czasu


                    if (j == 0) Shell_Sort.sort(tablicaDoSortowania);
                    else if (j == 1) MergeSort.sort(tablicaDoSortowania);  //wybor algorytmu na podstawie drugiego parametru tablicy 3D
                    else QuickSort.sort(tablicaDoSortowania);

                    long endTime = System.nanoTime();           //zakonczenie pomiaru czasy
                    czasy[j] = endTime - startTime;

                    System.out.println("Czas wykonania: " + czasy[j] + " ns");


                    if (!czyPosortowana(tablicaDoSortowania)) {         //TEST CZY TABLICA JEST POSORTOWANA
                        System.out.println("Błąd: Tablica nie została posortowana poprawnie po algorytmie " + algorytm);
                    } else {
                        System.out.println("Tablica poprawnie posortowana po algorytmie " + algorytm);
                    }
                }


                CSVZapis.zapiszWyniki(numerTestu, wariantText, czasy[0], czasy[1], czasy[2]);
            }
        }
    }


    public static boolean czyPosortowana(int[] tablica) {       //sprawdzamy czy tablica jest posortowana
        for (int i = 0; i < tablica.length - 1; i++) {
            if (tablica[i] > tablica[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
