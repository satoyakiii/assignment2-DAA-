package metrics;

import java.io.*;
import java.util.*;

public class PerformanceTracker {
    private long comparisons = 0;
    private long assignments = 0;
    private long arrayAccesses = 0;

    public void incrementComparisons() { comparisons++; }
    public void incrementAssignments() { assignments++; }
    public void incrementArrayAccesses() { arrayAccesses++; }

    public long getComparisons() { return comparisons; }
    public long getAssignments() { return assignments; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void printSummary() {
        System.out.printf("Comparisons: %d, Assignments: %d, Array Accesses: %d%n",
                comparisons, assignments, arrayAccesses);
    }
}
