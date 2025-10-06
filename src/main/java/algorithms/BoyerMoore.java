package algorithms;

import metrics.PerformanceTracker;

public class BoyerMoore {

    public static Integer findMajorityElement(int[] arr, PerformanceTracker t) {
        if (arr == null || arr.length == 0) return null;

        int candidate = 0;
        int count = 0;

        for (int num : arr) {
            t.incrementArrayAccesses();
            if (count == 0) {
                candidate = num;
                t.incrementAssignments();
            }

            if (num == candidate) count++;
            else count--;
            t.incrementComparisons();
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
            t.incrementComparisons();
        }

        return (count > arr.length / 2) ? candidate : null;
    }
}
