import java.util.Arrays;

public class SortingTester {
    public static void main(String[] args) {
        int[] arr = new int[Integer.parseInt(args[0])];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }

        // keep original unchanged, get a new sorted array
        long t1 = System.nanoTime();
        int[] sortedMerge = mergesort(arr);
        long t2 = System.nanoTime();
        System.out.println("Merge time: " + (t2 - t1));

        t1 = System.nanoTime();
        int[] sortedSelect = selectionSort(arr, 0);
        t2 = System.nanoTime();
        System.out.println("Selection time: " + (t2 - t1));

        t1 = System.nanoTime();
        int[] sortedInserted = insertionSort(arr);
        t2 = System.nanoTime();
        System.out.println("Insertion time: " + (t2 - t1));
        if (arr.length <= 20) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Merged:\t" + sortedMerge[i] + "\tSelected:\t" + sortedSelect[i] + "\tInserted:\t"
                        + sortedInserted[i]);
            }
        }
    }

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr, int sortStart) {
        double min = Double.POSITIVE_INFINITY;
        int minIndex = 0;
        for (int i = sortStart; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        int swap = arr[sortStart];
        arr[sortStart] = (int) min;
        arr[minIndex] = swap;

        if (sortStart == (arr.length - 1)) {
            return arr;
        } else {
            return selectionSort(arr, sortStart + 1);
        }
    }

    public static int[] mergesort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return Arrays.copyOf(arr, len);
        }

        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        int[] sortedLeft = mergesort(left);
        int[] sortedRight = mergesort(right);

        return merge(sortedLeft, sortedRight);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, il = 0, ir = 0;
        while (il < left.length && ir < right.length) {
            if (left[il] < right[ir])
                result[i++] = left[il++];
            else
                result[i++] = right[ir++];
        }
        while (il < left.length)
            result[i++] = left[il++];
        while (ir < right.length)
            result[i++] = right[ir++];

        return result;
    }
}
