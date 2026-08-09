class Solution {

    // using Quick select approach T(n) = 0(n) , O(n * n)  S(n) = O(1)
     public int findKthLargest(int[] nums, int k) {
                int n = nums.length;

                int low = 0, high = n - 1;
                int target = n - k;

                while(low <= high)
                {
                    int pivot = partition(nums, low, high);

                    if(pivot == target)
                        return nums[pivot];
                    else if(pivot < target)
                        low = pivot + 1;
                    else
                        high = pivot - 1;
                }
                return -1;    
     }

     public int partition(int[] nums, int left, int right)
     {
        int i = left;
        int pivot = nums[right];

        for(int j = left; j < right; j++)
        {
            if(nums[j] < pivot)
            {
                swap(nums, j, i);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
     }

     public void swap(int[] nums,int n, int m)
     {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
     }
  
  
  
  
  
  
   /*  
            Using MinHeap version T(n) = O(n log K) , S(n) = O(k)
   
   public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int n: nums)
        {
            minHeap.add(n);

            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    } */
}