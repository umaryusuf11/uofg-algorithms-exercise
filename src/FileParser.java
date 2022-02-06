import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

    /* Read a file with integers seperated by newlines and return them as an ArrayList<Integer> */
    public int[] parseFile(String filePath) throws FileNotFoundException {
        // using ArrayList to fix size constraints
        ArrayList<Integer> al = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // add line to array
            al.add(Integer.parseInt(line));
            System.out.println(line);
        }

        // convert arraylist to array
        int[] array = new int[al.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = al.get(i);
        }
        scanner.close();
        return array;
    }


}
