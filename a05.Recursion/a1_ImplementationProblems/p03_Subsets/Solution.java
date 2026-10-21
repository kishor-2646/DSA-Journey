package p03_Subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(res, curr, nums, 0);

        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int indx ){
        if(indx == nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[indx]);
        backtrack(res, curr, nums, indx + 1);

        curr.remove(curr.size() - 1);

        backtrack(res, curr, nums, indx + 1);
    }
}
