package A7_5100;

import java.io.*;
import java.util.Stack;

public class Q1 {
    public static void reverse(FileInputStream is, FileOutputStream os) throws IOException {
        StringBuilder sb = new StringBuilder();
        PrintStream ps = new PrintStream(os);
        Stack<String> stack = new Stack<>();
        while (true) {
            int x = is.read();
            if (x == -1)
                break;
            char c = (char) x;

            switch (c) {
                case '.':
                    ps.print(sb.toString());
                    while (!stack.isEmpty()) {
                        ps.print(" ");
                        ps.print(stack.pop());

                    }
                    ps.print(c);
                    sb = new StringBuilder();
                    break;
                case ' ':
                    if(sb.length() <= 0){
                        ps.print(" ");
                        break;
                    }
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            ps.print(stack.pop());
        }
        is.close();
        os.close();
    }

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            System.out.println("There should be two arguments. The fist is the input file path and the second is the output file path.");
            return;
        }
        try {
            FileInputStream input = new FileInputStream(new File(args[0]));
            FileOutputStream output = new FileOutputStream(new File(args[1]));
            reverse(input, output);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
