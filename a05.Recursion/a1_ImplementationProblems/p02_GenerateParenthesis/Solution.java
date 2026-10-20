package p02_GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        backtrack(res, curr, 0, 0, n);

        return res;
    }

    public static void backtrack(List<String> res, StringBuilder curr, int openN, int closeN, int n){
        if(openN == closeN && closeN == n)
        {
            res.add(curr.toString());
            return;
        }

        if(openN < n)
        {
            curr.append('(');
            backtrack(res, curr, openN + 1, closeN, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(closeN < openN)
        {
            curr.append(')');
            backtrack(res, curr, openN, closeN + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

}
