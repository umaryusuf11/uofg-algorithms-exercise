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

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
        return arr;
    }
    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length-1);
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


    /* Insertion sort algorithm */
    public static int[] insertionSort(int arr[], int p, int r){
        for (int i = p + 1; i < r; i++){
            for (int j = i; j > p && arr[j] < arr[j-1]; j--){
                swap(arr, j, j-1);
            }
        }
        return arr;
    }
    public static int[] insertionSort(int arr[]){
        return insertionSort(arr, 0, arr.length);
    }
}
