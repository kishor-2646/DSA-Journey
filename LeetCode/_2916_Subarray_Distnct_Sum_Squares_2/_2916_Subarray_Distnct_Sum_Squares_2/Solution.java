package _2916_Subarray_Distnct_Sum_Squares_2;

import java.util.*;

public class Solution{
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int res = sumCounts(nums);
        System.out.println(res);
    }

    public static int sumCounts(int[] nums){
        int n = nums.length;

        long MOD = 1000000007L;
        long ans = 0;

        for(int i = 0; i < n; i++)
        {
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < n; j++)
            {
                set.add(nums[j]);
                long count = set.size();
                ans = (ans + count * count) % MOD;
            }
        }
        return (int) ans;
    }

//    public static int sumCounts(int[] nums){
//        int n = nums.length;
//
//        int MOD = 1000000007;
//        int ans = 0;
//
//        for(int i = 0; i < n; i++)
//        {
//            for(int j = i; j < n; j++)
//            {
//                HashSet<Integer> set = new HashSet<>();
//
//                for(int k = i; k <= j; k++)
//                {
//                    set.add(nums[k]);
//                }
//
//                int count = set.size();
//                ans += (count * count) % MOD;
//            }
//        }
//
//        return ans;
//    }

}