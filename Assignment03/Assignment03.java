import java.util.Arrays;
import java.util.Collections;

public class Assignment03 {
    public String countAndSay(int n) {
        String sequence = "1";
        for (int i = 1; i < n; i++) {
            String newSequence = "";
            int count = 1;
            for (int j = 1; j < sequence.length(); j++) {
                if (sequence.charAt(j - 1) == sequence.charAt(j)) {
                    count++;
                } else {
                    newSequence = newSequence + count + sequence.charAt(j - 1);
                    count = 1;
                }
            }
            sequence = newSequence + count + sequence.charAt(sequence.length() - 1);
        }
        return sequence;
    }

    public String reverseByWord(String target) {
        String[] arr = target.split(" ");
        Collections.reverse(Arrays.asList(arr));
        return String.join(" ", arr);
    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] r = new int[m * n];
        for (int i = 0, j = 0, k = 0, x = 0, y = 0; i < r.length; i++) {
            r[i] = matrix[j][k];
            switch (x) {
                case 0:
                    k++;
                    if (k >= n - y) {
                        k--;
                        x++;
                        j++;
                    }
                    break;
                case 1:
                    j++;
                    if (j >= m - y) {
                        j--;
                        x++;
                        k--;
                    }
                    break;
                case 2:
                    k--;
                    if (k < y) {
                        k++;
                        x++;
                        y++;
                        j--;
                    }
                    break;
                case 3:
                    j--;
                    if (j < y) {
                        j++;
                        x = 0;
                        k++;
                    }
                    break;
            }
        }
        return r;
    }

    public String zigzag(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int interval = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 | i == numRows - 1) {
                for (int j = i; j < s.length(); j += interval) {
                    result.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = false;
                while (j < s.length()) {
                    result.append(s.charAt(j));
                    if (flag) {
                        j += 2 * i;
                        flag = false;
                    } else {
                        j += (interval - 2 * i);
                        flag = true;
                    }
                }
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        Assignment03 task = new Assignment03();

        System.out.println("Test for Q5: ");
        for (int i = 1; i < 6; i++) {
            System.out.println("Input: " + i + " Output: " + task.countAndSay(i));
        }

        System.out.println("Test for Q6: ");
        String input = "baba is you";
        System.out.println("Input: " + input + " Output: " + task.reverseByWord(input));

        System.out.println("Test for Q7: ");
        System.out.println("Input: [\n[1, 2, 3, 4, 5],\n[18,19,20,21,6],\n[17,28,29,22,7],\n" +
                "[16,27,30,23,8],\n[15,26,25,24,9]\n" +
                "[14,13,12,11,10]]\n" + " Output: " + Arrays.toString(task.spiralOrder(
                new int[][]{{1, 2, 3, 4, 5},
                        {18, 19, 20, 21, 6},
                        {17, 28, 29, 22, 7},
                        {16, 27, 30, 23, 8},
                        {15, 26, 25, 24, 9},
                        {14, 13, 12, 11, 10}})));

        System.out.println("Test for Q8: ");
        System.out.println("Input: s = \"PAYPALISHIRING\" with numRows = 4 Output: " + task.zigzag("PAYPALISHIRING", 4));
    }
}