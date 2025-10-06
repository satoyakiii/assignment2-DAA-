package algorithms;

import metrics.PerformanceTracker;

public class BoyerMoore {

    // Оптимизированная версия: меньше сравнений и проверок
    public static Integer findMajorityElement(int[] arr, PerformanceTracker t) {
        if (arr == null || arr.length == 0) return null;

        int candidate = arr[0];
        int count = 1;
        t.incrementAssignments(2);
        t.incrementArrayAccesses();

        for (int i = 1; i < arr.length; i++) {
            t.incrementArrayAccesses();
            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0 && i < arr.length - 1) {
                    candidate = arr[i + 1];
                    count = 1;
                    t.incrementAssignments(2);
                    i++; // сразу пропускаем следующий элемент — микрооптимизация
                }
            }
            t.incrementComparisons();
        }

        // Проверяем только если count > 0
        if (count <= 0) return null;

        int freq = 0;
        for (int num : arr) {
            if (num == candidate) freq++;
            t.incrementComparisons();
        }

        return (freq > arr.length / 2) ? candidate : null;
    }
}
