package easy.p07.ArraySubset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraySubset {

    // ─────────────────────────────────────────────
    // Approach 1: Naive – Two Nested Loops
    // For each element in b[], search it in a[].
    // If found, mark it visited (set to -1 to avoid reuse).
    // If any element not found → return false.
    // T(n) = O(m * n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isSubsetNaive(int[] a, int[] b) {
        int m = a.length, n = b.length;

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (b[i] == a[j]) {
                    found = true;
                    a[j] = -1; // mark as visited to handle duplicates
                    break;
                }
            }
            if (!found) return false;
        }

        return true;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better 1 – Sorting + Two Pointer
    // Sort both arrays.
    // Use two pointers i (for a) and j (for b).
    // If a[i] < b[j] → move i forward.
    // If a[i] == b[j] → match found, move both.
    // If a[i] > b[j] → b[j] missing in a → false.
    // Return true if j == n (all b[] matched).
    // T(n) = O(m log m + n log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean isSubsetSorting(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        int m = a.length, n = b.length;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                return false; // b[j] not found in a
            }
        }

        return (j == n); // all elements of b[] matched
    }

    // ─────────────────────────────────────────────
    // Approach 3: Better 2 – HashSet
    // Add all elements of a[] to a HashSet.
    // For each element in b[], check if it's in the set.
    // Simple but FAILS for duplicates:
    //   a=[7,2,2], b=[1,7] → wrongly shows true if b has repeated elements
    // Only safe when no duplicates.
    // T(n) = O(m + n), S(n) = O(m)
    // ─────────────────────────────────────────────
    public static boolean isSubsetHashSet(int[] a, int[] b) {
        Set<Integer> hashset = new HashSet<>();

        for (int num : a) {
            hashset.add(num);
        }

        for (int num : b) {
            if (!hashset.contains(num)) return false;
        }

        return true;
    }

    // ─────────────────────────────────────────────
    // Approach 4: Better 3 – HashMap with Frequencies (Optimal for duplicates)
    // Count frequencies of a[] in a HashMap.
    // For each element in b[], check frequency > 0.
    // Decrement count after each match.
    // Handles duplicates correctly.
    // T(n) = O(m + n), S(n) = O(m)
    // ─────────────────────────────────────────────
    public static boolean isSubset(int[] a, int[] b) {
        if (b.length > a.length) return false;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            Integer count = freq.get(num);
            if (count == null || count == 0) return false;
            freq.put(num, count - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a1 = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b1 = {11, 3, 7, 1, 7};
        System.out.println(isSubset(a1, b1)); // true

        int[] a2 = {1, 2, 3};
        int[] b2 = {1, 4};
        System.out.println(isSubset(a2, b2)); // false
    }
}
