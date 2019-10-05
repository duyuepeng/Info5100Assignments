package A4_5100.Q4Q5;

import java.util.Arrays;

public class Q4Q5 {
    public int[][] Q4(int[][] A, int[][] B) {
        int[][] AB = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] == 0)
                    continue;
                for (int j = 0; j < B[0].length; j++) {
                    if (B[k][j] == 0)
                        continue;
                    AB[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return AB;
    }

    public int[] Q5(String s) {
        int[] r = new int[s.length() + 1];
        int i = 0, j = s.length();
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == 'I') {
                r[k] = i++;
            } else if (s.charAt(k) == 'D') {
                r[k] = j--;
            }
        }
        r[s.length()] = i;
        return r;
    }

    public static void main(String[] args) {

        Q4Q5 task = new Q4Q5();

        System.out.println("Test For Q4: ");
        int[][] a = new int[][]{{1, 0, 0},
                {-1, 0, 3}};
        int[][] b = new int[][]{{7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}};
        System.out.println("Input: " + Arrays.deepToString(a) + ", " + Arrays.deepToString(b));
        System.out.println("Output: " + Arrays.deepToString(task.Q4(a, b)));

        System.out.println("Test For Q5: ");
        String s = "IDID";
        System.out.println("Input: " + s);
        System.out.println("Output: " + Arrays.toString(task.Q5(s)));

        System.out.printf("%2d. %20s $%.2f%n", 1, "BOOK_TYPE[i]", 0.01);
    }
}
