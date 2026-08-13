package Experiences_And_OldPapers.Set0001;

import java.util.Arrays;
import java.util.PriorityQueue;

/*  Question:
There are N players in shuffled order, if they are in ascending
order, the middle one got the purple cap, find who is having the
purple cap in the given array.
Ex:
Input :[5.5,2.3,1.4,3.4,4.2]
Output : 3.4

Related Leetcode Problem : 215. Kth Largest Element in an Array
 */
public class PurpleCap {
    public static void main(String[] args) {

        double[] arr1 = {5.5,2.3,1.4,3.4,4.2};
        double[] arr2 = {3,2,1,5,6,4,7};
        double[] arr3 = {3,2,3,1,2,4,5,5,6};
        double[] arr4 = {};

        System.out.println(findPurpleCapOptimal(arr1));
        System.out.println(findPurpleCapOptimal(arr2));
        System.out.println(findPurpleCapOptimal(arr3));

     /*   System.out.println(findPurpleCapBetter(arr1));
        System.out.println(findPurpleCapBetter(arr3));
        System.out.println(findPurpleCapBetter(arr4));

      */

     /*   System.out.println(findPurpleCapBrute(arr1));
        System.out.println(findPurpleCapBrute(arr2));
        System.out.println(findPurpleCapBrute(arr3));
        System.out.println(findPurpleCapBrute(arr4));

      */

    }

    /*
    Brute Force : Sort the array and return the middle element
    T(N) = O(N log N)
    S(N) = O(1)
     */
    private static double findPurpleCapBrute(double[] arr1) {
                if(arr1 == null || arr1.length == 0)
                {
                    System.out.println("Array is empty");
                    return -1;
                }

                if(arr1.length % 2 == 0)
                {
                    System.out.println("Cannot find Middle : Array is of Even size");
                    return -1;
                }

                Arrays.sort(arr1);
                int midIndex = arr1.length / 2;
                return arr1[midIndex];
    }

/*
Better Approach: maintain a collection of only the largest elements in the array using minHeap
T(N) = O(N log K)
S(N) = O(K)
 */
    public static double findPurpleCapBetter(double[] arr){

        if(arr == null || arr.length == 0)
        {
            System.out.println("Array is empty");
            return -1;
        }

        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        int n = arr.length;
        int minSize = n - n/2; // if n = 5 , minSIze = 3 , so 3 elements in minHeap

        for(double num: arr)
        {
            minHeap.add(num);

            if(minHeap.size() > minSize)
                minHeap.poll();
        }

        return minHeap.peek();
    }


/*
Optimal Approach: Using Quick Select Sorting Method
T(N) = 0(N) , O(N^2)
S(N) = O(1)
 */
    public static double findPurpleCapOptimal(double[] arr)
    {
        int n = arr.length;
        int low = 0, high = n - 1;
        while(low < high)
        {
            int pivot = findPivot(arr,low,high);

            if(pivot == n / 2)
                return arr[pivot];
            else if(pivot > n / 2)
                high = pivot - 1;
            else
                low = pivot + 1;
        }
        return -1;
    }

    public static int findPivot(double[] arr,int low, int high)
    {
        double pivot = arr[high];
        int right = 0, left = 0;

        while(right < high)
        {
            if(arr[right] <= pivot)
            {
                swap(arr, right, left);
                right++;
                left++;
            }
            else
                right++;
        }
        swap(arr,left,high);
        return left;
    }

    public static void swap(double[] arr, int n, int m)
    {
        double temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }


}
