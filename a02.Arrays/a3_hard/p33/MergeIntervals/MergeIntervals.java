package arrays.hard.p33.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // ─────────────────────────────────────────────
    // Given an array of intervals [start, end],
    // merge all overlapping intervals and return
    // the non-overlapping intervals that cover all
    // input intervals.
    //
    // Two intervals [a,b] and [c,d] overlap if c <= b.
    //
    // Example:
    //   [[1,3],[2,6],[8,10],[15,18]] → [[1,6],[8,10],[15,18]]
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Optimal: Sort + Linear Scan
    // Sort intervals by start time.
    // Maintain a "current" interval.
    // If next interval's start <= current end → merge (update end).
    // Else → push current to result, start new current.
    //
    // T(n) = O(n log n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlapping: extend the end if needed
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap: push current, move to next
                result.add(current);
                current = intervals[i];
            }
        }

        result.add(current); // add the last interval
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res1 = merge(intervals1);
        for (int[] r : res1) System.out.println(Arrays.toString(r));
        // [1, 6]
        // [8, 10]
        // [15, 18]

        int[][] intervals2 = {{1,4},{4,5}};
        int[][] res2 = merge(intervals2);
        for (int[] r : res2) System.out.println(Arrays.toString(r));
        // [1, 5]
    }
}
