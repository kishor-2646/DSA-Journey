package arrays.medium.p28.SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // ─────────────────────────────────────────────
    // Given an array and an integer k,
    // return the TOTAL NUMBER OF SUBARRAYS
    // whose sum equals k.
    //
    // Example:
    //   nums = [1,1,1], k = 2  → Output: 2
    //   (subarrays [1,1] at index 0-1 and 1-2)
    // ─────────────────────────────────────────────

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force — 3 Nested Loops
    // Try all (i, j) pairs, compute sum from i to j.
    // T(n) = O(n³), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int subarraySumBrute(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                }
                if (sum == k) count++;
            }
        }

        return count;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better — 2 Nested Loops
    // Fix start index i, extend j while adding elements.
    // No need to recompute sum from scratch each time.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int subarraySumBetter(int[] arr, int k) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) count++;
            }
        }

        return count;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal — Prefix Sum + HashMap
    //
    // KEY INSIGHT:
    //   If prefixSum[j] - prefixSum[i] == k
    //   then subarray from i+1 to j sums to k.
    //   → We need to check: have we seen (prefixSum - k) before?
    //
    // HashMap stores: { prefixSum → frequency }
    // Initially put {0: 1} to handle subarrays starting from index 0.
    //
    // At each index:
    //   1. Update prefixSum += arr[i]
    //   2. remove = prefixSum - k
    //   3. If remove exists in map → count += map.get(remove)
    //   4. Update map: prefixSum frequency +1
    //
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int subarraySum(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        // Base case: empty subarray has sum 0
        prefixSumCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            int remove = prefixSum - k;

            // If (prefixSum - k) was seen before, those are valid subarrays
            if (prefixSumCount.containsKey(remove)) {
                count += prefixSumCount.get(remove);
            }

            // Update frequency of current prefixSum
            prefixSumCount.put(prefixSum,
                    prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2)); // 2

        int[] nums2 = {3, 1, 2, 4};
        System.out.println(subarraySum(nums2, 6)); // 2  ([3,1,2] and [2,4])

        int[] nums3 = {1, -1, 1};
        System.out.println(subarraySum(nums3, 1)); // 3
    }
}
