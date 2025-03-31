public class QuickSort {
    public static void sort(int[] tab) {
        quickSort(tab, 0, tab.length - 1);
    }

    private static void quickSort(int[] tab, int low, int high) {   // tablica, poczatek zakresu, koniec zakresu
        while (low < high) {                                        // Eliminacja głębokiej rekurencji
            int pivotIndex = medianOfThree(tab, low, high);         //wybor pivota jako mediany i przeniesienie go na koniec
            swap(tab, pivotIndex, high);
            int partitionIndex = partition(tab, low, high);         //x<pivot ->> na lewo ; x>pivot ->> na prawo


            if (partitionIndex - low < high - partitionIndex) {
                quickSort(tab, low, partitionIndex - 1);
                low = partitionIndex + 1;  // Iteracyjnie przechodzimy do drugiej części
            } else {
                quickSort(tab, partitionIndex + 1, high);
                high = partitionIndex - 1;
            }
        }
    }

    private static int partition(int[] tab, int low, int high) {
        int pivot = tab[high];              // Wybieramy pivot, który znajduje się na końcu tablicy
        int i = low - 1;                    //ostatni element ktory jest <= pivot

        for (int j = low; j < high; j++) {  //przechodzimy po wszystkim poza pivotem, jesli znajdziemy cos co jest <=, zamieniamy
            if (tab[j] <= pivot) {          // jesli element jest >= pivotowi, zwiekszamy i zamieniamy elementy tab[i] tab[j]
                swap(tab, ++i, j);
            }
        }
        swap(tab, i + 1, high);         // po wszystkim pivot trafia na wlasciwe miejsce, a indeks zwracamy
        return i + 1;
    }

    private static int medianOfThree(int[] tab, int low, int high) {
        int mid = low + (high - low) / 2;               //srodkowy element
        if (tab[low] > tab[mid]) swap(tab, low, mid);   
        if (tab[low] > tab[high]) swap(tab, low, high); // zamieniamy elementy aby były w porządku rosnącym
        if (tab[mid] > tab[high]) swap(tab, mid, high);
        return mid;
    }

    private static void swap(int[] tab, int i, int j) { //funkcja podmieniające elementy tablicy
        int temp = tab[i];                              //zmienna pomocnicza, standardowa operacja
        tab[i] = tab[j];
        tab[j] = temp;
    }
}