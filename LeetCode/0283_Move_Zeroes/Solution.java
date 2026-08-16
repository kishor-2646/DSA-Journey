class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int zeroes = 0;

        for(int i = 0 ; i < nums.length ; i++ )
        {
            if(nums[i] != 0)
            {
                nums[j] = nums[i];
                j++;
            }
            else
            {
                zeroes++;
            }
        }

        int k = nums.length-1;

        for(int i = 0 ; i < zeroes ; i++)
        {
            nums[k] = 0;
            k--;
        }
    }
}