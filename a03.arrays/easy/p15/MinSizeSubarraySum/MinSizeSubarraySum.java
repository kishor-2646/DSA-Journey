package easy.p15.MinSizeSubarraySum;

public class MinSizeSubarraySum {

    // Brute Force: Check all possible subarrays
    // T(n) = O(n²), S(n) = O(1)
    public static int minSubArrayLenBrute(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // Optimal: Sliding Window
    // Since all numbers are positive:
    //   - Once sum >= target, adding more elements only makes it worse (sum increases)
    //   - So shrink from the left to find minimum length window
    // T(n) = O(n), S(n) = O(1)
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Follow-up O(n log n): Prefix Sum + Binary Search
    // Since all numbers are positive, prefix sum is strictly increasing → binary search applicable
    // T(n) = O(n log n), S(n) = O(n)
    public static int minSubArrayLenLogN(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int required = prefix[i] + target;
            int j = lowerBound(prefix, required);
            if (j != -1) {
                minLen = Math.min(minLen, j - i);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(minSubArrayLen(target, nums));    // Output: 2
        System.out.println(minSubArrayLenLogN(target, nums)); // Output: 2
    }
}
