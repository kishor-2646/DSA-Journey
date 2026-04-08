package a1_easy.p13.MaxConsecutiveOnes;

public class MaxConsecutiveOnes {

    // Optimal: Single Pass Counter
    // Traverse array, keep a running count of consecutive 1s.
    // Reset count to 0 when 0 is encountered.
    // Update max at each step.
    // T(n) = O(n), S(n) = O(1)
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums1)); // Output: 3

        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums2)); // Output: 2
    }
}
