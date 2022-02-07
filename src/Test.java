import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {

        // parse dataset
        FileParser fp = new FileParser();
        try {
            int[] int10 = fp.parseFile("src/int10.txt");
            int[] int50 = fp.parseFile("src/int50.txt");
            int[] int100 = fp.parseFile("src/int100.txt");
            int[] int1000 = fp.parseFile("src/int1000.txt");
            int[] int20k = fp.parseFile("src/int20k.txt");
            int[] int500k = fp.parseFile("src/int500k.txt");
            int[] intBig = fp.parseFile("src/intBig.txt");
            int[] dutch = fp.parseFile("src/dutch.txt");

            int[][] datasets = { int10, int50, int100, int1000, int20k, int500k, intBig, dutch };
            testAlgorithms(datasets);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void testAlgorithms(int[] dataset){
        System.out.println("Testing sorting algorithms with dataset of size: " + dataset.length);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");

        System.out.println("QuickSort: ");
        int[] d1 = dataset.clone(); // cloning so that we don't change the original dataset
        long startTime = System.nanoTime();
        Sort.quickSort(d1);
        long endTime = System.nanoTime();
        boolean passed = TestSortingAlgorithms.isSorted(d1);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");

        System.out.println("QuickSort with InsertionSort: ");
        int[] d2 = dataset.clone(); // cloning so that we don't change the original dataset
        startTime = System.nanoTime();
        Sort.quickSortHybrid(d2, 10);
        endTime = System.nanoTime();
        passed = TestSortingAlgorithms.isSorted(d2);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");

        System.out.println("QuickSort Median of Three Partitioning: ");
        int[] d3 = dataset.clone(); // cloning so that we don't change the original dataset
        startTime = System.nanoTime();
        Sort.quickSortMedianOfThree(d3);
        endTime = System.nanoTime();
        passed = TestSortingAlgorithms.isSorted(d3);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");

    }

    public static void testAlgorithms(int[][] datasets){
        for ( int[] dataset : datasets) {
            testAlgorithms(dataset);
        }
    }

}
