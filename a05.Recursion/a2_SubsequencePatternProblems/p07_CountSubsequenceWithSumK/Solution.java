package p07_CountSubsequenceWithSumK;

public class Solution {
    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        return solve(0, 0, nums, k);
    }

    public static int solve(int i, int sum, int[] nums, int k){
        if(i == nums.length)
        {
            if(sum == k)
                return 1;

            return 0;
        }

        int pick = solve(i + 1, sum + nums[i], nums, k);
        int Notpick = solve(i + 1, sum, nums, k);

        return  pick + Notpick;
    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 5, 1};
        int[] nums2 = {4, 2, 10, 5, 1, 3};

        System.out.println(countSubsequenceWithTargetSum(nums, 10));
        System.out.println(countSubsequenceWithTargetSum(nums2, 5));

    }
}
