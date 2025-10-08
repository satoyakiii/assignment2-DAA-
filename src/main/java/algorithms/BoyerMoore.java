package algorithms;

import metrics.PerformanceTracker;

public class BoyerMoore {

    // Find majority element using Boyer-Moore Voting Algorithm
    public static Integer findMajorityElement(int[] arr, PerformanceTracker t) {
        if (arr == null || arr.length == 0) return null;

        int candidate = 0;
        int count = 0;

        // First pass: finding the candidate
        for (int num : arr) {
            t.incrementArrayAccesses(); // track accesses
            if (count == 0) {
                candidate = num;
                t.incrementAssignments(); // track assignment
            }

            // Voting phase: increasing or decreasing the count
            if (num == candidate) count++;
            else count--;
            t.incrementComparisons(); // track comparisons
        }

        // Second pass: validate the candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
            t.incrementComparisons(); // track comparisons
        }

        // Return candidate if it's the majority, otherwise null
        return (count > arr.length / 2) ? candidate : null;
    }
}
