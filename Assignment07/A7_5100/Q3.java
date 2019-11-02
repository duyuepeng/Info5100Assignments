package A7_5100;

import java.io.*;
import java.util.Scanner;

public class Q3 {
    public static int countLines(InputStream is) {
        Scanner scanner = new Scanner(is);
        int count = 0;
        while (scanner.hasNext()) {
            count++;
            scanner.nextLine();
        }
        scanner.close();
        return count;
    }

    public static void main(String[] args) {
        if (args == null || args.length <= 0) {
            System.out.println("There should be at least one argument. Arguments are file paths.");
            return;
        }
        for (String arg : args) {
            try {
                System.out.println("File: "+ arg+"; Number of Lines: " + countLines(new FileInputStream(new File(arg))));
            } catch (IOException e) {
                System.out.println("An exception occurred when processing file " + arg + ".");
            }
        }
    }
}
