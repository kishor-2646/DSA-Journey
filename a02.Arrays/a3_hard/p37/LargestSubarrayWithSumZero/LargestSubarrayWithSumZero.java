package arrays.hard.p37.LargestSubarrayWithSumZero;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithSumZero {

    // ─────────────────────────────────────────────
    // Given an array, find the length of the LARGEST
    // subarray with sum equal to 0.
    //
    // Optimal: Prefix Sum + HashMap
    // If prefixSum[i] == prefixSum[j] for i < j,
    // then subarray (i+1, j) has sum 0.
    // Store first occurrence of each prefixSum.
    // If prefixSum seen again at j → length = j - map.get(prefixSum)
    //
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int maxLen(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        // prefixSum 0 at index -1 (before array starts)
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i); // store first occurrence only
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{15, -2, 2, -8, 1, 7, 10, 23})); // 5
        System.out.println(maxLen(new int[]{1, 0, -4, 3, 1, 0}));           // 5
        System.out.println(maxLen(new int[]{1, -1}));                        // 2
    }
}
