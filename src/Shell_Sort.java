public class Shell_Sort {
    public static void sort(int[] tab) {
        int n = tab.length;


        int gap = 1;
        while (gap < n / 3) {             // Klasyczna sekwencja przyrostów Knutha: gap = gap * 3 + 1
            gap = gap * 3 + 1;            // Sekwencja Knutha określa przerwę gap między porównywanymi elementami
        }                           //Najpierw gap musi zostać "skonfigurowany"/ przyjąć jakąś wartośc wejściową


        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                int temp = tab[i];              //zachowujemy biezacy element, i ustawiamy indeksy zeby móc cofnąc sie o gap
                int j = i;


                while (j >= gap && tab[j - gap] > temp) {      //sprawdzamy czy nie wyjdziemy poza obszar tab; czy element oddalony o gap
                    tab[j] = tab[j - gap];                     // jest wiekszy niz temp, jesli tak to zamieniamy je miejscami
                    j -= gap;                                  //nastepnie robimy cofke w lewo o "gap" i ponawiamy sprawdzanie
                }                                              // dopóki znajdujemy elementy wieksze od gap, wykonujemy przesuwanie
                tab[j] = temp;                                  //po znalezieniu odpowiedniego miejsca(brak elementow  do zamiany
            }                                                   //wstawiamy element w nowe miejsce
            gap /= 3;                                           // po wykonaniu operacji dla zadanego gapa: zmniejszamy gap i lecimy dalej
        }                                                       // teraz juz z tablica blizsza posortowaniu
    }
}
//