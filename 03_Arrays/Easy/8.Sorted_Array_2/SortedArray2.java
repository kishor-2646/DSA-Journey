class Solution {
    // Function to check if the array is sorted
    public boolean isSorted(int[] nums) {
       int n = nums.length;
       int count = 0;

       for(int i = 0; i < n-1; i++)
       {
        if(nums[i] > nums[i + 1])
        count++;
       }

       if(count > 1)return false;
       else if(count == 1 && nums[n-1] > nums[0])return false;

       return true;
    }
}

public class SortedArray2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Solution obj = new Solution();
        
        // Output result
        System.out.println(obj.isSorted(arr) ? "True" : "False");
    }
}
