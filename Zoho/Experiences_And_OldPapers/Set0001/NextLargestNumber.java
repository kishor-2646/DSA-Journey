package Experiences_And_OldPapers.Set0001;

/*
You are given a sorted array of integers and a target value. Find the smallest element in the array that is strictly greater than the target.
In other words, find the next largest number after the target.
If no such element exists, return -1.

Example 1
Input:arr = [1, 3, 5, 7, 9]  target = 5
Output: 7

Example 2 — Duplicates
Input:arr = [1, 2, 2, 2, 3, 5]  target = 2
Output: 3

Example 3 — Target does not exist
Input: arr = [1, 3, 5, 7, 9]  target = 4
Output: 5

Example 4 — No next largest element
Input: arr = [1, 3, 5, 7, 9] target = 9
Output: -1
 */
public class NextLargestNumber {
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 9};
        int t1 = 5;
        int ans1 = findNextLargest(arr1,t1);
        System.out.println(ans1 != -1? arr1[ans1]: ans1);

        int[] arr2 = {1, 2, 2, 2, 3, 5};
        int t2 = 2;
        int ans2 = findNextLargest(arr2, t2);
        System.out.println(ans2 != -1? arr2[ans2]: ans2);

        int[] arr3 = {1, 3, 5, 7, 9};
        int t3 = 4;
        int ans3 = findNextLargest(arr3, t3);
        System.out.println(ans3 != -1? arr3[ans3]: ans3);

        int[] arr4 = {1, 3, 5, 7, 9};
        int t4 = 9;
        int ans4 = findNextLargest(arr4, t4);
        System.out.println(ans4 != -1? arr4[ans4]: ans4);

    }

    /*
    optimal approach : Binary Search
    T(N) = O(Log N)
    S(N) = O(1)
     */
    public static int findNextLargest(int[] arr, int t)
    {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(arr[mid] <= t)
            {
                low = mid + 1;
            }
            else
            {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }


}
