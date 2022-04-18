public class Sort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Partition Functions */
    private static int partition(int[] arr, int left, int right) {
        // influenced by the partition pseudocode in lecture 7
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
    private static int medianOfThreePartition(int[] arr, int left, int right) {
        // get the middle index
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
        swap(arr, mid, right - 1);

        return partition(arr, left, right - 1);
    }
    private static int[] threeWayPartition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int p1 = left;
        int mid = left;
        int p2 = right;

        while (mid < p2 + 1) {
            if (arr[mid] < pivot) {
                swap(arr, p1++,mid++);
                continue;
            }
            if(arr[mid] == pivot) {
                mid++;
                continue;
            }
            if(arr[mid] > pivot) {
                swap(arr,mid,p2--);
                continue;
            }
        }
        return new int[]{p1,p2};
    }


    /* Quick Sorts */
    public static void quickSort(int[] arr, int left, int right) {
        // influenced by the quicksort pseudocode in lecture 7
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
    }
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    // quicksort with cutoff returns an almost sorted array, then run insertion sort on it.
    public static void quickSortHybrid(int[] arr, int cutoff) {
        quickSortWCutoff(arr, 0, arr.length - 1, cutoff);
        insertionSort(arr);
    }
    private static void quickSortWCutoff(int[] arr, int left, int right, int cutoff) {
        if (left < right) {
            // if the number of elements is less than the cutoff, skip.
            if (right - left + 1 < cutoff) {
                return;
            }

            int pivot = partition(arr, left, right);
            quickSortWCutoff(arr, left, pivot-1, cutoff);
            quickSortWCutoff(arr, pivot+1, right, cutoff);
        }
    }

    public static void quickSortMedianOfThree(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = medianOfThreePartition(arr, low, high);

            quickSortMedianOfThree(arr, low, pivot - 1);
            quickSortMedianOfThree(arr, pivot + 1, high);
        }
    }
    public static void quickSortMedianOfThree(int[] arr) {
        quickSortMedianOfThree(arr, 0, arr.length - 1);
    }

    public static void quickSortThreeWay(int[] arr, int left, int right) {
        if (left < right) {
            int[] pis = threeWayPartition(arr, left, right);
            int p1 = pis[0];
            int p2 = pis[1];

            quickSortThreeWay(arr,left, p1-1);
            quickSortThreeWay(arr,p2+1,right);
        }

    }
    public static void quickSortThreeWay(int[] arr) {
        quickSortThreeWay(arr, 0, arr.length - 1);
    }

    /* Insertion Sort From Lab1 */
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int j = 1; j < n; j++){
            int key = arr[j];
            int i = j-1;
            while ((i >= 0) && (arr[i] > key)){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }

    /* Merge Sort From Lab 2 */
    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++)
            L[i] = a[p + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[q + 1 + j];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
    }
    public static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    /* Part 3 */
    private static boolean exists(int x, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }
    public static int[] generateRandomIntArray(int size, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size - 1; i++) {
            boolean added = false;
            while (!added) {
                int rand = (int) (Math.random() * max);
                if (!exists(rand, arr)) {
                    arr[i] = rand;
                    added = true;
                }
            }
        }
        return arr;
    }
    private static int smallest(int[] arr){
        int smallest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest]) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static int[] organiseWorstCaseMedianQuickSort(int[] arr) {
        int x = smallest(arr);
        // x is already equal the smallest value. set y and z to x to avoid looping through the array again.
        int y = x;
        int z = x;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[x]) {
                x = i;
            }
        }
        swap(arr, x, 0);

        for (int j = 0; j < arr.length; j++) {
            // the first biggest is already in the first position
            if (arr[j] > arr[y] && arr[j] != arr[0]) {
                y = j;
            }
        }
        swap(arr, y, arr.length / 2);

        for (int k = 0; k < arr.length; k++) {
            // the first biggest is already in the first position and the second biggest is already in the mid position
            if (arr[k] > arr[z] && arr[k] != arr[0] && arr[k] != arr[arr.length / 2]) {
                z = k;
            }
        }
        swap(arr, z, arr.length - 1);

        return arr;
    }

    public static int[] generatePathologicalSequence(int size, int max) {
        int[] arr = generateRandomIntArray(size, max);
        arr = organiseWorstCaseMedianQuickSort(arr);

        return arr;
    }
}
