package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreTest {

    @Test
    void majorityExists() {
        int[] arr = {3,3,4,2,3,3,5};
        var t = new PerformanceTracker();
        assertEquals(3, BoyerMoore.findMajorityElement(arr, t));
    }

    @Test
    void noMajority() {
        int[] arr = {1,2,3,4,5};
        var t = new PerformanceTracker();
        assertNull(BoyerMoore.findMajorityElement(arr, t));
    }

    @Test
    void singleElement() {
        int[] arr = {7};
        var t = new PerformanceTracker();
        assertEquals(7, BoyerMoore.findMajorityElement(arr, t));
    }

    @Test
    void emptyArray() {
        int[] arr = {};
        var t = new PerformanceTracker();
        assertNull(BoyerMoore.findMajorityElement(arr, t));
    }
}
