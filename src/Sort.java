public class Sort {


    /* Swaps array element positions */
    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    /* Partition function for quicksort algorithm */
    public static int partition(int[] arr, int low, int high) {
        int x = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= x) {
                i++;
                arr = swap(arr, i, j);
            }
        }
        arr = swap(arr, i + 1, high);

        return i+1;
    }

    /* Quicksort Algorithm  */
    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            arr = quickSort(arr, low, pi - 1);
            arr = quickSort(arr, pi + 1, high);
        }
        return arr;
    }

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length-1);
    }

}
