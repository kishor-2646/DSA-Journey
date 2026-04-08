package a1_easy.p11.MoveZeroes;

public class MoveZeroes {

    // Brute Force: Extra array approach
    // Move non-zero elements to a new array, fill rest with 0s, copy back
    public static void moveZeroesBrute(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[j++] = nums[i];
            }
        }

        // Fill remaining with 0s
        while (j < n) {
            temp[j++] = 0;
        }

        // Copy back
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // Optimal: Two Pointer in-place approach
    // j tracks position for next non-zero element
    // i traverses the array; if non-zero found, write at j and increment j
    // After loop, fill remaining positions with 0s
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        int zeroes = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            } else {
                zeroes++;
            }
        }

        // Fill zeroes at the end from the back
        int k = n - 1;
        for (int i = 0; i < zeroes; i++) {
            nums[k] = 0;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0
    }
}
