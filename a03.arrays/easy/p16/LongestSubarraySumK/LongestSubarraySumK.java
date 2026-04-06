package easy.p16.LongestSubarraySumK;

import java.util.HashMap;

public class LongestSubarraySumK {

    // Brute Force: Check all possible subarrays
    // T(n) = O(n²), S(n) = O(1)
    public static int longestSubarrayBrute(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    // Optimal: Prefix Sum + HashMap
    // Works for arrays with both positive and negative numbers.
    //
    // Key insight:
    //   prefixSum[i] - prefixSum[j] = k
    //   => prefixSum[j] = prefixSum[i] - k
    //
    // If at index i we have seen (prefixSum - k) before at index j,
    // then subarray from j+1 to i has sum = k.
    // HashMap stores: { prefixSum -> earliest index seen }
    // Use putIfAbsent to keep earliest index (for longest subarray).
    //
    // T(n) = O(n), S(n) = O(n)
    public static int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Entire subarray from 0 to i sums to k
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // Check if (prefixSum - k) was seen before
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }

            // Store only if not already present (earliest index = longest subarray)
            map.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5};
        System.out.println(longestSubarray(arr1, 5)); // Output: 2

        int[] arr2 = {-1, 1, 1};
        System.out.println(longestSubarray(arr2, 1)); // Output: 3
    }
}
