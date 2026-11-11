package p06_SubsequenceWithSumK;

public class Solution {

    public static boolean checkSubsequenceSum(int[] arr, int k) {
        return solve(0, 0, arr, k);

    }

    public static boolean solve(int indx, int sum, int[] arr, int k){

        if (sum == k) {
            return true;
        }


        if(indx == arr.length)
            return sum == k;


        return solve(indx + 1, sum + arr[indx], arr, k) || solve(indx + 1, sum, arr, k);
    }


    public static void main(String[] args) {
        int[] arr  = {10, 1, 2, 7, 6, 1, 5};
        int[] arr2 = {2, 3, 5, 7, 9};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {4, 3, 9, 2};
        System.out.println(checkSubsequenceSum(arr, 8));
        System.out.println(checkSubsequenceSum(arr2, 100));
        System.out.println(checkSubsequenceSum(arr3, 8));
        System.out.println(checkSubsequenceSum(arr4, 10));
    }
}
