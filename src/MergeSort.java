public class MergeSort {
    public static void sort(int[] tab) {
        mergeSort(tab, 0, tab.length - 1);
    }

    private static void mergeSort(int[] tab, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(tab, left, mid);          //metoda rekurencyjna ktora wywoluje sama siebie az nie podzieli tablicy na czynniki pierwsze
            mergeSort(tab, mid + 1, right);//kazda zakonczona mergem, zeby zmergowac wszystkie elementy od najglebszego, a nie tylko
                                               // dwa pierwsze
            merge(tab, left, mid, right);
        }
    }

    private static void merge(int[] tab, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];      //tworzymy dwie tablice pomocnicze : lewa i prawą
        int[] rightArray = new int[n2];


        for (int i = 0; i < n1; i++) {
            leftArray[i] = tab[left + i];
        }                                   // Kopiujemy dane do tablic pomocniczych
        for (int j = 0; j < n2; j++) {
            rightArray[j] = tab[mid + 1 + j];
        }


        int i = 0, j = 0;
        int k = left;                       //indeksy pomocnicze


        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                tab[k] = leftArray[i];      // scalamy dwie tablice wsadzajac do niej mniejszy z porownywanych dwoch element
                i++;                        // jesli left>right to lewy, jesli right>lewy to prawy
            } else {
                tab[k] = rightArray[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            tab[k] = leftArray[i];      //jesli wyczerpiemy jedna z tablic pozostałą zawartosc mozna po prostu dorzucic na koniec
            i++;                        // w koncu mergujemy dwie tablice, gdzie kazda z nich jest juz posortowana przez poprzednia
            k++;                        // instancje rekurencji
        }
        while (j < n2) {
            tab[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
