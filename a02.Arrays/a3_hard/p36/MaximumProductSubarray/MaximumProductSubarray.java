package arrays.hard.p36.MaximumProductSubarray;

public class MaximumProductSubarray {

    // ─────────────────────────────────────────────
    // Given an integer array nums, find the subarray
    // with the largest product and return its product.
    //
    // Key insight: Negative * Negative = Positive
    // So we track BOTH max and min product at each step.
    // A negative number can flip min to max.
    //
    // Optimal: Track prefix and suffix products.
    // Reset to 1 when product becomes 0 (zero breaks chains).
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────

    // Approach 1: Brute Force
    // T(n) = O(n²), S(n) = O(1)
    public static int maxProductBrute(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }

    // Approach 2: Optimal — Prefix & Suffix / Track max and min
    // At each step, maintain the max and min product ending here.
    // Swap max and min when current element is negative.
    // T(n) = O(n), S(n) = O(1)
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result  = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // When multiplied by negative, max becomes min and vice versa
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            result = Math.max(result, maxProd);
        }

        return result;
    }

    // Approach 3: Prefix-Suffix (elegant alternative)
    // Traverse left to right (prefix) and right to left (suffix).
    // Reset product to 1 when it hits 0.
    // Answer is max of all prefix and suffix products.
    public static int maxProductPrefixSuffix(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;

        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            result = Math.max(result, Math.max(prefix, suffix));

            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));     // 6
        System.out.println(maxProduct(new int[]{-2, 0, -1}));       // 0
        System.out.println(maxProduct(new int[]{-2, 3, -4}));       // 24
        System.out.println(maxProductPrefixSuffix(new int[]{2, 3, -2, 4})); // 6
    }
}
