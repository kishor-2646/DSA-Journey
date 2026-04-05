package easy.p10.RotateArrayByK;

class Solution {
    //Rotate Array to the right by K steps
    public void rotate(int[] nums, int k) {
        int n = nums.length;
         k = k%n;

        reverse(nums , 0 , n - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , n - 1);

    }

    public void reverse(int[] arr , int left , int right)
    {
        while(left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}

public class RotateArrayByK{
     public static void main(String[] args) {
        // Create instance of Solution
        Solution sol = new Solution();

        // Input array and parameters
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        

        // Call rotateArray
        sol.rotate(nums, k);

        // Print rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}