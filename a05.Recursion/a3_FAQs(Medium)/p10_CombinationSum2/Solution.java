package p10_CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> answer = new ArrayList<>();
            backtrack(0, target, candidates, new ArrayList<Integer>(), answer);
            return answer;
    }

    public static void backtrack(int indx, int target, int[] canditates, List<Integer> curr, List<List<Integer>> answer)
    {
        if(target == 0)
        {
            answer.add(new ArrayList<>(curr));
            return;
        }

        for (int i = indx; i < canditates.length; i++)
        {
            if(i > indx && canditates[i] == canditates[i - 1])
                continue;

            if(target < canditates[i])
                break;

            curr.add(canditates[i]);
            backtrack(i + 1, target - canditates[i], canditates, curr, answer);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2};
        int[] arr2 = {10,1,2,7,6,1,5};
        int[] arr3 = {2,5,2,1,2};

        System.out.println(combinationSum2(arr, 4));
        System.out.println(combinationSum2(arr2, 8));
        System.out.println(combinationSum2(arr3, 5));
    }

}
