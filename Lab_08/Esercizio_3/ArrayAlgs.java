package Esercizio_3;
//  Implementare gli algoritmi di ordinamento visti (selection sort, mergesort e insertionsort) per gli interi come metodi statici 
// di una classe ArrayAlgs.

public class ArrayAlgs {

    public static void mergesort(int[] arr) {
        int len = arr.length;

        if (len < 2 || len == 0) {
            return;
        }

        int[] arr1 = new int[(len / 2)];
        int[] arr2 = new int[len - (len / 2)];

        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, len / 2, arr2, 0, arr2.length);

        mergesort(arr1);
        mergesort(arr2);
        // fusione (metodo ausiliario)
        merge(arr, arr1, arr2);

    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i_arr = 0, i_left = 0, i_right = 0; //
        while (i_left < left.length && i_right < right.length) // per “cancellare” un elemento da b o c incremento il relativo indice
        {
            if (left[i_left] < right[i_right]) {
                arr[i_arr++] = left[i_left++];
            } else {
                arr[i_arr++] = right[i_right++];
            }
        }
        // attenzione ai due cicli che seguono...
        while (i_left < left.length) {
            arr[i_arr++] = left[i_left++];
        }
        while (i_right < right.length) {
            arr[i_arr++] = right[i_right++];
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // Trova l'indice del minimo
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Scambia l'elemento minimo con quello alla posizione i
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // Sposta gli elementi maggiori di key una posizione a destra
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Inserisce key nella posizione corretta
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 15, 2, 3, 58, 45, 6, 98, 12, 14, 4, 6};
        int[] arr2 = {10, 15, 2, 3, 58, 45, 6, 98, 12, 14, 4, 6};
        int[] arr3 = {10, 15, 2, 3, 58, 45, 6, 98, 12, 14, 4, 6};

        System.out.println("MergeSort:");
        mergesort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("\nSelectionSort:");
        selectionSort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.println("\nInsertionSort:");
        insertionSort(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
