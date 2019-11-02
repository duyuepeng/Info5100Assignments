package A7_5100;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Q2 {
    public static void decode(InputStream is, OutputStream os) throws IOException {
        StringBuilder sb = new StringBuilder();
        PrintStream ps = new PrintStream(os);
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> stack_nums = new Stack<>();
        int num = 0;
        while (true) {
            int x = is.read();
            if (x == -1)
                break;
            char c = (char) x;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                stack_nums.push(num);
                num = 0;
                stack.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                stack.peek().append(new String(new char[stack_nums.pop()]).replace("\0", sb.toString()));
                sb = stack.pop();
                if(stack.isEmpty()){
                    ps.print(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
                num = 0;
            }
        }
        ps.print(sb.toString());
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
            decode(input, output);
        } catch (IOException e) {
            System.out.println("An exception occurred when processing input arguments " + Arrays.toString(args) + ".");
        }
    }
}
