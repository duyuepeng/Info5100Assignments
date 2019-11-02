package A7_5100;

import junit.framework.TestCase;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Q2Test extends TestCase {

    private final String input = "Q2_in.txt";
    private final String output = "Q2_out.txt";
    private final String[] cases = new String[]{"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef"};
    private final String[] out = new String[]{"aaabcbc", "accaccacc", "abcabccdcdcdef"};

    public Q2Test() {
        super();
    }


    private void createFiles() {
        try {
            for (int i = 0; i < cases.length; i++) {
                FileWriter fw = new FileWriter(i + input);
                fw.write(cases[i]);
                fw.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteFiles() {
        try {
            TimeUnit.SECONDS.sleep(1);
            for (int i = 0; i < cases.length; i++) {
                File file = new File(i + input);
                if (file.delete()) {
                    System.out.println("File " + i + input + " deleted successfully");
                } else {
                    System.out.println("Failed to delete the file " + i + input);
                }
                file = new File(i + output);
                if (file.delete()) {
                    System.out.println("File " + i + output + " deleted successfully");
                } else {
                    System.out.println("Failed to delete the file " + i + output);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void getFileOutput(StringBuilder sb, String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            sb.append(" ");
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setUp() {
        this.createFiles();
    }

    protected void tearDown() {
        this.deleteFiles();
    }

    public void testMain() {
        StringBuilder actual = new StringBuilder(), expected = new StringBuilder();
        for (int i = 0; i < cases.length; i++) {
            Q2.main(new String[]{i + input, i + output});
            this.getFileOutput(actual, i + output);
            expected.append(" " + out[i]);
        }
        assertEquals(expected.toString(), actual.toString());
    }
}