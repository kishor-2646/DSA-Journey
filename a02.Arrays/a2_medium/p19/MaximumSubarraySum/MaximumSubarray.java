package a1_easy.p19.MaximumSubarray;

public class MaximumSubarray {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Three Nested Loops
    // Calculate sum of every possible subarray and
    // track the maximum sum.
    // T(n) = O(n³), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int maxSubarrayBrute(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Better – Prefix Sum
    // Compute prefix sum array, then try all (i, j)
    // pairs using prefix sum difference.
    // T(n) = O(n²), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static int maxSubarrayPrefixSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                maxSum = Math.max(maxSum, prefix[j] - prefix[i]);
            }
        }
        return maxSum;
    }

    // ─────────────────────────────────────────────
    // Approach 3: Optimal – Kadane's Algorithm
    // Core Idea: "Is it better to extend the previous
    // subarray, or start a new subarray from here?"
    //
    // Observation:
    //   If currentSum becomes negative → discard it
    //   and start fresh (it only reduces future sums).
    //
    // Maintain:
    //   currentSum → max subarray sum ending at current index
    //   maxSum     → global maximum
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int maxSubarrayKadane(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {5, 4, -1, 7, 8};

        System.out.println("Brute      nums1: " + maxSubarrayBrute(nums1));       // 6
        System.out.println("PrefixSum  nums1: " + maxSubarrayPrefixSum(nums1));   // 6
        System.out.println("Kadane     nums1: " + maxSubarrayKadane(nums1));      // 6

        System.out.println("Kadane     nums2: " + maxSubarrayKadane(nums2));      // 23
    }
}
