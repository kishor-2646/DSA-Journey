package Experiences_And_OldPapers.Set0001;
/*
Given an array find the equilibrium position , element i is
equilibrium if arr[0 to i-1] == arr[i+1 to n-1].

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

Related Leetcode problem : 724. Find Pivot Index

 */

public class EquilibriumPosition {
    public static void main(String[] args) {
        int[] arr1 = {1,7,3,6,5,6};
        int[] arr2 = {1,2,3};
        int[] arr3 = {2,1,-1};
        System.out.println(findPivot(arr1));
        System.out.println(findPivot(arr2));
        System.out.println(findPivot(arr3));

    }

    public static int findPivot(int[] arr)
    {
        int totalSum = 0;

        for(int num: arr)
            totalSum += num;

        int leftSum = 0;

        for(int i = 0; i < arr.length; i++)
        {


            if(totalSum - leftSum - arr[i] == leftSum)
            {
                return i;
            }

            leftSum += arr[i];

        }

        return -1;
    }
}
