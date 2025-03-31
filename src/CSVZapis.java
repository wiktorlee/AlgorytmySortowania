import java.io.FileWriter;
import java.io.IOException;

public class CSVZapis {
    private static final String PLIK_CSV = "wyniki.csv";

    public static void zapiszNaglowek() {
        try (FileWriter writer = new FileWriter(PLIK_CSV, false)) {
            writer.append("NumerTestu,Wariant,ShellSort,MergeSort,QuickSort\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zapiszWyniki(int numerTestu, String wariant, long shellSort, long mergeSort, long quickSort) {
        try (FileWriter writer = new FileWriter(PLIK_CSV, true)) {
            writer.append(numerTestu + "," + wariant + "," + shellSort + "," + mergeSort + "," + quickSort + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
