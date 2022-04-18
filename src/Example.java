import java.io.FileNotFoundException;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        // parse dataset
        part3Test();
        try {
            int[] int10 = FileParser.parseFile("src/int10.txt");
            int[] int50 = FileParser.parseFile("src/int50.txt");
            int[] int100 = FileParser.parseFile("src/int100.txt");
            int[] int1000 = FileParser.parseFile("src/int1000.txt");
            int[] int20k = FileParser.parseFile("src/int20k.txt");
            int[] int500k = FileParser.parseFile("src/int500k.txt");
            int[] intBig = FileParser.parseFile("src/intBig.txt");
            int[] dutch = FileParser.parseFile("src/dutch.txt");

            int[][] datasets = { int10, int50, int100, int1000, int20k, int500k, intBig, dutch };
            testAlgorithms(datasets);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    

    public static void testAlgorithms(int[] dataset){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Testing sorting algorithms with dataset of size: " + dataset.length);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");

        System.out.println("QuickSort: ");
        int[] d1 = dataset.clone(); // cloning so that we don't change the original dataset
        long startTime = System.currentTimeMillis();
        Sort.quickSort(d1);
        long endTime = System.currentTimeMillis();
        boolean passed = TestSortingAlgorithms.isSorted(d1);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("");

        System.out.println("QuickSort with InsertionSort: ");
        int[] d2 = dataset.clone(); // cloning so that we don't change the original dataset
        startTime = System.currentTimeMillis();
        Sort.quickSortHybrid(d2, 10);
        endTime = System.currentTimeMillis();
        passed = TestSortingAlgorithms.isSorted(d2);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("");

        System.out.println("QuickSort Median of Three Partitioning: ");
        int[] d3 = dataset.clone(); // cloning so that we don't change the original dataset
        startTime = System.currentTimeMillis();
        Sort.quickSortMedianOfThree(d3);
        endTime = System.currentTimeMillis();
        passed = TestSortingAlgorithms.isSorted(d3);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("");

        System.out.println("3-Way Quicksort: ");
        int[] d4 = dataset.clone(); // cloning so that we don't change the original dataset
        startTime = System.currentTimeMillis();
        Sort.quickSortThreeWay(d4);
        endTime = System.currentTimeMillis();
        passed = TestSortingAlgorithms.isSorted(d4);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime)  + " ms");
        System.out.println("");

        System.out.println("InsertionSort: ");
        int[] d5 = dataset.clone(); // cloning so that we don't change the original dataset
        startTime = System.currentTimeMillis();
        Sort.insertionSort(d5);
        endTime = System.currentTimeMillis();
        passed = TestSortingAlgorithms.isSorted(d5);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime)  + " ms");
        System.out.println("");

        System.out.println("MergeSort: ");
        int[] d6 = dataset.clone(); // cloning so that we don't change the original dataset
        startTime = System.currentTimeMillis();
        Sort.mergeSort(d6);
        endTime = System.currentTimeMillis();
        passed = TestSortingAlgorithms.isSorted(d6);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("");


    }
    public static void testAlgorithms(int[][] datasets){
        for ( int[] dataset : datasets) {
            testAlgorithms(dataset);
        }
    }

    public static void part3Test(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Testing worst case scenario for Median of Three Partitioning: ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");

        int[] dataset = Sort.generatePathologicalSequence(10,10);

        System.out.println("QuickSort Median of Three Partitioning: ");
        int[] d3 = dataset.clone(); // cloning so that we don't change the original dataset
        long startTime = System.currentTimeMillis();
        Sort.quickSortMedianOfThree(d3);
        long endTime = System.currentTimeMillis();
        boolean passed = TestSortingAlgorithms.isSorted(d3);
        System.out.println("Passed: " + passed);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("");
    }

}
