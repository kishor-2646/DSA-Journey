package p09_CombinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> answer = new ArrayList<>();
            backtrack(0, candidates, target, new ArrayList<>(), answer);
            return answer;
    }

    public static void backtrack(int indx,int[] canditates, int target, List<Integer> curr, List<List<Integer>> answer)
    {
        if(target == 0)
        {
            answer.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || indx == canditates.length)
            return;

        curr.add(canditates[indx]);

        backtrack(indx, canditates, target - canditates[indx], curr, answer);

        curr.remove(curr.size() - 1);

        backtrack(indx + 1, canditates, target, curr, answer);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int[] arr2 = {2, 3, 5};
        int[] arr3 = {2};

        System.out.println(combinationSum(arr, 7));
        System.out.println(combinationSum(arr2, 8));
        System.out.println(combinationSum(arr3, 1));
    }
}
