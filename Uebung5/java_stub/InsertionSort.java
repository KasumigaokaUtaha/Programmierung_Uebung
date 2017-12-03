import java.util.Random;
import java.util.Arrays;

public class InsertionSort{

    // um es in rekursive Form umzuwandeln,
    // braucht man fuer jede for-Schleife eine Methode,
    // also eine Methode geht von vorne nach hinter
    // um alle Elemente zu sortieren,
    // und der andere geht umgekehrt,
    // um die Eigenschaft des sortierten Bereiches aufzubewahren
    public static int[] sortR(int[] arr) {
        // TODO
        sortHilfeNachHinter(arr, 1, arr.length);
        return arr;
    }

    // Hilfsmethoden hier einfuegen.
    public static void sortHilfeNachHinter(int[] arr, int index, int length){
        if(0 < index && index <= length - 1){
            if(arr[index] < arr[index - 1]){
                // tauschen zwei Elemente
                // da es jetzt die Eigenschaft des schon sortierten Bereiches
                // schaden kann, muss man das fixieren
                sortHilfeNachVorne(arr, index);
            }
            // die Eigenschaft ist fixiert
            // kann es weiter gehen
            // nach hinter sortieren
            sortHilfeNachHinter(arr, index + 1, length);
        }
    }


    public static void sortHilfeNachVorne(int[] arr, int index){
        if(index <= 0){
            return;
        }else{
            // nur wenn das hintere stehende Element kleiner
            // als das da vorne stehende Element
            // braucht man sie zu tauschen
            // und nach der Tauschung kann die Eigenschaft
            // des schon sortierten Bereiches zerstoert wird
            // deswegen muss es noch einmal nach vorne sortieren
            if(arr[index] < arr[index - 1]){
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                sortHilfeNachVorne(arr, index - 1);
            }
        }
    }
    // um es in rekursive Form umzuwandeln,
    // braucht man fuer jede for-Schleife eine Methode,
    // also eine Methode geht von vorne nach hinter
    // um alle Elemente zu sortieren,
    // und der andere geht umgekehrt,
    // um die Eigenschaft des sortierten Bereiches aufzubewahren

    public static int[] sortI(int[] arr) {
        for(int upto = 1; upto < arr.length; ++upto) {
            for(int current = upto; current > 0; --current) {
                if(arr[current] >= arr[current-1]) {
                    break;
                } else {
                    //aktuelles Element gehoert weiter vorne einsortiert
                    int tmp = arr[current];
                    arr[current] = arr[current-1];
                    arr[current-1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Random rng = new Random();
        boolean passed = true;

        passed &= test(new int[0]);
        {
            int[] arr = new int[1];
            arr[0] = rng.nextInt(20) - 7;
            passed &= test(arr);
        }
        for(int i = 0; i < 10; ++i) {
            int[] arr = new int[rng.nextInt(20)];
            for(int j = 0; j < arr.length; ++j) {
                arr[j] = rng.nextInt(20) - 7;
            }
            passed &= test(arr);
        }

        if(passed) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Some tests failed!");
        }
    }

    private static boolean test(int[] arr) {
        int[] resA = sortI(Arrays.copyOf(arr, arr.length));
        int[] resB = sortR(Arrays.copyOf(arr, arr.length));

        System.out.println(Arrays.toString(resA));
        System.out.println(Arrays.toString(resB));

        return Arrays.equals(resA, resB);
    }
}
