import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {15, 3, 9, 8, 5, 2, 7, 1, 6};
        System.out.println("Before sorting: ");
        System.out.println(Arrays.toString(arr));

        int[] a = Sort.quickSort(arr);
        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(a));
    }
}
