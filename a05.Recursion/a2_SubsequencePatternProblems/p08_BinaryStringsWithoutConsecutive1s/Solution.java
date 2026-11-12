package p08_BinaryStringsWithoutConsecutive1s;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static  List<String> generateBinaryStrings(int n) {

        List<String> result = new ArrayList<>();
        generate(n, "", result);
        return result;
    }

    public static void generate(int n, String curr, List<String> res){
        if(curr.length() == n)
        {
            res.add(curr);
            return;
        }

        generate(n, curr + "0" , res);

        if(curr.isEmpty() || curr.charAt(curr.length() - 1) != '1')
        {
            generate(n, curr + "1", res);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateBinaryStrings(3));
        System.out.println(generateBinaryStrings(2));
        System.out.println(generateBinaryStrings(4));
    }
}
