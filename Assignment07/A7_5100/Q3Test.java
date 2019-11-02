package A7_5100;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Q3Test extends TestCase {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private final String[] strings = new String[]{"Q3_1.txt", "Q3_2.txt"};

    private final ByteArrayOutputStream expectOut = new ByteArrayOutputStream();

    public Q3Test() {
        super();
    }

    private void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }


    private void restoreStream() {
        System.setOut(originalOut);
    }


    private void createFiles() {
        PrintStream eps = new PrintStream(expectOut);
        eps.println("There should be at least one argument. Arguments are file paths.");
        eps.println("An exception occurred when processing file a.txt.");
        try {
            Random rd = new Random();
            for (String string : strings) {
                int r = rd.nextInt(1000000);
                PrintStream ps = new PrintStream(new FileOutputStream(new File(string)));
                for (int i = 0; i < r; i++) {
                    ps.println(rd.nextDouble());
                }
                ps.close();
                eps.println("File: " + string + "; Number of Lines: " + r);
            }

        } catch (Exception e) {

        }
    }

    private void deleteFiles() {
        try {
            TimeUnit.SECONDS.sleep(1);
            for (String string : strings) {
                File file = new File(string);
                if (file.delete()) {
                    System.out.println("File " + string + " deleted successfully");
                } else {
                    System.out.println("Failed to delete the file " + string);
                }
            }

        } catch (Exception e) {

        }
    }

    protected void setUp() {
        this.setUpStream();
        this.createFiles();
    }

    protected void tearDown() {
        this.restoreStream();
        this.deleteFiles();
    }

    public void testMain() {
        Q3.main(new String[0]);
        Q3.main(new String[]{"a.txt", "Q3_1.txt", "Q3_2.txt"});
        assertEquals(expectOut.toString(), outContent.toString());
    }
}