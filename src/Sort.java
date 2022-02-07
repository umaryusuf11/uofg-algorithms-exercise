public class Sort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, right);
        return i+1;
    }

    /* A variant of the partition function that uses the  median-of-three partitioning scheme */
    public static int partitionMedianOfThree(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[right]) {
           swap(arr, left, right);
        }
        if (arr[left] > arr[mid]) {
            swap(arr, mid, left);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, left, mid);
        }
        swap(arr, mid, right);

        return partition(arr, left, right);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
    }
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSortHybrid(int[] arr, int cutoff) {
        quickSortWCutoff(arr, 0, arr.length - 1, cutoff);
        insertionSort(arr);
    }
    static void quickSortWCutoff(int[] arr, int left, int right, int cutoff) {
        if (left < right) {
            if (right - left + 1 < cutoff) {
                return;
            }

            int pivot = partition(arr, left, right);
            quickSortWCutoff(arr, left, pivot-1, cutoff);
            quickSortWCutoff(arr, pivot+1, right, cutoff);
        }
    }

    /* A variant of QUICKSORT using the median-of-three partitioning scheme. */
    public static void quickSortMedianOfThree(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionMedianOfThree(arr, low, high);

            quickSortMedianOfThree(arr, low, pi - 1);
            quickSortMedianOfThree(arr, pi + 1, high);
        }
    }
    public static void quickSortMedianOfThree(int[] arr) {
        quickSortMedianOfThree(arr, 0, arr.length - 1);
    }


    /* Insertion sort algorithm */
    public static void insertionSort(int[] arr, int p, int r){
        for (int i = p + 1; i < r; i++){
            for (int j = i; j > p && arr[j] < arr[j-1]; j--){
                swap(arr, j, j-1);
            }
        }
    }
    public static void insertionSort(int[] arr){
        insertionSort(arr, 0, arr.length);
    }
}
