package easy.p11.MoveZeroes;

import java.util.*;



public class MoveZerosToEnd {

    // Function to move zeroes to the end
    static void moveZeroes(int[] nums) {
        // Pointer to the first zero
        int j = -1;

        // Find the first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero found, return
        if (j == -1) return;

        // Start from the next index of first zero
        for (int i = j + 1; i < nums.length; i++) {
            // If current element is non-zero
            if (nums[i] != 0) {
                // Swap with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j to next zero
                j++;
            }
        }
    }
    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        // Print the result
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }
}
