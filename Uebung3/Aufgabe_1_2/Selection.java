public class Selection {

    public static void selection(int[] a) {
        // Implement me!



        for(int i = 0;i < a.length;i++){
            // der Betrag von i + 1 bedeutet welcher Duchrlauf jetzt ist.
            // die aeusserste for-Schleife
            int minPos = i; // die Position des minimalen Element der letzten a.length()-(n-1) Elemente.
            int minElement = a[i]; // der Betrag des minimalen Element der letzten a.length()-(n-1) Elemente.


            for(int j = i;j < a.length;j++){// jedes Mal wird die letzten a.length() - i Elemente betrachtet.
            // die innere for-Schleife wird so verwendet, um das minimalen Element zu finden, und dessen Index(Position) zu bestimmen.
            if(j == i)
                continue;
            if(a[j] < minElement){
                minElement = a[j];
                minPos = j;
                }
            }
            if(minPos != i){
                int temp = 0; // temporary Element
                temp = a[i];
                a[i] = minElement;
                a[minPos] = temp;
            }

        }
    }

}
