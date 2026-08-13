package Experiences_And_OldPapers.Set0001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
The is an Array of Strings having anagram Twins, if there are
more than 2 anagrams dont print it.
Ex:
Input :[“Maya”, “Aaym”, “Gokul”, “Lukog”, “Kogul” ]
Output : Maya Aaym
Here Gokul is anagram of 3 strings so dont print it.

Related Leetcode Problem :  49. Group Anagrams
 */

public class TwinAnagrams {
    public static void main(String[] args) {
        String[] str1 = {"Maya", "Aaym", "Gokul", "Lukog", "Kogul"};
        String[] str2 = {"eat","tea","tan","ate","nat","bat"};
        String[] str3 = {"listen", "silent", "evil", "vile", "dusty", "study", "hello" };
        String[] str4 = {  "abc", "def", "ghi", "jkl" };

        printTwinsBetter(str1);
        printTwinsBetter(str2);
        printTwinsBetter(str3);
        printTwinsBetter(str4);

        /* printTwins(str1);
        printTwins(str2);
        printTwins(str3);
        printTwins(str4);

        */
    }
/*
        Brute Force: Using nested loops
        T(N) = O(N^2 * K logK)
        S(N) = O(N)
 */
    public static void printTwins(String[] str){

        int n = str.length;
        boolean[] isVisted = new boolean[n];



        for(int i = 0; i < n; i++)
        {
            if(isVisted[i])
                continue;

            int anagramCount = 0;
            int twinInd = -1;


            for(int j = i + 1; j < n; j++)
            {
                if(!isVisted[j] && isAnagram(str[i], str[j]))
                {
                    anagramCount++;

                    if(anagramCount == 1) {
                        twinInd = j;
                    }
                    isVisted[j] = true;
                }
            }

            if(anagramCount == 1)
            {
                System.out.println(str[i]+" "+str[twinInd]);

                isVisted[i] = true;
            }
        }
    }

    public static boolean isAnagram(String str1, String str2){
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

/*
Better Approach : Using HashMap with Sorting for key generation
T(N) = O(N * K LogK)
S(N) = O(N * K)
 */
    public static void printTwinsBetter(String[] str)
    {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: str)
        {
            String key = generateKeyOptimal(s); // using optimised key generation
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        for(List<String> group: map.values())
        {
                if(group.size() == 2)
                    System.out.println(group.get(0) + " " + group.get(1));
        }
    }

    public static String generateKey(String str)
    {
        char[] ch = str.toLowerCase().toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    /*
    Optimal way to generate key take T(N) = O(K) instead of O(K logK)
    So overall T(N) = O(N * K)
     */
    public static String generateKeyOptimal(String str)
    {
        int[] freq = new int[26];
        for(char ch: str.toLowerCase().toCharArray())
        {
            freq[ch - 'a']++;
        }

        return Arrays.toString(freq);
    }
}
