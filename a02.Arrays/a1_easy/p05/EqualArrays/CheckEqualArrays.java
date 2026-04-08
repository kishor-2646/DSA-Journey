package a1_easy.p05.EqualArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckEqualArrays {

    // ─────────────────────────────────────────────
    // Approach 1: Naive – Sort & Compare
    // Sort both arrays, compare element by element.
    // If all elements match → equal, else not.
    // T(n) = O(n log n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static boolean checkEqualNaive(int[] a, int[] b) {
        int n = a.length, m = b.length;

        if (n != m) return false;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Hashing (HashMap with Frequencies)
    // Count frequencies of a[] in a HashMap.
    // Then for each element in b[], check if it
    // exists in the map with count > 0. Decrement.
    // If any element is missing or exhausted → false.
    // Handles duplicates correctly.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static boolean checkEqual(int[] a, int[] b) {
        int n = a.length, m = b.length;

        if (n != m) return false;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Build frequency map from a[]
        for (int i = 0; i < n; i++) {
            if (map.get(a[i]) == null) {
                map.put(a[i], 1);
            } else {
                count = map.get(a[i]);
                count++;
                map.put(a[i], count);
            }
        }

        // Verify against b[]
        for (int i = 0; i < m; i++) {
            if (!map.containsKey(b[i])) return false;
            if (map.get(b[i]) == 0)     return false;

            count = map.get(b[i]);
            count--;
            map.put(b[i], count);
        }

        return true;
    }

    // ─────────────────────────────────────────────
    // Note: HashSet approach (simpler but wrong for duplicates)
    // e.g., a = [7, 2, 2], b = [1, 7] → HashSet wrongly shows true
    // because HashSet doesn't track counts.
    // Always use HashMap with frequencies for duplicates.
    // ─────────────────────────────────────────────

    public static void main(String[] args) {
        int[] a1 = {1, 2, 5, 4, 0};
        int[] b1 = {2, 4, 5, 0, 1};
        System.out.println(checkEqual(a1, b1)); // true

        int[] a2 = {1, 2, 5};
        int[] b2 = {2, 4, 15};
        System.out.println(checkEqual(a2, b2)); // false
    }
}
