package A7_5100;

import java.util.Arrays;
import java.util.Random;

public class SumValue {

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr) {
        if (arr == null || arr.length <= 0)
            return;
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr) {
        final long[] results = new long[4];
        Thread[] threads = new Thread[4];
        for (int i = 0, start = 0; i < results.length; i++, start += arr.length / threads.length) {
            int finalStart = start;
            int finalEnd = i == results.length - 1 ? arr.length : start + arr.length / threads.length;
            int finalI = i;
            threads[i] = new Thread(() -> sum(arr,
                    finalStart,
                    finalEnd, results, finalI));
            threads[i].start();
        }
        try {

            for (Thread thread : threads) {
                if (thread != null)
                    thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return Arrays.stream(results).sum();
    }

    static private void sum(int[] arr, int start, int end, long[] r, int location) {
        for (int i = start; i < end; i++) {
            r[location] += arr[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}
