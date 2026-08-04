class Solution {
    public int[] sortEvenOdd(int[] nums) {

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // Split
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }

        // Sort
        Collections.sort(even);                  // Ascending
        odd.sort(Collections.reverseOrder());    // Descending

        // Merge
        int e = 0;
        int o = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                nums[i] = even.get(e++);
            else
                nums[i] = odd.get(o++);
        }

        return nums;
    }
}