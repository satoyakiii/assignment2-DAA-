package cli;

import algorithms.BoyerMoore;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BenchmarkRunner {

    private static int[] makeArrayWithMajority(int n, int value) {
        int[] arr = new int[n];
        int k = n / 2 + 1;
        int i = 0;
        for (; i < k; i++) arr[i] = value;
        Random rnd = new Random(42);
        for (; i < n; i++) arr[i] = rnd.nextInt(1000);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        String csvPath = "docs/performance-plots/time_vs_n.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvPath))) {
            writer.println("n,time_ms,comparisons,assignments,array_accesses");

            for (int n : sizes) {
                int[] arr = makeArrayWithMajority(n, 777);
                PerformanceTracker t = new PerformanceTracker();

                long start = System.nanoTime();
                Integer res = BoyerMoore.findMajorityElement(arr, t);
                long end = System.nanoTime();

                long ms = (end - start) / 1_000_000;
                System.out.printf("n=%-6d | time=%4d ms | result=%s | cmp=%d, asg=%d, acc=%d%n",
                        n, ms, res, t.getComparisons(), t.getAssignments(), t.getArrayAccesses());

                writer.printf("%d,%d,%d,%d,%d%n",
                        n, ms, t.getComparisons(), t.getAssignments(), t.getArrayAccesses());
            }

            System.out.println("CSV file created: " + csvPath);

        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
