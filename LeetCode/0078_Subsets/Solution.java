class Solution {
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