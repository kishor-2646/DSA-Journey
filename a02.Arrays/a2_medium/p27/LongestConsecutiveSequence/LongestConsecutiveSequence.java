package arrays.medium.p27.LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // ─────────────────────────────────────────────
    // Given an unsorted array of integers nums,
    // return the length of the longest consecutive
    // elements sequence.
    //
    // Example:
    //   nums = [100, 4, 200, 1, 3, 2]
    //   Longest consecutive sequence: [1, 2, 3, 4] → length 4
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force
    // For every element x, linearly search for x+1, x+2, x+3...
    // Since array is unsorted, each search is O(n).
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int longestConsecutiveBrute(int[] nums) {
        int n = nums.length;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int cnt = 1;

            while (linearSearch(nums, x + 1)) {
                x++;
                cnt++;
            }

            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    private static boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better — Sort the Array
    // If sorted, consecutive elements come together.
    // Traverse once:
    //   - If nums[i] - 1 == lastSmaller → extend count
    //   - If nums[i] == lastSmaller (duplicate) → skip
    //   - Else → reset count to 1
    //
    // T(n) = O(n log n) for sorting, S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int longestConsecutiveSorting(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);

        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                // extends consecutive sequence
                cnt++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                // new sequence starts
                cnt = 1;
                lastSmaller = nums[i];
            }
            // if nums[i] == lastSmaller → duplicate, skip (cnt unchanged)
            longest = Math.max(longest, cnt);
        }

        return longest;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal — HashSet
    // KEY INSIGHT: Only start counting a sequence when
    // (x - 1) is NOT in the set.
    // → That means x is the BEGINNING of a sequence.
    // This avoids redundant counting from middle elements.
    //
    // Algorithm:
    // 1. Insert all elements into a HashSet (O(1) lookup)
    // 2. For each element x:
    //    - If (x-1) NOT in set → x is sequence start
    //    - Count while (x+1) exists in set
    //    - Update max length
    //
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        Set<Integer> st = new HashSet<>();

        // Insert all elements
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        // Check each element as potential sequence start
        for (int it : st) {
            if (!st.contains(it - 1)) {
                // it is the start of a sequence
                int cnt = 1;
                int x = it;

                while (st.contains(x + 1)) {
                    x++;
                    cnt++;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums1)); // 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2)); // 9
    }
}
